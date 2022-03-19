package com.techelevator.view;


import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static File logFile = new File("src/main/resources/log.txt");
    public static void createLogFile() throws IOException {
        if (logFile.exists()) {
            logFile.delete();
        }
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        if (!logFile.exists()) {
            System.out.println("Unable to create log file");
        }
    }

    public static void addToLog(String message, BigDecimal previousBalance, BigDecimal currentBalance) {
        if (logFile.exists()){
            try (PrintWriter outPut = new PrintWriter(new FileOutputStream(logFile, true))){
                DecimalFormat df = new DecimalFormat("0.00");
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
                String dateText = dateTime.format(formatter);
                outPut.println(">" + dateText + " " + message + " " + df.format(previousBalance) + " " + df.format(currentBalance));
            }catch (FileNotFoundException e){
                System.out.printf("File not found");
            }
        }
    }
}
