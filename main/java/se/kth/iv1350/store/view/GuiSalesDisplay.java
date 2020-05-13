/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.view;
import javax.swing.*;
import java.awt.*;

import java.time.LocalDateTime;

import java.util.ArrayList;
import se.kth.iv1350.store.Util.Amount;


/**
 * This class represents a GUIdisplay that shows the total revenue in store 
 * and the number of sales.
 * @author Frida Johansson
 */
public class GuiSalesDisplay extends TotalRevenueView{
    
    private final JLabel labelRunningTotal = new JLabel();
    private final JLabel labelSale = new JLabel();
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    
  
public GuiSalesDisplay() {
    prepareGui();
    
}
    
    private void prepareGui(){
        LocalDateTime saleDate = LocalDateTime.now();
        String salesDate = "Date: \t" + saleDate.toLocalDate().toString();
        
        LocalDateTime saleTime = LocalDateTime.now().withNano(0);
        String salesTime = " Time: " + saleTime.toLocalTime().toString();

        JLabel dateLabel = new JLabel(salesDate + salesTime);
        dateLabel.setFont(new Font(dateLabel.getFont().getName(), dateLabel.getFont().getStyle(), 20));
        

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\Me\\NETBEANS\\Store\\src\\workout.JPG"));
        panel.add(background);
        background.setLayout(new FlowLayout());
        background.add(dateLabel);
        background.add(labelSale);
        background.add(labelRunningTotal);
        labelSale.setFont(new Font(labelSale.getFont().getName(), labelSale.getFont().getStyle(), 20));
        labelRunningTotal.setFont(new Font(labelRunningTotal.getFont().getName(), labelRunningTotal.getFont().getStyle(), 20));
        
        frame.add(panel, BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("----Display----");
        
        
        frame.pack();
        frame.setVisible(true);
       
    }

    @Override
    protected void printSaleList(Amount totalSales, ArrayList salesList) {
        
        labelSale.setText("The number of sales in store is: " + salesList.size());
        labelRunningTotal.setText("The runningtotal in store is: " + totalSales + " kr " );
    }
}

   





