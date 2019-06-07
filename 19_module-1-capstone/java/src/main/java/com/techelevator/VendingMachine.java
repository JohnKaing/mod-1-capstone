package com.techelevator;
	
	import java.math.BigDecimal;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.TreeMap;
	
	public class VendingMachine {
		BigDecimal balance = new BigDecimal(0.00).setScale(2);
		List<Products> purchaseList = new ArrayList<>();			// new ArrayList to hold purchases
		Map<String, List<Products>> inventory = new TreeMap<>(); // map to hold inventory, key is slot location
		LogWriter writer = new LogWriter();

	public VendingMachine(Map<String, List<Products>> inventory) {
		this.inventory = inventory;
	}
	
	
	
	public void displayInventory() {
		for (Map.Entry<String, List<Products>> entry : inventory.entrySet()) {
			String key = entry.getKey();
			List value = entry.getValue();
			if (value.size() == 0) {
				System.out.println(key + " Out of stock");
			} else {

			}
			System.out.println(key + " " + value.subList(0, 1) + " " + (value.size() - 1));
		}
	}
		
	
	public void feedMoney(int addMoney) {
		String typeOfTransaction = "FEED MONEY:";
		if (addMoney == 1) {
			balance = balance.add(new BigDecimal(1.00));
			writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

		} else if (addMoney == 2) {
			balance = balance.add(new BigDecimal(2.00));
			writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);
		} else if (addMoney == 3) {
			balance = balance.add(new BigDecimal(5.00));
			writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);
		} else if (addMoney == 4) {
			balance = balance.add(new BigDecimal(10.00));
			writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);
		}
		System.out.println("Your balance is " + balance);
	}

	public void completeTransaction() {
		Change thisChange = new Change();
		thisChange.giveChange(balance);
		writer.writer("GIVE CHANGE:", balance, new BigDecimal(0.00).setScale(2));
		while (purchaseList.size() > 0) {
			Products purchases = purchaseList.remove(0);
			System.out.println(purchases.getSound());
		}
	}

	public void purchase(String guestSelection) {
		try {
		if (! inventory.containsKey(guestSelection)) { 
			System.out.println("Sorry that product does not exist, please choose a valid product.");
		} 
		if (inventory.containsKey(guestSelection)) {
			if (inventory.get(guestSelection).size() <= 0) {
				System.out.println("Sorry that product is out of stock");
			}
			if (inventory.get(guestSelection).size() >= 1) {
				if (balance.compareTo(inventory.get(guestSelection).get(0).getPrice()) >= 0) {
					balance = balance.subtract(inventory.get(guestSelection).get(0).getPrice());
					Products p = inventory.get(guestSelection).remove(0);
					purchaseList.add(p);
					Products cost = inventory.get(guestSelection).get(0);
					BigDecimal costOne = cost.getPrice();
					Products nameOne = inventory.get(guestSelection).get(0);
					String productOne = nameOne.getName() + " " + guestSelection;
					writer.writer(productOne, costOne, balance);
				} else {
					System.out.println("Please insert more cash.");
					
				}
				}
			
			}
		}catch(IndexOutOfBoundsException exception) {
		    System.out.println("***************     You have selected an item that is no longer in stock.     ***************");
		    System.out.println("***************     Please select another item or close the transaction.      ***************");
		    System.out.println();
		System.out.println("Your balance is " + balance);
	}
}
	}

