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


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 * 
 */
// JAXB
@XmlRootElement(name = "telephoneNumber")
@XmlType(name = "TelephoneNumber")
// JPA
public class TelephoneNumber implements Serializable {
    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of
     * this class is not compatible with the previous version. It is not necessary to include
     * in first version of the class, but included here as a reminder of its importance.
     * 
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    @XmlTransient
    private static final long serialVersionUID = -4884737104059972604L;

    @XmlAttribute(name = "type", required = true)
    private TelephoneNumberType __type;

    @XmlElement(name = "coutryCode")
    private String __countryCode;

    @XmlElement(name = "areaCode")
    private String __areaCode;

    @XmlElement(name = "number", required = true, nillable = false)
    private String __number;

    @XmlElement(name = "extension")
    private String __extension;

    @XmlTransient
    private Entity<?> __entity;

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public TelephoneNumber() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param type
     * @param countryCode
     * @param areaCode
     * @param number
     * @param extension
     */
    public TelephoneNumber(
            final TelephoneNumberType type,
            final String countryCode,
            final String areaCode,
            final String number,
            final String extension) {
        this();
        setType(type);
        setCountryCode(countryCode);
        setAreaCode(areaCode);
        setNumber(number);
        setExtension(extension);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain TelephoneNumber
     *            <code>this</code>}.
     */
    public TelephoneNumber(final TelephoneNumber template) {
        this(
                template.getType(),
                template.getCountryCode(),
                template.getAreaCode(),
                template.getNumber(),
                template.getExtension());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__type telephone number type}.
     */
    public final TelephoneNumberType getType() {
        return __type;
    }

    /**
     * Obvious.
     * 
     * @param type
     *            Value to assign to <code>this</code> {@linkplain #__type telephone number type}.
     */
    final void setType(final TelephoneNumberType type) {
        __type = type;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__countryCode country code}.
     */
    public final String getCountryCode() {
        return __countryCode;
    }

    /**
     * Obvious.
     * 
     * @param code
     *            Value to assign to <code>this</code> {@linkplain #__countryCode country code}.
     */
    final void setCountryCode(final String code) {
        __countryCode = code;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__areaCode area code}.
     */
    public final String getAreaCode() {
        return __areaCode;
    }

    /**
     * Obvious.
     * 
     * @param code
     *            Value to assign to <code>this</code> {@linkplain #__areaCode area code}.
     */
    final void setAreaCode(final String code) {
        __areaCode = code;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__number number}.
     */
    public final String getNumber() {
        return __number;
    }

    /**
     * Obvious.
     * 
     * @param number
     *            Value to assign to <code>this</code> {@linkplain #__number number}.
     */
    final void setNumber(final String number) {
        __number = number;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__extension extension}.
     */
    public final String getExtension() {
        return __extension;
    }

    /**
     * Obvious.
     * 
     * @param extension
     *            Value to assign to <code>this</code> {@linkplain #__extension extension}.
     */
    final void setExtension(final String extension) {
        __extension = extension;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__entity entity reference}.
     */
    final Entity<?> getEntity() {
        return __entity;
    }

    /**
     * Obvious.
     * 
     * @param reference
     *            Value to assign to <code>this</code> {@linkplain #__entity entity reference}.
     */
    final void setEntity(final Entity<?> reference) {
        __entity = reference;
    }
    
    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    @XmlEnum
    public enum TelephoneNumberType {
        @XmlEnumValue("Home")
        HOME,
        @XmlEnumValue("Office")
        OFFICE,
        @XmlEnumValue("Mobile")
        MOBILE,
        @XmlEnumValue("Fax")
        FAX;
    }
}
