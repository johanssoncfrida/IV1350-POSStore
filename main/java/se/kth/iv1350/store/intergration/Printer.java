/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;
import se.kth.iv1350.store.model.Receipt;
 
/**
 * Represents external printer
 * @author Frida Johansson
 */
public class Printer {
    
    public Printer(){
        
    }
    /**
     * 
     * @param receipt represents receipt of sale
     */
    public void printReceipt(Receipt receipt){
        
        System.out.println(receipt);
    }
    
}
