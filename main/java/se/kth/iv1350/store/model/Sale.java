/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.model;
import se.kth.iv1350.store.Util.Total;
import se.kth.iv1350.store.intergration.Item;
import java.util.HashMap;
import java.util.*;
import se.kth.iv1350.store.Util.Amount;


/**
 * This class represents the sale in the store.
 * @author Frida Johansson
 */
public class Sale {
    private final Total totalSale = new Total();
    private final HashMap<String, Item> basketOfItems = new HashMap<>();
    
    private final ArrayList<TotalRevenueObserver> revenueObservers;

    /**
     * Creates a new instance of Sale.
     */
    public Sale(){
        this.revenueObservers = new ArrayList<>();
        
        
    }
    /**
     * Gets the value of total.
     *
     * @return total.
     */
    public Total getTotal() {
        return totalSale;
    }
    /**
     * Gets the HashMap basketOfItems.
     *
     * @return The HashMap basketOfItems.
     */
    public HashMap<String, Item> getHashMap(){
        return basketOfItems;
    }
    
    public ArrayList<TotalRevenueObserver> getArrayList(){
        return revenueObservers;
    }
    


    /**
     * Updates the current sale. Checks if item already is scanned or not.
     *
     * @param item The item that will be added to the sale.
     * @return  itemData as string.
     */
    public String updateSale(Item item){
        if (basketOfItems.containsKey(item.getName())) {
            updateItemQuantityAndTotal(item);
        } else {
            addItemAndUpdateTotal(item);
        }
        return item.getItemData().toString();
    }
    /**
     * Updates the quantity of the scanned items 
     * and updates the total sale.
     * 
     * @param item the scanned item.
     */
    private void updateItemQuantityAndTotal(Item item){
        Item oldItem = basketOfItems.get(item.getName());
        oldItem.increaseQuantity(item.getQuantity());
        basketOfItems.put(oldItem.getName(), oldItem);
        totalSale.updateTotal(item);
    }
    
    /**
     * Adds item to sale and updates total sale. 
     * 
     * @param item the scanned item.
     */
    private void addItemAndUpdateTotal(Item item){
        basketOfItems.put(item.getName(), item);
        totalSale.updateTotal(item);
    }
    /**
     * The speciefied observers will be notified when a sale has been made.
     * @param revenueObservers The observer to notify.
     */
    public void addSaleObservers(ArrayList<TotalRevenueObserver> revenueObservers){
        this.revenueObservers.addAll(revenueObservers);
    }
    
    /**
    * The notified observer gets the sales total and number of sales.
     * @param total
     * @param observers
    **/
    public void notifyObserver(Amount total, ArrayList<TotalRevenueObserver> observers){
        for(TotalRevenueObserver obs : revenueObservers){
            obs.newSale(total,observers);
        }
    }
    
    /**
     * Makes the instance into to a string
     *
     * @return The instance as a string
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while(entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getItemData().toString());
            builder.append(" quantity: ").append(item.getQuantity().toString());
            builder.append("\n");
            
        }
        builder.append("\nSubtotal: ").append(totalSale.getTotalSale().toString());
        builder.append("\nTotal tax: ").append(totalSale.getTotalTax().toString());
        builder.append("\nTotal: ").append(totalSale.getTotalWithTax().toString());
        return builder.toString();
    }
    /**
     * Get the keys in basketOfItems
     * 
     * @return a set view of the keys in the Hashmap basketOfItems.
     */
    private Iterator getEntries(){
        Set entries = basketOfItems.entrySet();
        return entries.iterator();
    }
    /**
     * 
     * @param entriesIterator the interface used to iterate through the hashmap.
     * @return the value of keys in the hashmap.
     */
    private Item getCurrentItem(Iterator entriesIterator){
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Item) mapping.getValue();
    }


}



