/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;

/**
 * Exception to be thrown when the item does not exists in storage. 
 */
public class FailedToFindItemException extends Exception {

    /**
     * This method creates a new exception via call to superclass.
     * @param errorMsg The errormessage
     */
    public FailedToFindItemException(String errorMsg) {
        super(errorMsg);
    }
    @Override
    public String getMessage(){
        return "Failed to find the item in the database.";
    }
}

