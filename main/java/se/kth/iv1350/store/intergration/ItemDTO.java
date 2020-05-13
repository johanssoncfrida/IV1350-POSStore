/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;
import java.util.Objects;
import se.kth.iv1350.store.Util.Amount;
/**
 * Data of the item in store.
 * 
 * @author Frida Johansson
 */
public final class ItemDTO {
    private final Amount price;
    private final String itemName;
    private final Amount taxAmount;

    /**
     * Creates a new instance of an item.
     *
     * @param price The price of the item.
     * @param itemName The name of the item.
     * @param taxAmount The tax amount of the item.
     */
    public ItemDTO(Amount price, String itemName, Amount taxAmount){
        this.price = price;
        this.itemName = itemName;
        this.taxAmount = taxAmount;
    }

    /**
     * Get value of price.
     *
     * @return price.
     */
    public Amount getPrice() {
        return price;
    }

    /**
     * Get the value of itemName.
     *
     * @return itemName.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Get the value of taxAmount.
     *
     * @return taxAmount.
     */
    public Amount getTaxAmount() {
       
        return taxAmount;
    }

    /**
     * 
     *
     * @return The instance as a String.
     */
    @Override
    public String toString() {
        String builder = "item name: " + itemName + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + taxAmount + "\t";
        return builder;
    }

    /**
     * Two instances of ItemDTO are compared if equal.
     *
     * @param obj the object to be compared with this.object.
     * @return true if all fields are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())){
            return false;
        }
        final ItemDTO other = (ItemDTO) obj;
        if (!Objects.equals(this.price, other.price)){
            return false;
        }
        if (!this.itemName.equals(other.itemName)){
            return false;
        }
        if (!Objects.equals(this.taxAmount, other.taxAmount)){
            return false;
        }
        return true;
    }
}