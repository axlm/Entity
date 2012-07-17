// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Person.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


import java.util.Date;
import java.util.Set;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 *
 */
public abstract class Person extends Entity {
    private Set<String> __givenNames;
    private Set<String> __alsoKnownAs;
    private String __preferedGivenName;
    private String __nickName;
    private String __familyName;
    private Date __dateOfBirth;
    private GenderType __gender;
    private Set<TitleType> __titles;

    public enum GenderType {
        FEMALE,
        MALE;
    }

    public enum TitleType {
        MISTER,
        MISSERS,
        MSS,
        MISS,
        PROFESSOR,
        DOCTOR,
        YOUR_EMINENCE,
        YOUR_HIGNESS,
        HONORABLE;
    }
}
