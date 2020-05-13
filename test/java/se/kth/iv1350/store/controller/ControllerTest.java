/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.controller;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.intergration.ExternalDbHandler;
import se.kth.iv1350.store.intergration.FailedToConnectWithDatabaseException;
import se.kth.iv1350.store.intergration.FailedToFindItemException;
import se.kth.iv1350.store.intergration.Item;
import se.kth.iv1350.store.intergration.ItemDTO;
import se.kth.iv1350.store.intergration.Printer;
import se.kth.iv1350.store.model.Register;
import se.kth.iv1350.store.model.Sale;

/**
 *
 * @author Frida Johansson
 */
public class ControllerTest {
    private Controller contr;
    
    Sale sale;
    private ExternalDbHandler creator;
    private Register register;
    private Printer printer;
   
    
    @BeforeEach
    public void setUp() throws InstantiationException, IllegalAccessException {
        creator = new ExternalDbHandler();
        contr = new Controller(creator, new Printer());
        this.register = new Register();

    }
    
    @AfterEach
    public void tearDown() {
        contr = null;
        register = null;
        
        
    }
 
  
    @Test
    public void testAddItemToBasket() throws OperationFailedException, FailedToFindItemException, FailedToConnectWithDatabaseException {
        
        ItemDTO itemData = new ItemDTO(new Amount(299.0), "Tshirt", new Amount(Math.round(299.0*0.12)));
        Item item = new Item(itemData, "Tshirt", new Amount(1.0));
        sale = new Sale();
        sale.updateSale(item);
        assertTrue(sale.getHashMap().containsKey(item.getName()), "Not successfully added");
        
    }

    @Test
    public void testDisplayTotalWithTax() throws OperationFailedException {
        contr.createNewSale();
        System.out.println("displayTotalWithTax");
        String name = "Tights";
        Amount price = new Amount(599.0);
        Amount tax = new Amount(Math.round(599.0*0.12));
        Amount quantity = new Amount(1.0);
        contr.addItemToBasket(name, quantity);
        String expResult = "Total: " + price.add(tax);
        String result = contr.displayTotalWithTax();
        assertEquals(expResult, result);
        
    }

 
    @Test
    public void testDisplayTotalTax() throws OperationFailedException {
        contr.createNewSale();
        System.out.println("displayTotalTax");
        String name = "Tights";
        Amount price = new Amount(599.0);
        Amount tax = new Amount(Math.round(599.0*0.12));
        Amount quantity = new Amount(1.0);
        contr.addItemToBasket(name, quantity);
        String expResult = "Total tax: " + tax;
        String actualResult = contr.displayTotalTax();
        assertEquals(expResult, actualResult);
        
    }

 
}
