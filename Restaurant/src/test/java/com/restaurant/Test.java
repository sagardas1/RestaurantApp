package com.restaurant;

public class Test {
	
	public static void main(String[] args) {
		String s="Sagardas";
		if(s.substring(s.length()-2, s.length()).equals("as")) {
		s=s.substring(0,s.length()-2);
		System.out.println(s);
		}
	}
	

}
