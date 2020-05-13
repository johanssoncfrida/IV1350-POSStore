/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Frida Johansson
 */
public class ErrorMessageHandlerTest {
    PrintStream systemOut = System.out;
    ByteArrayOutputStream outContent;
    
    
    @BeforeEach
    public void setUp() {
        this.outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    public void tearDown() {
        outContent = null;
        System.setOut(systemOut);
        
    }

    /**
     * Test of showErrorMessage method, of class ErrorMessageHandler.
     */
    @Test
    public void testShowErrorMessage() {
        String msg = "A error message";
        
        ErrorMessageHandler instance = new ErrorMessageHandler();
        instance.showErrorMessage(msg);
        
        String expResult = ", ERROR, " + msg;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String expResultTime = time.format(formatter);
        
        String actualResult = outContent.toString();
        assertTrue(actualResult.contains(expResult), "The right message did not print out as expected");
        assertTrue(actualResult.contains(expResultTime), "Did not contain the expected time");
        
    }
    
}
