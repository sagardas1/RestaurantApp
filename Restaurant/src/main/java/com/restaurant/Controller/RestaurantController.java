package com.restaurant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.dto.RestaurantDTO;
import com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping(value = "/addRestaurant")
	public BaseResponce addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		BaseResponce baseResponce = null;
		try {

			baseResponce = restaurantService.addRestaurant(restaurantDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;

	}

	@DeleteMapping(value = "/deleteRestaurant")
	public BaseResponce deleteRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		BaseResponce baseResponce = null;
		try {

			baseResponce = restaurantService.deleteRestaurant(restaurantDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;

	}

	@PutMapping(value = "/updateRestaurant")
	public BaseResponce updateRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		BaseResponce baseResponce = null;
		try {

			baseResponce = restaurantService.updateRestaurant(restaurantDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;

	}
}
