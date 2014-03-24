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
