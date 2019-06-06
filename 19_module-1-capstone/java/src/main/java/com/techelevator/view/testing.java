package com.techelevator.view;

public class testing  {
	public static void main(String[] args) {

	Gum testGum;
	testGum = new Gum("Juicy", 1.50);
	System.out.println("testGum is: " + testGum.getName() + " " + testGum.getPrice());
	
	Drinks testDrink;
	testDrink = new Drinks("Pepsi", 2.50);
	System.out.println("testDrink is: " + testDrink.getName() + " " + testDrink.getPrice());
	
	Candy testCandy;
	testCandy = new Candy("Nestle", 3.50);
	System.out.println("testCandy is: " + testCandy.getName() + " " + testCandy.getPrice());
	
	Chips testChips;
	testChips = new Chips("Lays", 4.50);
	System.out.println("testChips is: " + testChips.getName() + " " + testChips.getPrice());
	
	
}
}
