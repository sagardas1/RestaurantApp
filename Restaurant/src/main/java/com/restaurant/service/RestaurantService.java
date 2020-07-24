package com.restaurant.service;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.dto.RestaurantDTO;

public interface RestaurantService {

	BaseResponce addRestaurant(RestaurantDTO restaurantDTO) throws Exception;

	BaseResponce deleteRestaurant(RestaurantDTO restaurantDTO)throws Exception;

	BaseResponce updateRestaurant(RestaurantDTO restaurantDTO)throws Exception;

}
