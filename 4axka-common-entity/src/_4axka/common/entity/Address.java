// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Address.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 * 
 */
public class Address {
    private AddressType __type;
    private String __location;
    private String __suburb;
    private String __city;
    private String __region;
    private String __country;
    private String __code;

    public enum AddressType {
        HOME,
        OFFICE,
        POSTAL;
    }
}
