/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class represent a log,
 * logs exceptions when something is not correct in the program.
 * @author Frida Johansson
 */
public class StoreLog {
    private final String LOG_NAME = "store-log.txt";
    private PrintWriter storeLogFile;
    
    public StoreLog() throws IOException{
        try{
            storeLogFile = new PrintWriter(new FileWriter(LOG_NAME), true);
        }
        catch(IOException exc){
            System.out.println("Unable to crate a logfile.");
            exc.printStackTrace();
        }
    }
    
    private String addTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

    /**
     * Method that creates a printable exception via stringbuilder.
     * @param exc the exception
     * @param devMessage the message printed
     */
    public void logException(Exception exc, String devMessage) {
        StringBuilder exceptionMsgLogBuilder = new StringBuilder();
        exceptionMsgLogBuilder.append(addTime());
        exceptionMsgLogBuilder.append(", Following exception was thrown: ");
        exceptionMsgLogBuilder.append(devMessage);
        storeLogFile.println(exceptionMsgLogBuilder);
        exc.printStackTrace(storeLogFile);   
    }
}
