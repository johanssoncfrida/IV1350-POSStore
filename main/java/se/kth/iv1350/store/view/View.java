/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.view;

import java.io.IOException;
import se.kth.iv1350.store.controller.Controller;
import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.Util.StoreLog;
import se.kth.iv1350.store.controller.OperationFailedException;
import se.kth.iv1350.store.intergration.FailedToConnectWithDatabaseException;




/**
 * This class represents the view in store.
 * @author Frida Johansson
 */
public class View {
    private final Controller controller;
    private final ErrorMessageHandler errorMsg = new ErrorMessageHandler();
    private StoreLog log = new StoreLog();
    GuiSalesDisplay guiDisplay;

    /**
     *  Creates a new instance, represented as a view.
     * @param controller The class where all calls are being made.
     * @throws java.io.IOException
     */
    public View(Controller controller) throws IOException {
       this.controller = controller;
       
       controller.addSaleObserver(new ConsoleTotalRevenueDisplay());
       controller.addSaleObserver(new GuiSalesDisplay());
       this.log = log;
       
       
    }

    /**
     *  Represents a sample sale.
     *  
     * @throws FailedToConnectWithDatabaseException if system can't connect with inventory.
     * @throws OperationFailedException if not able to add items.
     */
    public void sampleSale() throws FailedToConnectWithDatabaseException, OperationFailedException{
        System.out.println("Start new sale.\n");
        
        controller.createNewSale();
        sampleAddItem();
        viewSales();
        pay();
        controller.endSale();
    }
    

    
    private void sampleAddItem(){
        try{
            controller.addItemToBasket("Tights", new Amount(1));
            
        }
        catch(OperationFailedException exc){
            handleExceptionUser(exc);
        }
        try{
            controller.addItemToBasket("Tshirt", new Amount(1));
            
        }
        catch(OperationFailedException exc){
            handleExceptionUser(exc);
        }
        try{
            controller.addItemToBasket("Tshirt", new Amount(1));
            
        }
        catch(OperationFailedException exc){
            handleExceptionUser(exc);
        }
        try{
            controller.addItemToBasket("TrainingBook", new Amount(1));
           
        }
        catch(OperationFailedException exc){
            handleExceptionUser(exc);
        }
        try{
            controller.addItemToBasket("Jeans", new Amount(1));
            
        }
        catch(OperationFailedException exc){
            handleExceptionUser( exc);
        }
        try{
            
            controller.addItemToBasket("Hoodie", new Amount(1));
            
        }
        catch(OperationFailedException exc){
            handleException("Database is Null", exc);
        }
  
    }
  
    private void viewSales(){
        String totalTax = controller.displayTotalTax();
        System.out.println(totalTax + "\n");
        String totalWithTax = controller.displayTotalWithTax();
        System.out.println(totalWithTax + "\n");
        
    }
    
    private void pay() {
        controller.pay(new Amount(3000.0));
      
    }

    private void handleException(String msg, Exception exc){
        errorMsg.showErrorMessage(exc.getMessage());
        log.logException(exc, msg);
    }
    
    private void handleExceptionUser(Exception exc){
        errorMsg.showErrorMessage(exc.getMessage());
    }
}

