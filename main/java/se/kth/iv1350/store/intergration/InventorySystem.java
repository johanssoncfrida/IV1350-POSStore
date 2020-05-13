/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.controller.OperationFailedException;
import se.kth.iv1350.store.model.Sale;
 

/**
 * A singleton class representing a inventorysystem with items in it.
 * 
 * @author Frida Johansson
 */
public class InventorySystem {
    private static final InventorySystem instance = new InventorySystem();
    private final HashMap<String, Item> stock = new HashMap<>();

    /**
     * Creates instance of a inventory system with items in it.
     * @return the only instance of this singleton
     */
    public static InventorySystem getInstance(){
        
        return instance;
    }
    
    private InventorySystem(){
        
        addItemsToInventory();
    }
    

    /**
     * Updates the number of items in the inventory.
     *
     * @param sale that possesses information about the items.
     * @throws OperationFailedException if not able to update the inventory.
     */
    public void updateInventory(Sale sale) throws OperationFailedException  {
        try{
        HashMap<String, Item> items = sale.getHashMap();
        Set entries = items.entrySet();

        for (Object entry : entries) {
            Item item = getCurrentItem(entry);

            if (itemExistsInInventory(item)) {
                decreaseQuantityOfItem(item);
            }
        }
        }
        catch(FailedToConnectWithDatabaseException exc){
            throw new OperationFailedException(exc.getMessage());
        }
        System.out.println("Inventory updated!");
    }

    private boolean itemExistsInInventory(Item item) throws FailedToConnectWithDatabaseException {
        if(stock == null){
            throw new FailedToConnectWithDatabaseException("Failed to connect with database");
        }
        return stock.containsKey(item.getName());
    }

    private void decreaseQuantityOfItem(Item item){
        Item itemInStock = stock.get(item.getName());
        itemInStock.decreaseQuantity(item.getQuantity());
       
        stock.put(itemInStock.getName(), itemInStock);
    }

    private Item getCurrentItem(Object entry){
        Map.Entry mapping = (Map.Entry) entry;
        return (Item) mapping.getValue();
    }
   
    public HashMap<String, Item> getMap(){
        return stock;
    }
   
   

    private void addItemsToInventory(){
        
        stock.put("Tshirt", new Item(new ItemDTO(new Amount(299.0), "Tshirt", new Amount(Math.round(299.0*0.12))), "Tshirt", new Amount(10.0)));
        stock.put("Tights", new Item(new ItemDTO(new Amount(599.0), "Tights", new Amount(Math.round(599.0*0.12))), "Tights", new Amount(10.0)));
        stock.put("Hoodie", new Item(new ItemDTO(new Amount(499.0), "Hoodie", new Amount(Math.round(499.0*0.12))), "Hoodie", new Amount(10.0)));
        stock.put("TrainingBook", new Item(new ItemDTO(new Amount(159.0), "TrainingBook", new Amount(Math.round(159.0*0.06))), "TrainingBook", new Amount(10.0)));
    }
    /**
     *  Checks if scanned item exists in database.
     *
     * @param name scanned item.
     * @return true if item exists, otherwise false.
     * @throws FailedToConnectWithDatabaseException if database is null.
     * @throws FailedToFindItemException if the item is not found in system.
     */
    public boolean itemExists(String name) throws FailedToConnectWithDatabaseException, FailedToFindItemException {
        if(!stock.containsKey(name)){
            throw new FailedToFindItemException("Item: " + name + " could not be found.");
        }
        if(stock == null){
            throw new FailedToConnectWithDatabaseException("Failed to connect with database");
        }
       
        return stock.containsKey(name);
    }

    /**
     * Search system by specified name and returns item with specified quantity.
     *
     * @param name The name of item.
     * @param quantity The amount of items.
     * @return item
     * @throws FailedToFindItemException if the item does not exist
     * @throws FailedToConnectWithDatabaseException if database is null
     */
    public Item getItem(String name, Amount quantity) throws FailedToFindItemException, FailedToConnectWithDatabaseException {
        if (itemExists(name)){
            return new Item(stock.get(name).getItemData(), name, quantity);
        
        }
        throw new FailedToFindItemException ("Item: " + name + " could not be found.");
    }
}