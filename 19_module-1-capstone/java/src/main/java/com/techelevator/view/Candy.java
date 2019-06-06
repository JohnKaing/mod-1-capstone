package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Products {


	public Candy(String name, BigDecimal price) {
		super(name, price);
		
		
	}
		public String getSound() {
			return "Munch Munch, Yum!";
				
	}
	
}