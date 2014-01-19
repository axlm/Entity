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
package tech.anaxka.common.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(enabled = false)
public class AddressTest {
    @Test(enabled = false)
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

    @Test(enabled = false)
    public void testNotEqual() {
        final Address lhs_ = new Address(Address.AddressType.HOME, "A", "B", "C", "D", "E", "F");
        final Address rhs_ = new Address(Address.AddressType.OFFICE, "Z", "Y", "X", "W", "V", "U");

        assertTrue(!lhs_.equals(rhs_));
    }

    @Test(enabled = false)
    public void testCompareToZero() {
        final Address lhs_ = new Address(
                Address.AddressType.HOME,
                "Test Street",
                "Test Suburb",
                "Test City",
                "Test Region",
                "Test Country",
                "Test Code");
        final Address rhs_ = new Address(lhs_);

        assertTrue(lhs_.compareTo(rhs_) == 0);
    }

    @Test(enabled = false)
    public void testCompareToGreaterThan() {
        final Address lhs_ = new Address(
                Address.AddressType.OFFICE,
                "Test Street",
                "Test Suburb",
                "Test City",
                "Test Region",
                "Test Country",
                "Test Code");
        final Address rhs_ = new Address(
                Address.AddressType.HOME,
                "Test Street",
                "Test Suburb",
                "Test City",
                "Test Region",
                "Test Country",
                "Test Code");

        assertTrue(lhs_.compareTo(rhs_) > 0);
    }

    @Test(enabled = false)
    public void testCompareToLessThan() {
        final Address lhs_ = new Address(
                Address.AddressType.HOME,
                "Test Street",
                "Test Suburb",
                "Test City",
                "Test Region",
                "Test Country",
                "Test Code");
        final Address rhs_ = new Address(
                Address.AddressType.OFFICE,
                "Test Street",
                "Test Suburb",
                "Test City",
                "Test Region",
                "Test Country",
                "Test Code");

        assertTrue(lhs_.compareTo(rhs_) < 0);
    }

    @Test(enabled = false)
    public void testToString() {
    }
}
