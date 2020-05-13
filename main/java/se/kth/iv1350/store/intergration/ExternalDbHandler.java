/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;
 
/**
 * The database that handles the accountingsystem and inventorysystem.
 * @author Frida Johansson
 */
public class ExternalDbHandler {
    private final AccountingSystem accSystem;
    private final InventorySystem inventory;

    /**
     * Creates the system database for external systems.
     * Gets the singleton external systems.
     */
    public ExternalDbHandler(){
        accSystem = AccountingSystem.getInstance();
        inventory = InventorySystem.getInstance();
    }

    /**
     * Gets the value of accSystem.
     *
     * @return The value of accSystem.
     */
    public AccountingSystem getAccountingSystem() {
        return accSystem;
    }

    /**
     * Gets the value of invenSystem.
     *
     * @return The value of invenSystem.
     */
    public InventorySystem getInventorySystem() {
        return inventory;
    }
}