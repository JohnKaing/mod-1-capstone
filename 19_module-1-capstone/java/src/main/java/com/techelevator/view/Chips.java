package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends Products {


	public Chips(String name, BigDecimal price) {
		super(name, price);
		
		
	}
		public String getSound() {
			return "Crunch Crunch, Yum!";
				
	}
	
}