/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.Util.Payment;
import se.kth.iv1350.store.Util.Total;
import se.kth.iv1350.store.intergration.Item;
import se.kth.iv1350.store.intergration.ItemDTO;

/**
 *
 * @author Frida Johansson
 */
public class RegisterTest {
    private Amount testBalance;
    private Register register;
    
    @BeforeEach
    public void setUp() {
        register = new Register();
        testBalance = new Amount(1000.0);
    }
    
    @AfterEach
    public void tearDown() {
        testBalance = null;
    }


    @Test
    public void testAddPayment() {
        
        
        String name = "Tights";
        Amount price = new Amount(599.0);
        Amount tax = new Amount(Math.round(599.0*0.12));
        
        ItemDTO itemDTO = new ItemDTO(price, name, tax);
        Item item = new Item(itemDTO, name, new Amount(1.0));
        
        Total total = new Total();
        total.updateTotal(item);
        
        Payment payment = new Payment(new Amount(500.0), total);
        register.addPayment(payment);
        
        Amount Result = register.getBalance();
        Amount expResult = testBalance.add(payment.getTotal().getTotalWithTax());
        assertEquals(expResult, Result, "Balance is not equal");
         
    }
    
}
