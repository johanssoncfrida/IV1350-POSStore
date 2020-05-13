/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.intergration;

/**
 * Thrown when the inventorysystem can't be reach
 * @author Frida Johansson
 */
public class FailedToConnectWithDatabaseException extends Exception{
    
    /**
     * This method creates a new exception via call to superclass.
     * @param errorMsg The message concering the exception
     */
    public FailedToConnectWithDatabaseException(String errorMsg){
        super(errorMsg);
    }
    @Override
    public String getMessage(){
        return "Failed to connect with database";
    }
}
