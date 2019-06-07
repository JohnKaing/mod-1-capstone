package com.techelevator.view;

public class Calculator {
	
	public static void main(String[] args) {

	    double quarter = .25;
	    double nickel = .05;
	    double dime = .10;
	    double balance = 1.80;

	    int storedQuarter;
	    double storedDimes;
	    double storedNickels;

	    double wholeMoney = Math.floor(balance / quarter);
	    storedQuarter = (int)wholeMoney;

	    float moneyLeft = (float) Math.round((balance % quarter) * 100) / 100;
	    storedDimes = Math.floor(moneyLeft / dime);
	    moneyLeft = (float) Math.round((balance % nickel) * 100) / 100;
	    storedNickels = Math.floor(moneyLeft / nickel);

	    System.out.println("Your change will be: " + storedQuarter + " Quarter(s), " + (int)storedDimes + " Dime(s) and " + (int)storedNickels + " Nickel(s)");
	    
	    
	    
	    
	    }
	}

