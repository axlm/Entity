/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package _4axka.common.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Before
    public void setUp() {
    }
    
    @After
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
