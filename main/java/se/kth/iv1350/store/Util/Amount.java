/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.Util;
import java.util.Objects;
 
/**
 * This class represents Amount as amount of money or amount of items.
 * @author Frida Johansson
 */
public class Amount {
    private final double amount;

    /**
     * Creates an instance, representing the specified amount.
     *
     * @param amount The amount represented by the newly created instance.
     */
    public Amount(double amount){
        this.amount = amount;
    }

    /**
     * 
     * @return The value of amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Makes amount into a Stringobject.
     *
     * @return amount as a string
     */
    @Override
    public String toString() {
        return Double.toString(amount);
    }

    /**
     * Checks if (parameter)amount is equal to this amount.
     *
     * @param obj (parameter)amount
     * @return false if it's not equal. Otherwise true.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())){
            return false;
        }
        final Amount other = (Amount) obj;
        if (!Objects.equals(this.amount, other.amount)){
            return false;
        }
        return true;
    }

    /**
     * Will subtract the (parameter)amount
     *
     * @param otherAmount (parameter)amount.
     * @return The difference of this amount and otherAmount.
     */
    public Amount subtract(Amount otherAmount){
        return new Amount(this.amount - otherAmount.amount);
    }

    /**
     * add this amount with (parameter)amount
     *
     * @param otherAmount (parameter)amount.
     * @return the sum of this amount and otherAmount.
     */
    public Amount add(Amount otherAmount){
        return new Amount(this.amount + otherAmount.amount);
    }

    /**
     * Will multiply with the (parameter)amount
     *
     * @param otherAmount (parameter)amount.
     * @return product of this amount and otherAmount.
     */
    public Amount multiply(Amount otherAmount){ 
        return new Amount(this.amount * otherAmount.amount);
    }

}