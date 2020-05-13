/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class shows errormessages to the user when error occur.
 * @author Frida Johansson
 */
public class ErrorMessageHandler {
    
    
    /**
     * 
     * @param msg The error message that is displayed
     */
    void showErrorMessage(String msg){
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append(addTime());
        errorBuilder.append(", ERROR, ");
        errorBuilder.append(msg);
        System.out.println(errorBuilder);
    }
    
    private String addTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

    
    
}
