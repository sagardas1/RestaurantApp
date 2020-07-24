package com.restaurant.dto;

import com.restaurant.enums.DISH_CUISINE;
import com.restaurant.enums.DISH_TYPE;

public class DishDTO {
	
private long dishId;
	
private String rName;
	private String dishName;
	private DISH_CUISINE dishCuisine;
	private DISH_TYPE dishType;
	private double dishPrice;
	
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public DISH_CUISINE getDishCuisine() {
		return dishCuisine;
	}
	public void setDishCuisine(DISH_CUISINE dishCuisine) {
		this.dishCuisine = dishCuisine;
	}
	public DISH_TYPE getDishType() {
		return dishType;
	}
	public void setDishType(DISH_TYPE dishType) {
		this.dishType = dishType;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}

}
