package com.restaurant.service;

import java.util.List;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.dto.DishDTO;

public interface DishService {
	

	
	BaseResponce addDishesToRestaurant(DishDTO dish);

	BaseResponce deleteDish(DishDTO dish) throws Exception;

	BaseResponce updateDish(DishDTO dish) throws Exception;

	DishDTO getDishAccoringtoCondition(String dishName, String rName, String dishCuisine, String dishType,
			double dishPrice,long dishId)throws Exception;

}
