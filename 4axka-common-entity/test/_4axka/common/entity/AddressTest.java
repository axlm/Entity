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
public class AddressTest {
    
    public AddressTest() {
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
     * Test of equals method, of class Address.
     */
    @Test
    public void testEquals() {
        final Address lhs_ = new Address(
                Address.AddressType.HOME,
                "Test Street",
                "Test Suburb",
                "Test City",
                "Test Region",
                "Test Country",
                "Test Code");
        final Address rhs_ = new Address(lhs_);
        
        assertEquals(lhs_, rhs_);
    }
    
    @Test
    public void testNotEqual() {
        final Address lhs_ = new Address(Address.AddressType.HOME, "A", "B", "C", "D", "E", "F");
        final Address rhs_ = new Address(Address.AddressType.OFFICE, "Z", "Y", "X", "W", "V", "U");
        
        assertTrue(!lhs_.equals(rhs_));
    }

    /**
     * Test of compareTo method, of class Address.
     */
    @Test
    public void testCompareTo() {
    }

    /**
     * Test of toString method, of class Address.
     */
    @Test
    public void testToString() {
    }
}
