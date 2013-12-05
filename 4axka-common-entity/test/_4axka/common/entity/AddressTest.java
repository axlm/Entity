package _4axka.common.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
