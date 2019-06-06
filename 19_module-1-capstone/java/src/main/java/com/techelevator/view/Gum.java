package com.techelevator.view;


public class Gum extends Products {


	public Gum(String name, double price) {
		super(name, price);
		

	
		Gum testGum;
		testGum = new Gum("juicy", 1.50);
		System.out.println("testGum is: " + testGum.getName() + testGum.getPrice());
		
	}
	
	
	
	// Gum Chiclets = new Gum("Chiclets", 0.95);
	
	
}

