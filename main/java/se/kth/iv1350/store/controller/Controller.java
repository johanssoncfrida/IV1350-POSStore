/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.controller;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.store.intergration.*;
import se.kth.iv1350.store.model.*;
import se.kth.iv1350.store.Util.Amount;
import se.kth.iv1350.store.Util.Payment;

 
/**
 * The controller of the program. All calls goes through here.
 * @author Frida Johansson
 */
public class Controller {
    
    private final ExternalDbHandler creator;
    private final Printer printer;
    private final Register cashRegister;
    private Sale sale;
    private ArrayList<TotalRevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Creates a new instance of controller.
     *
     * @param creator. Access external system.
     * @param printer  Access external printer.
     */
    public Controller(ExternalDbHandler creator, Printer printer){
        this.creator = creator;
        this.printer = printer;
        this.cashRegister = new Register();
    }

    /**
     *  Initiates a new sale.
     */
    public void createNewSale(){
        this.sale = new Sale();
        sale.addSaleObservers(revenueObservers);
        
    }
    
    /**
     * The specified observer is notified when a sale has been made. 
     * @param observer 
     */
    public void addSaleObserver(TotalRevenueObserver observer){
        revenueObservers.add(observer);
    }

    /**
     * adds items to basket.Checks by name if scanned item exists in database and depending on outcome,
     * adds to basket and return total.
     * @param name The item scanned.
     * @param quantity The amount of that item.
     * @throws OperationFailedException if unable to add the items
     */
    public void addItemToBasket(String name, Amount quantity) throws OperationFailedException{
        if(sale == null){
            throw new IllegalStateException("Call method addItemToBasket before calling createSale");
        }
        System.out.println("\nCashier enter item: " + name + "\n");
        try {
            if(name.equals("Hoodie")){
                throw new FailedToConnectWithDatabaseException("Failed to connect with database\n");
            }
            
            Item item = creator.getInventorySystem().getItem(name, quantity);
            System.out.println("Registrerad Item: " + sale.updateSale(item) + "quantity: " + quantity.toString() +
                    " \nRunning total: " + displayTotal() + "\n");
            
        }
        catch(FailedToFindItemException | FailedToConnectWithDatabaseException exc){
            throw new OperationFailedException(exc.getMessage());
        }
        
    }

    /**
     *  Displays the total sale with taxes.
     *
     * @return The total with taxes as a String.
     */
    public String displayTotalWithTax(){
        System.out.println("Cashier displays total sale including taxes.");
        return "Total: " + sale.getTotal().getTotalWithTax().toString();
    }
    /**
     * Displays the total tax.
     * 
     * @return total tax.
     */
    public String displayTotalTax(){
        System.out.println("Cashier displays total tax.");
        return "Total tax: " + sale.getTotal().getTotalTax().toString();
    }
    /**
     * Displays the total sale.
     * 
     * @return total sale.
     */
    public String displayTotal(){
        return sale.getTotal().getTotalSale().toString();
    }
    
    /**
     * Payment is due by paidAmount and is added to the cashregister.
     * The external system will be updated, and a receipt will be created and printed by the printer.
     *
     * @param paidAmount Money paid by the customer.
     */
    public void pay(Amount paidAmount){
        if(sale == null){
            throw new IllegalStateException("Call pay before creating sale");
        }
            System.out.println("Cashier enters the paid amount. \n");
            Payment payment = new Payment(paidAmount, sale.getTotal());
            cashRegister.addPayment(payment);

            System.out.println("Paid amount " + paidAmount + " \t change back: " + payment.getChange().toString());
        
        
        
    }
    /**
     * This method creates the receipt and calls printer to print the receipt.
     * @param paidAmount The amount given from customer.
     */
    public void printReceipt(Amount paidAmount){
        Receipt receipt = new Receipt(sale);
        printer.printReceipt(receipt);
        
    }
    /**
     * updates the external systems.
     * Accountingsystem is updated with the sales
     * InventorySystem is updated with the sold items.
     */
    private void updateDatabase() throws OperationFailedException {
        
        creator.getAccountingSystem().updateAccountingSystem();
        creator.getInventorySystem().updateInventory(sale);
        
    }
   
    /**
     * Ends sale and notifies observer.
     * @throws OperationFailedException
     */
    public void endSale() throws OperationFailedException {
        
        Receipt receipt = new Receipt(sale);
        printer.printReceipt(receipt);
        sale.notifyObserver(sale.getTotal().getTotalSale(), sale.getArrayList());
        updateDatabase();
        sale = null;
    }

   
}