/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.store.Util;

import se.kth.iv1350.store.Util.Amount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
/**
 *
 * @author Frida Johansson
 */
public class AmountTest {
    private Amount amountShouldBeTwo;


    @BeforeEach
    public void setUp() {
        amountShouldBeTwo = new Amount(2.0);

    }
    
    @AfterEach
    public void tearDown() {
        amountShouldBeTwo = null;
    }
    @Test
    void testEquals() {
        double other = 2.0;
        Amount otherAmount = new Amount(other);
        boolean expResult = true;
        boolean result = amountShouldBeTwo.equals(otherAmount);
        assertEquals(expResult, result,"Amount instances are not equal");
    }

    @Test
    void testNotEquals() {
        double other = 5.0;
        Amount amountOther = new Amount(other);
        boolean expResult = false;
        boolean result = amountShouldBeTwo.equals(amountOther);
        assertEquals(expResult, result,"test failed");
    }
    
    @Test
    void testNotEqualsToNull() {
        Amount otherAmount = null;
        boolean expectedResult = false;
        boolean result = amountShouldBeTwo.equals(otherAmount);
        assertEquals(expectedResult, result, "Amount instance equal to null.");
    }
 
    @Test
    void testSubtract() {
        double ten = 10.0;
        double three = 3.0;
        Amount tenAmount = new Amount(ten);
        Amount threeAmount = new Amount(three);
        Amount expectedDifference = new Amount(ten - three);
        Amount difference = tenAmount.subtract(threeAmount);
        assertEquals(expectedDifference, difference, "The difference is not 7.");
    }

    @Test
    void testNegative() {
        double three = 3.0;
        double ten = 10.0;
        Amount threeAmount = new Amount(three);
        Amount tenAmount = new Amount(ten);
        Amount expectedDifference = new Amount(three - ten);
        Amount difference = threeAmount.subtract(tenAmount);
        assertEquals(expectedDifference, difference, "The difference is not -7.");
    }

    @Test
    void testAdd() {
        double ten = 10.0;
        double three = 3.0;
        Amount tenAmount = new Amount(ten);
        Amount threeAmount = new Amount(three);
        Amount expectedSum = new Amount(ten + three);
        Amount resultSum = tenAmount.add(threeAmount);
        assertEquals(expectedSum, resultSum, "The sum is not added successfully");
    }

    @Test
    void testPlusWithNegativeSum() {
        double three = 3.0;
        double minusTen = -10.0;
        Amount threeAmount = new Amount(three);
        Amount minusTenAmount = new Amount(minusTen);
        Amount expectedSum = new Amount(three + minusTen);
        Amount resultSum = threeAmount.add(minusTenAmount);
        assertEquals(expectedSum, resultSum, "The sum is not added successfully");
    }

    @Test
    void testMultiply() {
        double ten = 10.0;
        double three = 3.0;
        Amount tenAmount = new Amount(ten);
        Amount threeAmount = new Amount(three);
        Amount expectedProduct = new Amount(ten * three);
        Amount resultProduct = tenAmount.multiply(threeAmount);
        assertEquals(expectedProduct, resultProduct, "The product is not successfully multiplied");
    }

    @Test
    void testMultiplyWithZero() {
        double ten = 10.0;
        double zero = 0.0;
        Amount tenAmount = new Amount(ten);
        Amount zeroAmount = new Amount(zero);
        Amount expectedProduct = new Amount(ten * zero);
        Amount resultProduct = tenAmount.multiply(zeroAmount);
        assertEquals(expectedProduct, resultProduct,"The product is not successfully multiplied");
    }

    @Test
    void testMultiplyNegativeNumbers() {
        double negTen = -10.0;
        double negThree = -3.0;
        Amount negTenAmount = new Amount(negTen);
        Amount negThreeAmount = new Amount(negThree);
        Amount expectedProduct = new Amount(negTen * negThree);
        Amount resultProduct = negTenAmount.multiply(negThreeAmount);
        assertEquals(expectedProduct, resultProduct,"The product is not successfully multiplied");
    }

    @Test
    void testToStringPositiveAmount() {
        double posNumber = 10.0;
        Amount posAmount = new Amount(posNumber);
        String expString = Double.toString(posNumber);
        String resultString = posAmount.toString();
        assertEquals(expString, resultString,"The String is not the same");
    }

    @Test
    void testToStringNegativeAmount() {
        double negNumber = -10.0;
        Amount negAmount = new Amount(negNumber);
        String expString = Double.toString(negNumber);
        String resultString = negAmount.toString();
        assertEquals(expString, resultString, "The String is not the same");
    }

    @Test
    void testToStringZero() {
        double zeroNumber = 0.0;
        Amount zeroAmount = new Amount(zeroNumber);
        String expString = Double.toString(zeroNumber);
        String resultString = zeroAmount.toString();
        assertEquals(expString, resultString,"The String is not the same");
    }
    
}