/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.model;
import java.time.LocalDateTime;
/**
 * Receipt of sale
 * 
 * @author Frida Johansson
 */
public class Receipt {
    private final Sale sale;

    /**
     * Creates a new instance, representing a receipt.
     *
     * @param sale The information that will be on the receipt.
     */
    public Receipt(Sale sale){
        this.sale = sale;
    }

    /**
     * Makes the instance into a string
     *
     * @return Tbe instance as a string
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        addLine(builder, "----------RECEIPT----------");
        addLine(builder, "Träningsbutiken");
        addLine(builder, "Träningsgatan 1, 111 22, Stockholm ");
        addLocalDate(builder);
        addLocalTime(builder);
        addLine(builder, "Items: ");
        addLine(builder, sale.toString());
        addLine(builder, "--------Welcome again!--------");
        return builder.toString();
    }
 
    /**
     * Adds the specified line to the specified stringbuilder together with 
     * and additional line. 
     * 
     * @param builder the Stringbuilder created in toString-method.
     * @param line The string that's added to the stringbuilder.
     */
    private void addLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
    /**
     * Adds the date of the sale together with an additional line.
     * 
     * @param builder the Stringbuilder created in toString-method.
     */
    private void addLocalDate(StringBuilder builder){
        LocalDateTime saleDate = LocalDateTime.now();
        addLine(builder, "Date of sale: " + saleDate.toLocalDate().toString());
    }
    /**
     * Adds the time of the sale together with an additional line.
     * 
     * @param builder the Stringbuilder created in toString-method.
     */
    private void addLocalTime(StringBuilder builder){
        
        LocalDateTime saleTime = LocalDateTime.now().withNano(0);
        addLine(builder, "Time of sale: " + saleTime.toLocalTime().toString());
    }

}