package com.restaurant.serviceImplimentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.com.restaurant.restaurantDao.DishvoRepository;
import com.restaurant.com.restaurant.restaurantDao.RestaurantRepository;
import com.restaurant.dto.DishDTO;
import com.restaurant.dto.RestaurantDTO;
import com.restaurant.model.DishVo;
import com.restaurant.model.RestaurantVo;
import com.restaurant.responceConstant.ResponceConstants;
import com.restaurant.service.DishService;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	DishvoRepository dishvoRepository;

	@Autowired
	EntityManager entityManager;

	@Override
	public BaseResponce addDishesToRestaurant(DishDTO dish) {
		BaseResponce baseResponce = null;
		try {
			List<DishVo> dishVo = dishvoRepository.getDishFromDB(dish.getDishName(), dish.getrName());
			if (dishVo == null || dishVo.isEmpty()) {
				DishVo vo = new DishVo();
				vo.setDishCuisine(dish.getDishCuisine());
				vo.setDishName(dish.getDishName());
				vo.setDishPrice(dish.getDishPrice());
				vo.setDishType(dish.getDishType());
				vo.setrName(dish.getrName());
				vo.setrName(dish.getrName());
				dishvoRepository.save(vo);
				baseResponce = new BaseResponce();
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);

			} else {
				baseResponce = new BaseResponce();
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.DUPLICATE_ORDER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;
	}

	@Override
	public BaseResponce deleteDish(DishDTO dish) throws Exception {
		BaseResponce baseResponce = new BaseResponce();
		try {

			int delete = dishvoRepository.deleteObj(dish.getDishName(), dish.getrName());
			if (delete > 0) {
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;
	}

	@Override
	public BaseResponce updateDish(DishDTO dish) throws Exception {
		BaseResponce baseResponce = new BaseResponce();
		try {
			DishVo vo = new DishVo();
			vo.setDishCuisine(dish.getDishCuisine());

			vo.setDishName(dish.getDishName());
			vo.setDishPrice(dish.getDishPrice());
			vo.setDishType(dish.getDishType());
			vo.setrName(dish.getrName());

			int update = dishvoRepository.updateDish(dish.getDishName(), dish.getrName(), dish.getDishCuisine(),
					dish.getDishPrice(), dish.getDishType());
			if (update > 0) {
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;
	}

	@Override
	public List<DishVo> getDishAccoringtoCondition(Map<String, Object> searchForm) throws Exception {
		String sqlQuery = "FROM DISHVO where";
		String newSqlQuery = null;
		List<DishVo> dishVo=null;

		if (searchForm.containsKey("rName")) {
			String rName = searchForm.get("rName").toString();
			newSqlQuery = sqlQuery + " rName = '" + rName + "'";
		}

		if (searchForm.containsKey("dishName")) {
			String dishName = searchForm.get("dishName").toString();
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " OR dishName = '" + dishName + "'";
			} else {
				newSqlQuery = sqlQuery + " dishName = '" + dishName + "'";
			}

		}
		if (searchForm.containsKey("dishType")) {
			String dishType = searchForm.get("dishType").toString();
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " OR dishType = '" + dishType + "'";
			} else {
				newSqlQuery = sqlQuery + " dishType = '" + dishType + "'";
			}

		}
		if (searchForm.containsKey("dishCuisine")) {
			String dishCuisine = searchForm.get("dishCuisine").toString();
			if (Objects.nonNull(newSqlQuery)) {
				newSqlQuery = newSqlQuery + " OR dishCuisine = '" + dishCuisine + "'";
			} else {
				newSqlQuery = sqlQuery + " dishCuisine = '" + dishCuisine + "'";
			}

		}
		if (searchForm.containsKey("rZip")) {
			String rZip = searchForm.get("rZip").toString();
			Query query1 = entityManager.createNativeQuery("select rName from RESTAURANTVO where rZip=rZip");
			List<String> rnamelist = query1.getResultList();
			StringJoiner str=new StringJoiner(",");
			for(String s:rnamelist) {
				str.add(s);
				
			}
			Query query3 = entityManager.createNativeQuery("select * from DISHVO where rName in ("+str+")");
		 dishVo = query3.getResultList();

		}
		newSqlQuery="select * "+newSqlQuery;
		System.out.println("Search query = " + newSqlQuery);
		Query query = entityManager.createNativeQuery(newSqlQuery);
		List<DishVo> dishList = query.getResultList();
		
		if (searchForm.containsKey("rZip")) {
			dishList.addAll(dishVo);
		}
		return dishList;
	}

}
