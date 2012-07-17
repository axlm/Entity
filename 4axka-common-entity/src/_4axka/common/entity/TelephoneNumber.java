// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of TelephoneNumber.java is strictly CONFIDENTIAL.
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
public class TelephoneNumber {
    private TelephoneNumberType __type;
    private String __countryCode;
    private String __areaCode;
    private String __number;
    private String __extension;

    public enum TelephoneNumberType {
        HOME,
        OFFICE,
        MOBILE,
        FAX,
        PAGER;
    }
}
