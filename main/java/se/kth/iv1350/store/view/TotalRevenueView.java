/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.view;

import java.util.ArrayList;
import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.model.TotalRevenueObserver;

/**
 * This class shows running total of sales and calls printSaleList in 
 * ConsoleTotalRevenueDisplay to print it.
 * @author Frida Johansson
 */
public abstract class TotalRevenueView implements TotalRevenueObserver{
    private Amount totalSales = new Amount(0.0);
    private ArrayList <Integer> numberOfSales = new ArrayList<>();
   
    
    protected TotalRevenueView(){
        this.totalSales = totalSales;
        this.numberOfSales = numberOfSales;
    }

  
    @Override
    public void newSale(Amount totalPrice, ArrayList salesList) {
        totalSales = totalSales.add(totalPrice);
        
        int noOfTotalSales = salesList.size();
        numberOfSales.add(noOfTotalSales);
        
        printSaleList(totalSales, numberOfSales);
    }
    
    /**
     * Prints the information about the sales.
     * @param totalSales the sales in store.
     * @param salesList represents how many sales been made in store.
     */
    protected abstract void printSaleList(Amount totalSales, ArrayList salesList);

}
    
   
 
    
  

