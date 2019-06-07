package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class ReportWriter {
public void writer2(String nameOfSnack, int quantity) {

    try (PrintWriter ReportWriter = new PrintWriter(new FileOutputStream(new File("./salesreport.txt"), true))) {
        int quantity1;
        ReportWriter.print(nameOfSnack + "|" + quantity1);
        
    
    } catch (FileNotFoundException e) {
        System.out.println("File was not found.");
}
}
}