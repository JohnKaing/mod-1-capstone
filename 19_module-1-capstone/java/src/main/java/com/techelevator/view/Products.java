package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Products {

	private String name;
	private BigDecimal price;
	private String sound;
	
	public Products(String name, BigDecimal price) {
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
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}


