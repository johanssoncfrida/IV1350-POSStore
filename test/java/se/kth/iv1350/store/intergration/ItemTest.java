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
public class ItemTest {
    private Item twoTights;
    private final String name = "Tights";
   
 
    
    @BeforeEach
    public void setUp() {
        twoTights = new Item(new ItemDTO(new Amount(599.0), name, new Amount(Math.round(599.0*0.12))), name, new Amount(2.0));
    }
    
    @AfterEach
    public void tearDown() {
        twoTights = null;
    }

    @Test
    public void testIncreaseQuantity() {
        
        Amount otherQuantity = new Amount(2.0);
        Amount addedQuantity = new Amount(2.0);
        Amount expResult = otherQuantity.add(addedQuantity);
        twoTights.increaseQuantity(otherQuantity);
        Amount result = twoTights.getQuantity();
        assertEquals(expResult, result, "Quantities is not the same");
    }

    @Test
    public void testDecreaseQuantity() {
        
        Amount otherQuantity = new Amount(2.0);
        Amount addedQuantity = new Amount(1.0);
        Amount expResult = otherQuantity.subtract(addedQuantity);
        twoTights.decreaseQuantity(addedQuantity);
        Amount result = twoTights.getQuantity();
        assertEquals(expResult, result, "Quantities is not the same");
    }
 

  
    @Test
    public void testToString() {
        Amount price = new Amount(599.0);
        String nameOfItem = "Tights";
        Amount tax = new Amount(Math.round(599.0*0.12));
        ItemDTO itemDTO = new ItemDTO(price, nameOfItem, tax);
        Amount quantity = new Amount(2.0);
        Item testingItem = new Item(itemDTO, nameOfItem, quantity);
        String expString = "itemname: " + nameOfItem + "\t" +
                " quantity: " + quantity + "\t" +
                "item: " + itemDTO.toString();
        String result = testingItem.toString();
        assertEquals(expString, result, " Not the same strings");
    }

    @Test
    public void testEquals() {
        
        Amount price = new Amount(599.0);
        Amount tax = new Amount(Math.round(599.0*0.12));
        String nameOfItem = "Tights";
        Amount quantity = new Amount(2.0);
        ItemDTO itemDTO = new ItemDTO(price, nameOfItem, tax);
        Item instanceToTry = new Item(itemDTO, name, quantity);
        boolean expResult = true;
        boolean result = twoTights.equals(instanceToTry);
        assertEquals(expResult, result, "Items are not equal");
        
    }
    
}
