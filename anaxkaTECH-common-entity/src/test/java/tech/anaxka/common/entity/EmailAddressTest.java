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
public class EmailAddressTest {
    
    public EmailAddressTest() {
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
     * Test of equals method, of class EmailAddress.
     */
    @Test
    public void testEquals() {
        final EmailAddress lhs_ = new EmailAddress(
                EmailAddress.EmailAddressType.HOME,
                "test@address.com");
        final EmailAddress rhs_ = new EmailAddress(lhs_);

        assertEquals(lhs_, rhs_);
    }

    /**
     * Test of compareTo method, of class EmailAddress.
     */
    @Test
    public void testCompareTo() {
    }

    /**
     * Test of toString method, of class EmailAddress.
     */
    @Test
    public void testToString() {
    }
}
