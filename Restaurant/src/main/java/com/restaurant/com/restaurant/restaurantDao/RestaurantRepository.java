package com.restaurant.com.restaurant.restaurantDao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.model.RestaurantVo;

@Repository
@Transactional
public interface RestaurantRepository extends CrudRepository<RestaurantVo, Long> {

	@Query(value = "select * from RESTAURANTVO where rName = :getrName AND rCity = :getrCity AND rZip=:getrZip", nativeQuery = true)
	RestaurantVo checkForObj(String getrName, String getrCity, String getrZip);

	@Modifying
	@Query(value = "DELETE FROM RESTAURANTVO where rName = :getrName AND rCity = :getrCity AND rZip=:getrZip", nativeQuery = true)
	int deleteObj(String getrName, String getrCity, String getrZip);

	@Modifying
	@Query(value = "\n"
			+ "UPDATE RESTAURANTVO SET rName = :getrName , rCity = :getrCity , rZip=:getrZip WHERE rName = :getrName AND rCity=:getrCity ;\n"
			+ "\n" + "", nativeQuery = true)
	int updateRestaurant(String getrName, String getrCity, String getrZip);
	
	
	@Query(value = "select * from RESTAURANTVO where rId=:restId",nativeQuery=true)
	List<RestaurantVo> getRestaurantByRestId(long restId);

}
