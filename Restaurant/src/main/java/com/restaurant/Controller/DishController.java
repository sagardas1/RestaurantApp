package com.restaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.baseResponse.BaseResponce;
import com.restaurant.dto.DishDTO;
import com.restaurant.dto.RestaurantDTO;
import com.restaurant.service.DishService;

@RestController
@RequestMapping("/dish")
public class DishController {
	
	@Autowired
	DishService dishService;
	
	@PostMapping(value="/add-dishes-to-restaurant")
	public BaseResponce addDishesToRestaurant(@RequestBody DishDTO dish){
		BaseResponce baseResponce =	dishService.addDishesToRestaurant(dish);
		return baseResponce;
	}

	@DeleteMapping(value = "/deleteDish")
	public BaseResponce deleteRestaurant(@RequestBody DishDTO dish) {
		BaseResponce baseResponce = null;
		try {

			baseResponce = dishService.deleteDish(dish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;

	}

	@PutMapping(value = "/updateDish")
	public BaseResponce updateDish(@RequestBody DishDTO dish) {
		BaseResponce baseResponce = null;
		try {

			baseResponce = dishService.updateDish(dish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseResponce;

	}
	
	@GetMapping(value = "/getdishaccoringtocondition")
	public DishDTO getDishAccoringtoCondition(
			@RequestParam(value="dishName",defaultValue="",required=false)String dishName ,
	@RequestParam(value="rName",defaultValue="",required=false)String rName,
	@RequestParam(value="dishCuisine",defaultValue="",required=false)String dishCuisine,
	@RequestParam(value="dishType",defaultValue="",required=false)String dishType,
	@RequestParam(value="dishPrice",defaultValue="0",required=false)double dishPrice,
	@RequestParam(value="dishId",defaultValue="0",required=false)long dishId){
		
		DishDTO dishDTO=null;
		try {
			dishDTO = dishService.getDishAccoringtoCondition(dishName,rName,dishCuisine,dishType,dishPrice,dishId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dishDTO;
	}
	

}
