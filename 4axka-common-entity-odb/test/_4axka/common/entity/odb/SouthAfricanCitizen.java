// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of SouthAfricanCitizen.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity.odb;


import java.util.Date;

import _4axka.common.entity.Address;
import _4axka.common.entity.EmailAddress;
import _4axka.common.entity.Person;
import _4axka.common.entity.TelephoneNumber;
import _4axka.common.entity.id.SouthAfricanIdentityNumber;


public class SouthAfricanCitizen extends Person<SouthAfricanIdentityNumber> {
    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of
     * this class is not compatible with the previous version. It is not necessary to include
     * in first version of the class, but included here as a reminder of its importance.
     * 
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    private static final long serialVersionUID = 4838218942246647451L;

    public SouthAfricanCitizen() {
        super();
    }

    public SouthAfricanCitizen(Person<SouthAfricanIdentityNumber> template) {
        super(template);
    }

    public SouthAfricanCitizen(
            SouthAfricanIdentityNumber legalIdentifier,
            Iterable<EmailAddress> emailAddresses,
            Iterable<TelephoneNumber> numbers,
            Iterable<Address> addresses,
            Iterable<String> givenNames,
            Iterable<String> aka,
            String preferedGivenName,
            String nickName,
            String familyName,
            Date dateOfBirth,
            _4axka.common.entity.Person.GenderType gender,
            Iterable<_4axka.common.entity.Person.TitleType> titles) {
        super(
                legalIdentifier,
                emailAddresses,
                numbers,
                addresses,
                givenNames,
                aka,
                preferedGivenName,
                nickName,
                familyName,
                dateOfBirth,
                gender,
                titles);
    }
}
