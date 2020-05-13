/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.Util;

import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.Util.Total;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.store.intergration.Item;
import se.kth.iv1350.store.intergration.ItemDTO;


/**
 *
 * @author Frida Johansson
 */
public class TotalTest {
    private Total total;
   
     
    @BeforeEach
    public void setUp() {
        total = new Total();
    }
    
    @AfterEach
    public void tearDown() {
        total = null;
    }



    @Test
    public void testUpdateTotal() {
        String name = "Tights";
        Amount price = new Amount(599.0);
        Amount taxRate = new Amount(Math.round(599.0*0.12));
        Amount quantity = new Amount(1.0);
        
        ItemDTO itemDTO = new ItemDTO(price, name, taxRate);
        Item item = new Item(itemDTO, name, quantity);

        total.updateTotal(item);
        Amount resultTotal = total.getTotalSale();
        Amount resultTax = total.getTotalTax();
        Amount expTotal = price.multiply(quantity);
        Amount expTax = taxRate.multiply(quantity);

        assertEquals(expTotal,resultTotal,"Total not equal");
        assertEquals(expTax, resultTax, "Taxes not equal");
    }
    
}
