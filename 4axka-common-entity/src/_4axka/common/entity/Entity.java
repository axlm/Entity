// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of LegalEntity.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


import java.io.Serializable;
import java.util.Set;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 * 
 * @param <ID>
 */
public abstract class Entity<ID extends Comparable<ID> & Serializable> {
    private ID __legalIdentifier;
    private Set<EmailAddress> __emailAddresses;
    private Set<TelephoneNumber> __telephoneNumbers;
    private Set<Address> __addresses;
}
