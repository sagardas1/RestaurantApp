package com.restaurant.com.restaurant.restaurantDao;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.enums.DISH_CUISINE;
import com.restaurant.enums.DISH_TYPE;
import com.restaurant.model.DishVo;
import com.restaurant.model.RestaurantVo;

@Repository
@Transactional
public interface DishvoRepository  extends CrudRepository<DishVo,Long> {
	
	@Transactional
	@Query(value="select * from DISHVO where dishId=:dishId",nativeQuery=true)
	List<DishVo> getDishById(long dishId);

	@Transactional
	@Query(value="select * from DISHVO where rName=:restName AND dishName=:dishName",nativeQuery=true)
	List<DishVo> getDishFromDB(String dishName, String restName);

	
	@Modifying
	@Query(value = "DELETE FROM DISHVO where rName = :getrName AND dishName=:dishName", nativeQuery = true)
	int deleteObj(String dishName, String getrName);

	

	@Modifying
	@Query(value = "Select * from DISHVO", nativeQuery = true)
	
	int updateDish(String dishName, String getrName, String dishCuisine, double dishPrice, String dishType);
	
	
	
	
	

}
