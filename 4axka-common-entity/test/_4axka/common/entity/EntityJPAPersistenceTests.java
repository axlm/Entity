package _4axka.common.entity;


import static _4axka.common.entity.Builders.addressBuilder;
import static _4axka.common.entity.Builders.emailAddressBuilder;
import static _4axka.common.entity.Builders.telephoneNumberBuilder;
import static _4axka.common.entity.SouthAfricanCitizen.southAfricanCitizenBuilder;

import static _4axka.util.builder.DateTimeBuilder.dateTimeBuilder;

import _4axka.common.entity.Address.AddressType;
import _4axka.common.entity.EmailAddress.EmailAddressType;
import _4axka.common.entity.Person.GenderType;
import _4axka.common.entity.TelephoneNumber.TelephoneNumberType;
import _4axka.common.entity.id.SouthAfricanIdentityDocument;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 * Class description
 * <p>
 *
 * @version Enter version here..., 13/12/17
 * @author Enter your name here...
 */
public class EntityJPAPersistenceTests {
    private static EntityManager __manager = null;
    private static final Set<Person<SouthAfricanIdentityDocument>> __saffas = new HashSet<>();

    /**
     * Constructs ...
     * <p>
     */
    public EntityJPAPersistenceTests() {}

    /**
     * Method description
     * <p>
     */
    @Test(enabled = false)
    public void blah() {
        System.out.println(createSouthAfricanCitizen().toString());
    }

    /**
     * Method description
     * <p>
     */
    @BeforeClass(enabled = true)
    void setJPAEnvironment() {
        if (__manager == null) {
            __manager = Persistence.createEntityManagerFactory("memoryPU").createEntityManager();
        }

        if (__saffas.isEmpty()) {
            // TODO: expand test for more saffas than 1...
            for (int i_ = 0; i_ < 1; i_++) {
                __saffas.add(createSouthAfricanCitizen());
            }
        }
    }

    /**
     * Method description
     * <p>
     */
    @Test(enabled = true)
    void testAddPerson() {
        __manager.getTransaction().begin();
        __manager.persist(__saffas.iterator().next());
        __manager.getTransaction().commit();
    }

    /**
     * Method description
     * <p>
     */
    void testFindPerson() {}

    /**
     * Method description
     * <p>
     */
    void testModifyPerson() {}

    /**
     * Method description
     * <p>
     */
    void testRemovePerson() {}

    /**
     * Method description
     * <p>
     *
     * @return
     */
    private SouthAfricanCitizen createSouthAfricanCitizen() {
        return southAfricanCitizenBuilder()
                .setLegalIdentifier(
                        new SouthAfricanIdentityDocument(
                                "860911 5017 0 8 8",
                                null,
                                dateTimeBuilder()
                                        .setYear(2004)
                                        .setMonth(11)
                                        .setDay(17)
                                        .build()))
                .addGivenName("Tshepo")
                .addGivenName("Kgathi")
                .setFamilyName("Ntsimang")
                .setDateOfBirth(dateTimeBuilder()
                        .setYear(1986)
                        .setMonth(9)
                        .setDay(11)
                        .build())
                .setGender(GenderType.MALE)
                .addEmailAddress(emailAddressBuilder()
                        .setType(EmailAddressType.HOME)
                        .setAddress("tshepo.ntsimang@yolo.co.za")
                        .build())
                .addEmailAddress(emailAddressBuilder()
                        .setType(EmailAddressType.OFFICE)
                        .setAddress("tkntsimang@bbd.co.za")
                        .build())
                .addTelephoneNumber(telephoneNumberBuilder()
                        .setType(TelephoneNumberType.HOME)
                        .setCountryCode("+27")
                        .setAreaCode("11")
                        .setNumber("807 5225")
                        .build())
                .addTelephoneNumber(telephoneNumberBuilder()
                        .setType(TelephoneNumberType.MOBILE)
                        .setNumber("083 456 1230")
                        .build())
                .addAddress(addressBuilder()
                        .setType(AddressType.HOME)
                        .setLocation("13 14th Street")
                        .setSuburb("Morningside")
                        .setCity("Sandton")
                        .setRegion("Gauteng")
                        .setCountry("South Africa")
                        .setCode("2196")
                        .build())
                .addAddress(addressBuilder()
                        .setType(AddressType.POSTAL)
                        .setLocation("PO Box 1258")
                        .setSuburb("Morningside")
                        .setCity("Sandton")
                        .setRegion("Gauteng")
                        .setCountry("South Africa")
                        .setCode("2096")
                        .build())
                .build();
    }
}
