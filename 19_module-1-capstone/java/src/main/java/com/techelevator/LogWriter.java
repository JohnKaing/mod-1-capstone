package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
	public void writer(String typeOfTransaction, BigDecimal amount, BigDecimal balance) {

		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {

//			LocalDate localDate = LocalDate.now();//For reference
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
//			String formattedString = localDate.format(formatter);
			DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM/dd/uuuu");
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss a");
			String printToday = today.format(formatterDate);
			String printTime  = now.format(formatterTime);
//			String printToday = today.toString();
//			String printTime = now.toString().substring(0, now.toString().length() - 4);
			String printTypeOfTransaction = typeOfTransaction.toString();
			String printAmount = amount.toString();
			String printBalance = balance.toString();

			logWriter.println(printToday + " " + printTime + " " + String.format("%-25s", printTypeOfTransaction)
					+ String.format("%-10s", "$" + printAmount) + String.format("%-10s", "$" + printBalance));

		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
}