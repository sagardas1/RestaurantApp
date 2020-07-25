package com.restaurant.service;

import java.util.List;
import java.util.Map;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.dto.DishDTO;
import com.restaurant.model.DishVo;

public interface DishService {
	

	
	BaseResponce addDishesToRestaurant(DishDTO dish);

	BaseResponce deleteDish(DishDTO dish) throws Exception;

	BaseResponce updateDish(DishDTO dish) throws Exception;

	

	List<DishVo> getDishAccoringtoCondition(Map<String, Object> searchForm) throws Exception;

}
