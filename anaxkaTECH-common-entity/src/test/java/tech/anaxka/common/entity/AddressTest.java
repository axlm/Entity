package tech.anaxka.common.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTest {

    public AddressTest() {
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

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void testToString() {
    }
}
