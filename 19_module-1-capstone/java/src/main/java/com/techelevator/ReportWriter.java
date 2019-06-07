package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ReportWriter {
	public void writer2(String nameOfSnack) {

		try {
			PrintWriter writer2 = new PrintWriter("./salesreport.txt");
			for (Map.Entry<String, List<Products>> entry : InventoryImport.fileImporter().entrySet()) {
				int startingQuantity = 5;
				int resultQuantity = startingQuantity - (entry.getValue().size());

				writer2.println("resultQuantity is: " + resultQuantity);
				writer2.close();

			}
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
		}
	}
}
