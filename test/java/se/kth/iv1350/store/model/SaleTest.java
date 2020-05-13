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
import se.kth.iv1350.store.intergration.Item;
import se.kth.iv1350.store.intergration.ItemDTO;

/**
 *
 * @author Frida Johansson
 */
public class SaleTest {
    Sale sale;
   
     
    @BeforeEach
    public void setUp() {
        sale = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
    }


 
    @Test
    public void testUpdateSale() {
        Amount price = new Amount(599.0);
        Amount tax = new Amount(Math.round(599.0*0.12));
        String name = "Tights";
        ItemDTO item = new ItemDTO(price, name, tax);
        Amount quantity = new Amount(1.0);
        Item itemToTest = new Item(item, name, quantity);
        
        String expResult = itemToTest.getItemData().toString();
        String Result = sale.updateSale(itemToTest);
        
        assertEquals(expResult, Result, "Sale is not the same");
    }

    
}
