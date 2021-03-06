package com.restaurant.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.restaurant.enums.DISH_CUISINE;
import com.restaurant.enums.DISH_TYPE;


@Entity
@Table(name = "DISHVO")
public class DishVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dishId;
	
	private String rName;
	private String dishName;
	private String dishCuisine;
	private String dishType;
	private double dishPrice;
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	public String getDishCuisine() {
		return dishCuisine;
	}
	public void setDishCuisine(String dishCuisine) {
		this.dishCuisine = dishCuisine;
	}
	public String getDishType() {
		return dishType;
	}
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}

	
}
