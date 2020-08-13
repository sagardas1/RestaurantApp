package com.restaurant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



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
	public long getrId() {
		return rId;
	}
	public void setrId(long rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrPhone() {
		return rPhone;
	}
	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}
	public String getrCity() {
		return rCity;
	}
	public void setrCity(String rCity) {
		this.rCity = rCity;
	}
	public String getrState() {
		return rState;
	}
	public void setrState(String rState) {
		this.rState = rState;
	}
	public String getrZip() {
		return rZip;
	}
	public void setrZip(String rZip) {
		this.rZip = rZip;
	}
	public String getrCountry() {
		return rCountry;
	}
	public void setrCountry(String rCountry) {
		this.rCountry = rCountry;
	}
	
	

}
