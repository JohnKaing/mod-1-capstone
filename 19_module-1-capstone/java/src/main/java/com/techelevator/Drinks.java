package com.techelevator;

import java.math.BigDecimal;

public class Drinks extends Products {


	public Drinks(String name, BigDecimal price) {
		super(name, price);
		
		
	}
		public String getSound() {
			return "Glug Glug, Yum!";
				
	}
	
}