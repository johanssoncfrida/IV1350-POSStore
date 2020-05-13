/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;

 
/**
 * A singleton class representing a accountingSystem.
 * This class represents a external system and has no insight in that system, therefor doesn't this class 
 * do anything more than print out a message that the system has been updated.
 * 
 * @author Frida Johansson
 */
public class AccountingSystem {
    private static final AccountingSystem instance = new AccountingSystem();

    /**
     *  Creates a new instance, representing a accounting system.
     */
    private AccountingSystem(){ 
        
    }
    public static AccountingSystem getInstance(){
        
        return instance;
    }
    public void updateAccountingSystem(){
        
        System.out.println("Accounting updated!");
    }
}