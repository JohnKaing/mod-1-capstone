package com.techelevator;



import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class InventoryImport {


    private final LinkedHashMap<String, List<Products>> itemsInTheMachine = new LinkedHashMap<>();

    public String[] parseInputFileByLine(File inputFile) {
        StringBuilder line = new StringBuilder();
        try (Scanner in = new Scanner(inputFile)) {
            while (in.hasNextLine()) {
                line.append(in.nextLine()).append("\n");
            }

        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Could not " + inputFile + " file");
        }
        return line.toString().split("[\n]");

    }

    private void createInventoryMap(String[] parsedFile) {
        for (String line : parsedFile) {

            String[] inputFileItems = line.split("[|]"); // Handles Pipe Delimiter
            List<Products> itemList = new ArrayList<>();
            String slot = inputFileItems[0];
            String name = inputFileItems[1];
            BigDecimal price = new BigDecimal(inputFileItems[2]);
            if (slot.startsWith("A")) {					// Handles Chips
                Products item = new Chips(name, price);
                itemLoader(itemList, slot, item);
            } else if (slot.startsWith("B")) {			// Handles Candy
                Products item = new Candy(name, price);
                itemLoader(itemList, slot, item);
            } else if (slot.startsWith("C")) {			// Handles Drinks
                Products item = new Drinks(name, price);
                itemLoader(itemList, slot, item);
            } else if (slot.startsWith("D")) {			// Handles Gum
                Products item = new Gum(name, price);
                itemLoader(itemList, slot, item);
            }

        }
    }

    private void itemLoader(List<Products> itemList, String slot, Products item) {
        for (int i = 0; i < 5; i++) {
            itemList.add(item);
            itemsInTheMachine.put(slot, itemList);
        }
    }


    public LinkedHashMap<String, List<Products>> passImportMapToVendingMachine() {
        String[] parsedFile = parseInputFileByLine(new File("vendingmachine.csv"));
        createInventoryMap(parsedFile);
        return itemsInTheMachine;
    }


}
