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
import se.kth.iv1350.store.controller.OperationFailedException;

/**
 *
 * @author Frida Johansson
 */
public class InventorySystemTest {
    InventorySystem expStock;
    
    
    @BeforeEach
    public void setUp() {
        expStock = InventorySystem.getInstance();
    }
    
    @AfterEach
    public void tearDown() {
        expStock = null;
    }


    @Test
    public void testItemExists() throws OperationFailedException{
        String name = "Tshirt";
        Amount price = new Amount(299.0);
        
        Amount taxAmount = new Amount(Math.round(299.0*0.12));
        Amount quantity = new Amount(1.0);
        ItemDTO itemData = new ItemDTO(price, name, taxAmount);
        Item Tshirt = new Item(itemData, name, quantity);
        
        try{
            Item actualResult = expStock.getItem(name, quantity);
            Item expResult = Tshirt;
            assertEquals(expResult.getName(),actualResult.getName(), "Unable to getItem");
            
        }
        catch(FailedToConnectWithDatabaseException | FailedToFindItemException exc){
            throw new OperationFailedException(exc.getMessage());
        }
                   
                    
        }
    

    
}
