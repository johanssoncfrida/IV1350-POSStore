/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.startUp;

import java.io.IOException;
import se.kth.iv1350.store.controller.Controller;
import se.kth.iv1350.store.controller.OperationFailedException;
import se.kth.iv1350.store.intergration.ExternalDbHandler;
import se.kth.iv1350.store.intergration.FailedToConnectWithDatabaseException;
import se.kth.iv1350.store.intergration.Printer;
 
import se.kth.iv1350.store.view.View;
/**
 * Main method. application starts from here.
 * @author Frida Johansson
 */
public class Main {

    /**
     * Mainclass that starts application
     *
     * @param args array of strings which stores arguments passed 
     * by command line while starting a program.
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws se.kth.iv1350.store.intergration.FailedToConnectWithDatabaseException
     * @throws se.kth.iv1350.store.controller.OperationFailedException
     * 
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, FailedToConnectWithDatabaseException, OperationFailedException {
        try {
            ExternalDbHandler systemCreator = new ExternalDbHandler();
            Printer printer = new Printer();
            Controller controller = new Controller(systemCreator, printer);
            View view = new View(controller);
            view.sampleSale();
            
        } 
        catch(IOException exc){
            System.out.println("Not able to start the application");
            exc.printStackTrace();
        }
        
        
        
        
        
    }
}

