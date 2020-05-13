/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.Util;

 
/**
 * This class represents payment including the tota cost of the payment and
 * the amount paid by the customer.
 * @author Frida Johansson
 */
public class Payment {
    private final Amount paidAmount;
    private final Total total;

    /**
     * Creates a new instance of payment.
     *
     * @param paidAmount The amount money paid by customer
     * @param total The total cost of sale.
     */
    public Payment(Amount paidAmount, Total total){
        this.paidAmount = paidAmount;
        this.total = total;
    }

    /**
     * 
     *
     * @return The total cost.
     */
    public Total getTotal() {
        return total;
    }

    /**
     *  Calculate change.
     *
     * @return The total change
     */
    public Amount getChange(){
        return paidAmount.subtract(total.getTotalWithTax());
    }



}



















