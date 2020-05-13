/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;

import se.kth.iv1350.store.Util.Amount;
 
/**
 * This class represents an Item in store.
 * 
 * @author Frida Johansson
 */
public class Item {
    private final ItemDTO itemData;
    private final String name;
    private Amount quantity;

    /**
     * Creates a new instance of an item.
     *
     * @param itemData containing data and description of an item.
     * @param name The name of an item.
     * @param quantity The amount if items.
     */
    public Item(ItemDTO itemData, String name, Amount quantity) {
        this.itemData = itemData;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Increases quantity of item
     *
     * @param otherQuantity The amount that will be added
     */
    public void increaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.add(otherQuantity);
    }

    /**
     * Decreases quantity of item.
     *
     * @param otherQuantity the amount that will be subtracted.
     */
    public void decreaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.subtract(otherQuantity);
    }

    /**
     * Get the value of quantity.
     *
     * @return The value of quantity.
     */
    public Amount getQuantity() {
        return quantity;
    }

    /**
     * Get the value of itemData.
     *
     * @return The value of itemData
     */
    public ItemDTO getItemData() {
        return itemData;
    }

    /**
     * Get the value of name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The instance of Item as a String
     */
    @Override
    public String toString() {
        String builder = "itemname: " + name + "\t" +
                " quantity: " + quantity + "\t" +
                "item: " + itemData.toString();
        return builder;
    }

    /**
     * Checks if instances of Item are equal.
     *
     * @param obj the comparing item with this.item.
     * @return true if all fields are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())){
            return false;
        }

        final Item other = (Item) obj;
        if (!this.itemData.equals(other.itemData)){
            return false;
        }
        if (!this.name.equals(other.name)){
            return false;
        }
        return true;
    }
}