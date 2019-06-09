package com.techelevator;

import java.io.File;
import java.util.LinkedHashMap;

public class SalesReportReader {

	private final File salesReportFile = new File("salesReport.txt");
	private final LinkedHashMap<String, Integer> salesReportMap = new LinkedHashMap<>();
	private double totalSales;

	public LinkedHashMap<String, Integer> getSalesReportMap() {
		return salesReportMap;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void parseSalesReport() {
		InventoryImport importer = new InventoryImport();
		String[] salesReportItems = importer.parseInputFileByLine(salesReportFile);
		createMap(salesReportItems);
		createTotalSalesVariable(salesReportItems);
	}

	private void createMap(String[] salesReportItems) {
		for (String line : salesReportItems) {
			if (!line.startsWith("*") && (!line.isEmpty())) {
				String[] inputFileItems = line.split("[|]");
				String name = inputFileItems[0];
				Integer inventoryCount = Integer.parseInt(inputFileItems[1]);

				salesReportMap.put(name, inventoryCount);
			}

		}
	}

	private void createTotalSalesVariable(String[] salesReportItems) {
		for (String line : salesReportItems) {
			if (line.startsWith("*")) {
				String[] totalSalesGetter = line.split("[$]");
				totalSales = Double.parseDouble(totalSalesGetter[1].trim());
			}
		}
	}
}
