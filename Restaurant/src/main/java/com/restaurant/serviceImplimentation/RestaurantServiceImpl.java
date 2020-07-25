package com.restaurant.serviceImplimentation;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.com.restaurant.restaurantDao.DishvoRepository;
import com.restaurant.com.restaurant.restaurantDao.RestaurantRepository;
import com.restaurant.dto.RestaurantDTO;
import com.restaurant.model.RestaurantVo;
import com.restaurant.responceConstant.ResponceConstants;
import com.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepostory;

	@Autowired
	DishvoRepository dishvoRepository;

//	@Autowired
//	EntityManager entityManager;

	@Override

	public BaseResponce addRestaurant(RestaurantDTO restaurantDTO) throws Exception {
		BaseResponce baseResponce = null;
		try {

			RestaurantVo restObjDb = restaurantRepostory.checkForObj(restaurantDTO.getrName(), restaurantDTO.getrCity(),
					restaurantDTO.getrZip());
			if (restObjDb == null) {
				RestaurantVo restaurantVo = new RestaurantVo();
				restaurantVo.setrCity(restaurantDTO.getrCity());
				restaurantVo.setrCountry(restaurantDTO.getrCountry());
				restaurantVo.setrName(restaurantDTO.getrName());
				restaurantVo.setrPhone(restaurantDTO.getrPhone());
				restaurantVo.setrState(restaurantDTO.getrState());
				restaurantVo.setrZip(restaurantDTO.getrZip());
				restaurantRepostory.save(restaurantVo);
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
	public BaseResponce deleteRestaurant(RestaurantDTO restaurantDTO) throws Exception {
		BaseResponce baseResponce = new BaseResponce();
		try {

			int delete = restaurantRepostory.deleteObj(restaurantDTO.getrName(), restaurantDTO.getrCity(),
					restaurantDTO.getrZip());
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
	public BaseResponce updateRestaurant(RestaurantDTO restaurantDTO) throws Exception {
		BaseResponce baseResponce = new BaseResponce();
		try {
			RestaurantVo restaurantVo = new RestaurantVo();
			restaurantVo.setrCity(restaurantDTO.getrCity());
			restaurantVo.setrCountry(restaurantDTO.getrCountry());
			restaurantVo.setrName(restaurantDTO.getrName());
			restaurantVo.setrPhone(restaurantDTO.getrPhone());
			restaurantVo.setrState(restaurantDTO.getrState());
			restaurantVo.setrZip(restaurantDTO.getrZip());
			int update = restaurantRepostory.updateRestaurant(restaurantDTO.getrName(), restaurantDTO.getrCity(),
					restaurantDTO.getrZip());
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
