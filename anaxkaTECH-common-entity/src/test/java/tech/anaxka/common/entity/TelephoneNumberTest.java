/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.anaxka.common.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 *
 * @author adolf.mattheus
 */
@Test(enabled = false)
public class TelephoneNumberTest {
    /**
     * Test of equals method, of class TelephoneNumber.
     */
    @Test(enabled = false)
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
    @Test(enabled = false)
    public void testCompareTo() {
    }

    /**
     * Test of toString method, of class TelephoneNumber.
     */
    @Test(enabled = false)
    public void testToString() {
    }
}
