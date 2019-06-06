package com.techelevator.view;

import java.math.BigDecimal;

public class testing  {
	public static void main(String[] args) {

	Gum testGum;
	testGum = new Gum("Juicy", new BigDecimal ("1.50"));
	System.out.println("testGum is: " + testGum.getName() + " " + testGum.getPrice());
	
	Drinks testDrink;
	testDrink = new Drinks("Pepsi", new BigDecimal ("2.50"));
	System.out.println("testDrink is: " + testDrink.getName() + " " + testDrink.getPrice());
	
	Candy testCandy;
	testCandy = new Candy("Nestle", new BigDecimal ("3.50"));
	System.out.println("testCandy is: " + testCandy.getName() + " " + testCandy.getPrice());
	
	Chips testChips;
	testChips = new Chips("Lays", new BigDecimal ("4.50"));
	System.out.println("testChips is: " + testChips.getName() + " " + testChips.getPrice());
	
	
}
}
