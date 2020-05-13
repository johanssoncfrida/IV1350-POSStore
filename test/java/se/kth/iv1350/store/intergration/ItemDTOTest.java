/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.store.Util.Amount;

/**
 *
 * @author Frida Johansson
 */
public class ItemDTOTest {
    private ItemDTO testItemDTO;
 
    
    @BeforeEach
    public void setUp() {
        testItemDTO = new ItemDTO(new Amount(599.0), "Tights", new Amount(Math.round(599.0*0.12)));
    }
    
    @AfterEach
    public void tearDown() {
        testItemDTO = null;
    }


    /**
     * Test of toString method, of class ItemDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Amount price = new Amount(599.0);
        String name = "Tights";
        Amount tax = new Amount(Math.round(599.0*0.12));
        ItemDTO instanceToTest = new ItemDTO(price, name, tax);
        String expResult = "item name: " + name + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + tax + "\t";
        String result = instanceToTest.toString();
        assertEquals(expResult, result, "Strings are not equal");
        
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Amount price = new Amount(599.0);
        String name = "Tights";
        Amount tax = new Amount(Math.round(599.0*0.12));
        ItemDTO instance = new ItemDTO(price, name, tax);
        boolean expResult = true;
        boolean result = instance.equals(testItemDTO);
        assertEquals(expResult, result);
  
    }
    
}
