package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class ReportWriter {
public void writer2(String nameOfSnack, BigDecimal cost, int quantity1) {

    try (PrintWriter ReportWriter = new PrintWriter(new FileOutputStream(new File("./salesreport.txt"), true))) {
        ReportWriter.print(nameOfSnack + "|" + quantity1 + "\n");   
    } catch (FileNotFoundException e) {
        System.out.println("File was not found.");
}
}
}