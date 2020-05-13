/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import se.kth.iv1350.store.Util.Amount;

/**
 * This class prints the running total of sales on the console.
 * @author Frida Johansson
 */
public class ConsoleTotalRevenueDisplay extends TotalRevenueView{
    
    @Override
    protected void printSaleList(Amount totalSales, ArrayList list) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String now = LocalDateTime.now().format(formatter);
        String total = totalSales + " kr " + "\t";
        StringBuilder builder = new StringBuilder();
        builder.append("\n" + "--------DISPLAY--------" + "\n");
        int noOfSales = list.size();
        builder.append(now).append("\nThe number of sales in store is: \t").append(noOfSales);
        builder.append("\nThe runningtotal in store is:\t");
        builder.append(total + "\n");
        
        System.out.println(builder);
        
        
    }
    

    
}
