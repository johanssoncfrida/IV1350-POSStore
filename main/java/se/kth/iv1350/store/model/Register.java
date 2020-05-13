/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.model;

import se.kth.iv1350.store.Util.Payment;
import se.kth.iv1350.store.Util.Amount;


/**
 * The cashregister of the store.
 * @author Frida Johansson
 */
public class Register {
    private Amount balance;

    /**
     * Creates a new instance of a cashregister.
     */
    public Register(){
        this.balance = new Amount(1000.0);
    }
 
    /**
     * Gets the value of balance.
     *
     * @return balance.
     */
    public Amount getBalance() {
        return balance;
    }

    /**
     * Updates register's balance wth the specified payment.
     *
     * @param payment The payment of cash that will be added to the register.
     */
    public void addPayment(Payment payment){
        balance = balance.add(payment.getTotal().getTotalWithTax());
    }
}