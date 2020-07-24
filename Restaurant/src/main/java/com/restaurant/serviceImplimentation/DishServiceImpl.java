package com.restaurant.serviceImplimentation;

import java.util.ArrayList;
import java.util.List;

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


	@Override
	public BaseResponce addDishesToRestaurant(DishDTO dish) {
		BaseResponce baseResponce=null;
		try {
			DishVo dishVo=	dishvoRepository.getDishFromDB(dish.getDishName(),dish.getrName());
			if(dishVo==null) {
				DishVo vo=new DishVo();
				vo.setDishCuisine(dish.getDishCuisine());
				vo.setDishName(dish.getDishName());
				vo.setDishPrice(dish.getDishPrice());
				vo.setDishType(dish.getDishType());
				vo.setRName(dish.getrName());
				dishvoRepository.save(vo);
				baseResponce = new BaseResponce();
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);

			} else {
				baseResponce = new BaseResponce();
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.DUPLICATE_ORDER);
			}
		}catch(Exception e) {e.printStackTrace();}
		return baseResponce;
	}
	
	@Override
	public BaseResponce deleteDish(DishDTO dish) throws Exception {
		BaseResponce baseResponce = new BaseResponce();
		try {

			int delete = dishvoRepository.deleteObj(dish.getDishName(),dish.getrName());
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
			DishVo vo=new DishVo();
			vo.setDishCuisine(dish.getDishCuisine());
			
			vo.setDishName(dish.getDishName());
			vo.setDishPrice(dish.getDishPrice());
			vo.setDishType(dish.getDishType());
			vo.setRName(dish.getrName());
			
int update = dishvoRepository.updateRestaurant(dish.getDishName(),dish.getrName(),dish.getDishCuisine(),dish.getDishPrice(),dish.getDishType());
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

}
