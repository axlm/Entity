/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.anaxka.common.entity;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 *
 * @author adolf.mattheus
 */
public class TelephoneNumberTest {
    
    public TelephoneNumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @BeforeMethod
    public void setUp() {
    }
    
    @AfterMethod
    public void tearDown() {
    }

    /**
     * Test of equals method, of class TelephoneNumber.
     */
    @Test
    public void testEquals() {
        final TelephoneNumber lhs_ = new TelephoneNumber(
                TelephoneNumber.TelephoneNumberType.HOME,
                "+007",
                "007",
                "777 0007",
                "007");
        final TelephoneNumber rhs_ = new TelephoneNumber(lhs_);
        
        assertEquals(lhs_, rhs_);
    }

    /**
     * Test of compareTo method, of class TelephoneNumber.
     */
    @Test
    public void testCompareTo() {
    }

    /**
     * Test of toString method, of class TelephoneNumber.
     */
    @Test
    public void testToString() {
    }
}
