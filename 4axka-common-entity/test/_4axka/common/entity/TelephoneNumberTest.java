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
public class TelephoneNumberTest {
    
    public TelephoneNumberTest() {
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
