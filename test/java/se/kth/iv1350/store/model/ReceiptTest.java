/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Frida Johansson
 */
public class ReceiptTest {
    private Sale sale;
    
   
    @BeforeEach
    public void setUp() {
        sale = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
    }

   
    @Test
    public void testToString() {
        
        
        Receipt instance = new Receipt(sale);
        String receiptText = "----------RECEIPT----------" + "\n";
        String storeName = "Träningsbutiken" + "\n";
        String address = "Träningsgatan 1, 111 22, Stockholm " + "\n";
        
        LocalDateTime saleTime = LocalDateTime.now().withNano(0);
        String saleTimeText = "Time of sale: " + saleTime.toLocalTime().toString() + "\n";
        LocalDateTime saleDate = LocalDateTime.now();
        String saleDateText = "Date of sale: " + saleDate.toLocalDate().toString() + "\n";
        
        String items = "Items: " + "\n";
        
        String subTotal = "\nSubtotal: " + sale.getTotal().getTotalSale().toString();
        String totalTax = "\nTotal tax: " + sale.getTotal().getTotalTax().toString();
        String total = "\nTotal: " + sale.getTotal().getTotalWithTax().toString();
        
        String welcomeBackText = "--------Welcome again!--------" + "\n";
        String expResult = "\n" + receiptText + storeName + address + 
                saleDateText + saleTimeText + items + 
                subTotal + totalTax + total + "\n" + welcomeBackText;
        String result = instance.toString();
        assertEquals(expResult, result, "String not equal");
        
    }
}
 