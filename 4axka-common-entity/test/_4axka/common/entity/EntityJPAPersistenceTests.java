package _4axka.common.entity;

import org.testng.annotations.Test;

import _4axka.common.entity.Address.AddressType;
import _4axka.common.entity.Builders.PersonBuilder;
import _4axka.common.entity.EmailAddress.EmailAddressType;
import _4axka.common.entity.Person.GenderType;
import _4axka.common.entity.TelephoneNumber.TelephoneNumberType;
import _4axka.common.entity.id.SouthAfricanIdentityDocument;

import static _4axka.common.entity.Builders.addressBuilder;
import static _4axka.common.entity.Builders.emailAddressBuilder;
import static _4axka.common.entity.Builders.telephoneNumberBuilder;
import static _4axka.util.builder.DateTimeBuilder.dateTimeBuilder;

public class EntityJPAPersistenceTests {
    Object[][] generatePersons() {
        return new Object[][] {{}};
    }

    void initializeEntityManger() {
        
    }

    public EntityJPAPersistenceTests() {
    }
    
    void testAddPerson() {
        
    }
    
    void testFindPerson() {
        
    }
    
    void testModifyPerson() {
        
    }
    
    void testRemovePerson() {
        
    }
    
    @Test
    public void blah() {
        System.out.println(saCitizenBuilder().toString());
    }
    
    private Person<SouthAfricanIdentityDocument> saCitizenBuilder() {
        return new PersonBuilder<SouthAfricanIdentityDocument>(){}
                .setLegalIdentifier(new SouthAfricanIdentityDocument(
                        "860911 5017 0 8 8",
                        null,
                        dateTimeBuilder()
                                .setYear(1999)
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
