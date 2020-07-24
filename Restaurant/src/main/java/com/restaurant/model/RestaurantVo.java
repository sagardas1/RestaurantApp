package com.restaurant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="RESTAURANTVO")
public class RestaurantVo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rId;

	
	private String rName;
	private String rPhone;
	private String rCity;
	private String rState;
	private String rZip;
	private String rCountry;
	
	@ManyToMany(mappedBy="restaurantList")
	private List<DishVo> dishes;
	

}
