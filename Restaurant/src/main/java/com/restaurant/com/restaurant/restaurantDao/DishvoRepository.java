package com.restaurant.com.restaurant.restaurantDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.DishVo;
import com.restaurant.model.RestaurantVo;

@Repository
@Transactional
public interface DishvoRepository  extends CrudRepository<DishVo,Long> {
	
	@Transactional
	@Query(value="select * from DISHVO where dishId=:dishId",nativeQuery=true)
	List<DishVo> getDishById(long dishId);

	@Transactional
	@Query(value="select * from DISHVO where rName=:restName AND dishName:dishName",nativeQuery=true)
	DishVo getDishFromDB(String dishName, String restName);
	
	
	
	
	

}
