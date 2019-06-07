package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InventoryImport {

	    Map<String, List<Products>> fileImporter() {
		File inventoryFile = new File("/Users/christopherclark/workspace/java-module-1-capstone-team-6/19_module-1-capstone/java/vendingmachine.csv");
		
		Map<String, List<Products>> vendingMachineInventory = new TreeMap<>(); //make our map of type string and list product (product is two strings - name and price)
		try (Scanner stockImporter = new Scanner(inventoryFile)) {	// new scanner object to read from our inventory file
			while (stockImporter.hasNextLine()) {				// while loop to keep going while the scanner has lines
				String line = stockImporter.nextLine();
				if (!line.isEmpty()) {									// don't import empty lines
					String[] stockImporterArray = line.split("\\|");	// handles pipe delimiter 

					if (stockImporterArray[0].contains("A")) {				// handles chip items (pull slot location from element 0)
						List<Products> productArray = new ArrayList<>();		// make new arrayList to hold products
						for (int i = 0; i < 6; i++) {						// only stocks to 5
							Chips temp = new Chips(stockImporterArray[1], // pull name from element 1
									new BigDecimal(stockImporterArray[2])); // makes new big decimal, pulls out price from element 2
							productArray.add(temp); 						// executes the addition of the info into the arraylist
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray); // update the vending machine inventory map with updated list values

					} else if (stockImporterArray[0].contains("B")) {		// handles candy items
						List<Products> productArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Candy temp = new Candy(stockImporterArray[1],
									new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);

					} else if (stockImporterArray[0].contains("C")) { // handles drink items
						List<Products> productArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {

							Drinks temp = new Drinks(stockImporterArray[1],
									new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);

					} else {
						List<Products> productArray = new ArrayList<>();

						for (int i = 0; i < 6; i++) {
							Gum temp = new Gum(stockImporterArray[1],
									new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);
					}
				}
			}
			return vendingMachineInventory;

		} catch (FileNotFoundException e) {		// handles if they input the wrong path / file
			System.out.println("Your file does not exist");
			System.exit(1);
			return vendingMachineInventory;
		}
	}
}
