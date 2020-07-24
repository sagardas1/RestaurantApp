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

import lombok.Data;

@Data
@Entity
@Table(name = "DISHVO")
public class DishVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dishId;
	
	private String rName;
	private String dishName;
	private DISH_CUISINE dishCuisine;
	private DISH_TYPE dishType;
	private double dishPrice;

	
}
