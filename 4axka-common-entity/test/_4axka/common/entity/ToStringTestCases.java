package _4axka.common.entity;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import _4axka.common.entity.Address.AddressType;
import _4axka.common.entity.EmailAddress.EmailAddressType;
import _4axka.common.entity.TelephoneNumber.TelephoneNumberType;
import _4axka.common.entity.id.SouthAfricanIdentityNumber;


public class ToStringTestCases {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public final void testAddressToString() {
        final Address address_ = new Address(
                AddressType.HOME,
                "41 Cleveland Street",
                "Boston Estate",
                "Bellville",
                "Western Cape",
                "Sout Africa",
                "7521");
        final String addressToString_ = address_.toString();
        System.out.println(addressToString_);
        assertNotNull(addressToString_);
    }

    @Test
    public final void testEmailAddressToString() {
        final EmailAddress address_ = new EmailAddress(
                EmailAddressType.HOME, "axl.mattheus@home.com");
        final String addressToString_ = address_.toString();
        System.out.println(addressToString_);
        assertNotNull(addressToString_);
    }

    @Test
    public final void testTelephoneNumberToString() {
        final TelephoneNumber number_ = new TelephoneNumber(
                TelephoneNumberType.HOME, "+27", "12", "654 3210", "911");
        final String numberToString_ = number_.toString();
        System.out.println(numberToString_);
        assertNotNull(numberToString_);
    }

    @Test
    public final void testPersonToString() {
        final Person<SouthAfricanIdentityNumber> person_ = new Person<SouthAfricanIdentityNumber>() {
            private static final long serialVersionUID = 7226518013709502430L;
        };

        person_.addGivenName("Adolf");
        person_.addGivenName("Johannes");
        person_.addAlias("Axl");
        person_.setPreferredGivenName("Axl");
        person_.setFamilyName("Mattheus");
        person_.setLegalIdentifier(new SouthAfricanIdentityNumber("6803025017089"));
        person_.addTelephoneNumber(new TelephoneNumber(
                TelephoneNumberType.HOME, "+27", "12", "654 3210", ""));
        person_.addEmailAddress(new EmailAddress(EmailAddressType.HOME, "axl.mattheus@home.com"));
        person_.addEmailAddress(new EmailAddress(EmailAddressType.OFFICE, "axl.mattheus@work.net"));
        person_.addAddress(new Address(
                AddressType.HOME,
                "123 Homestead Street",
                "Home View",
                "Homely",
                "Homms",
                "RSA",
                "7852"));
        String personToString_ = person_.toString();
        System.out.println(personToString_);
        assertNotNull(personToString_);
    }
}
