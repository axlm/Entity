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
public class EmailAddressTest {
    /**
     * Test of equals method, of class EmailAddress.
     */
    @Test(enabled = false)
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
    @Test(enabled = false)
    public void testCompareTo() {
    }

    /**
     * Test of toString method, of class EmailAddress.
     */
    @Test(enabled = false)
    public void testToString() {
    }
}
