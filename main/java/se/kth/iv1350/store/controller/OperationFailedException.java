/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.controller;

/**
 * When operation fails, this exceptions is thrown
 * @author Frida Johansson
 */
public class OperationFailedException extends Exception{
    
    public OperationFailedException(String msg){
        super(msg);
    }
}
