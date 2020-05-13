/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.model;

import java.util.ArrayList;
import se.kth.iv1350.store.Util.Amount;

/**
 * An interface that recieves information about the sales in store.
 * TotalRevenueView implements this interface.
 * @author Frida Johansson
 */
public interface TotalRevenueObserver {
    
    /**
     * This method invokes when a sale has been made.
     * @param totalPrice the totalsale of the sale.
     * @param observer the list of number of sales.
     */
    public void newSale(Amount totalPrice, ArrayList observer); 
    
}
