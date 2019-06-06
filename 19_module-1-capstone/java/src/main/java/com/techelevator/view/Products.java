package com.techelevator.view;

public abstract class Products {

	private String name;
	private double price = 0.00;
	private String sound;
	
	public Products(String name, double price) {
		this.name = name;
		this.price = price;
		}

	
	
	
	
	
	public String getSound( ) {
		return sound;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}


