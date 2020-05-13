/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.Util;

 
import se.kth.iv1350.store.intergration.Item;

/**
 * Represents the total of sale and taxes.
 * @author Frida Johansson
 */
public class Total {
    private  Amount totalSale;
    private  Amount totalTax;

    /**
     *  Creates a new instance, representing the total.
     */
    public Total(){
        this.totalSale = new Amount(0.0);
        
        this.totalTax = new Amount(0);
    }

    /**
     * Gets the value of total.
     *
     * @return The value of total.
     */
    public Amount getTotalSale() {
        return totalSale;
    }

    /**
     * Gets the value the totalTax.
     *
     * @return The totalTax.
     */
    public Amount getTotalTax() {
        return totalTax;
    }

    /**
     *  Adds the tax to totalSale and returns it.
     *
     * @return The total with taxes.
     */
    public Amount getTotalWithTax(){
        return totalSale.add(totalTax);
    }

    /**
     *  Updates the total and the totalTax. 
     *
     * @param item The item that will be added to the totalSale, 
     * possess information about number of items and their tax and price.
     */
    public void updateTotal(Item item){
        if(item == null){
            return;
        }
        Amount amountOfItems = item.getQuantity();
        Amount itemPrice = item.getItemData().getPrice();
        Amount itemTax = item.getItemData().getTaxAmount();

        this.totalTax = this.totalTax.add(amountOfItems.multiply(itemTax));
        this.totalSale = this.totalSale.add(amountOfItems.multiply(itemPrice));
    }
}
