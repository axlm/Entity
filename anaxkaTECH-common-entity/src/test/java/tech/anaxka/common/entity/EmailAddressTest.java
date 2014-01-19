/**
 * Copyright © ${project.inceptionYear}, Mycila
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */
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
