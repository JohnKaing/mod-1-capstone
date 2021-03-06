package com.techelevator;

import java.math.BigDecimal;

public abstract class Products {

	private String name;
	private BigDecimal price;

	public Products(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public abstract String getSound();

	@Override
	public String toString() {
		String result = name + " " + price;
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
