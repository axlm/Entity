package _4axka.common.entity.odb;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import _4axka.common.entity.Address;
import _4axka.common.entity.Address.AddressType;
import _4axka.common.entity.EmailAddress;
import _4axka.common.entity.EmailAddress.EmailAddressType;
import _4axka.common.entity.Person;
import _4axka.common.entity.Person.GenderType;
import _4axka.common.entity.TelephoneNumber;
import _4axka.common.entity.TelephoneNumber.TelephoneNumberType;
import _4axka.common.entity.id.SouthAfricanIdentityNumber;

import com.db4o.query.Predicate;


public class EmbededObjectDataBaseTestCases {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    //@Test
    public final void addEntity() {
        final EmbededObjectDatabase eodb_ = new EmbededObjectDatabase();

        try {
            eodb_.connect("eodb.db4o");
        } catch (final DatabaseException e_) {
            e_.printStackTrace();
        }

        final SouthAfricanCitizen axl_ = new SouthAfricanCitizen(
                new SouthAfricanIdentityNumber("680302 5017 0 8 9"),
                Arrays.asList(
                        new EmailAddress(EmailAddressType.HOME, "axl.mattheus@home.com"),
                        new EmailAddress(EmailAddressType.OFFICE, "axl.mattheus@work.com")),
                Arrays.asList(
                        new TelephoneNumber(TelephoneNumberType.HOME, "+27", "12", "654 3210", null),
                        new TelephoneNumber(TelephoneNumberType.OFFICE, "+27", "11", "205 7000", "11221")),
                Arrays.asList(
                        new Address(
                                AddressType.HOME,
                                "321 Home Lane",
                                "Homms",
                                "Homeville",
                                "Homely",
                                "South Africa",
                                "00007"),
                        new Address(
                                AddressType.OFFICE,
                                "1001 Work Lane",
                                "Labour Park",
                                "Crank Town",
                                "Sweats",
                                "South Africa",
                                "10007")),
                Arrays.asList("Axl", "Adolf"),
                null,
                "Axl",
                "Bok",
                "Mattheus",
                new Date(),
                GenderType.MALE,
                Arrays.asList(Person.TitleType.MISTER));

        final SouthAfricanCitizen anel_ = new SouthAfricanCitizen(
                new SouthAfricanIdentityNumber("761102 0032 0 8 9"),
                Arrays.asList(
                        new EmailAddress(EmailAddressType.HOME, "anel.mattheus@home.com"),
                        new EmailAddress(EmailAddressType.OFFICE, "anel.mattheus@work.com")),
                Arrays.asList(
                        new TelephoneNumber(TelephoneNumberType.HOME, "+27", "12", "654 3210", null),
                        new TelephoneNumber(TelephoneNumberType.OFFICE, "+27", "11", "205 7000", "11221")),
                Arrays.asList(
                        new Address(
                                AddressType.HOME,
                                "321 Home Lane",
                                "Homms",
                                "Homeville",
                                "Homely",
                                "South Africa",
                                "00007"),
                        new Address(
                                AddressType.OFFICE,
                                "1000 Work Lane",
                                "Labour Park",
                                "Crank Town",
                                "Sweats",
                                "South Africa",
                                "10007")),
                Arrays.asList("Anel", "Mooiste"),
                null,
                "Anel",
                "Bokkie",
                "Mattheus",
                new Date(),
                GenderType.FEMALE,
                Arrays.asList(Person.TitleType.PROFESSOR, Person.TitleType.MISTRESS));

        try {
            eodb_.add(axl_);
            eodb_.add(anel_);
        } catch (final AdditionException e_) {
            e_.printStackTrace();
        }

        try {
            eodb_.disconnect();
        } catch (final DatabaseException e_) {
            e_.printStackTrace();
        }

        assertTrue(true);
    }

    @Test
    public final void testFindEntityClass() {
        final EmbededObjectDatabase eodb_ = new EmbededObjectDatabase();

        try {
            eodb_.connect("eodb.db4o");
        } catch (final DatabaseException e_) {
            e_.printStackTrace();
        }

        Iterable<SouthAfricanCitizen> saffers_ = null;
        try {
            saffers_ = eodb_.find(SouthAfricanCitizen.class);
        } catch (final SearchException e_) {
            e_.printStackTrace();
        }

        if (null != saffers_) {
            for (SouthAfricanCitizen saffer_ : saffers_) {
                System.out.println(saffer_.toString());
            }
        }

        try {
            eodb_.disconnect();
        } catch (final DatabaseException e_) {
            e_.printStackTrace();
        }

        assertNotNull(saffers_);
    }

    //@Test
    public final void testFindEntityUsingPredicate() {
        final EmbededObjectDatabase eodb_ = new EmbededObjectDatabase();

        try {
            eodb_.connect("eodb.db4o");
        } catch (final DatabaseException e_) {
            e_.printStackTrace();
        }

        Iterable<SouthAfricanCitizen> saffers_ = null;
        try {
            saffers_ = eodb_.find(new Predicate<SouthAfricanCitizen>() {
                /**
                 * Determines if a de-serialised file is compatible with this class.
                 * <p>
                 * Maintainers <strong>MUST</strong> change this value if and only if the new version of
                 * this class is not compatible with the previous version. It is not necessary to include
                 * in first version of the class, but included here as a reminder of its importance.
                 * 
                 * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
                 */
                private static final long serialVersionUID = 2068663185226793478L;

                @Override
                public boolean match(final SouthAfricanCitizen candidate) {
                    return candidate.getLegalIdentifier().getGender() == GenderType.FEMALE;
                }
            });
        } catch (final SearchException e_) {
            e_.printStackTrace();
        }

        if (null != saffers_) {
            for (SouthAfricanCitizen saffer_ : saffers_) {
                System.out.println(saffer_.toString());
            }
        }

        try {
            eodb_.disconnect();
        } catch (final DatabaseException e_) {
            e_.printStackTrace();
        }

        assertNotNull(saffers_);
    }
}
