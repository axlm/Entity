// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of EmailAddress.java is strictly CONFIDENTIAL.
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
//XML ANNOTATIONS
@XmlRootElement(name = "emailAddress")
@XmlType(name = "EmailAddress")
//ENTITY ANNOTATIONS
public class EmailAddress implements Serializable {
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
    private static final long serialVersionUID = -5046751178904428274L;

    @XmlAttribute(name = "type", required = true)
    private EmailAddressType __type;

    @XmlElement(name = "address", required = true, nillable = false)
    private String __address;

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
    public EmailAddress() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param type
     * @param address
     */
    public EmailAddress(final EmailAddressType type, final String address) {
        this();
        setType(type);
        setAddress(address);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain EmailAddress
     *            <code>this</code>}.
     */
    public EmailAddress(final EmailAddress template) {
        this(template.getType(), template.getAddress());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__type type}.
     */
    public final EmailAddressType getType() {
        return __type;
    }

    /**
     * Obvious.
     * 
     * @param type
     *            Value to assign to <code>this</code> {@linkplain #__type email address type}.
     */
    final void setType(final EmailAddressType type) {
        __type = type;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__address address}.
     */
    public final String getAddress() {
        return __address;
    }

    /**
     * Obvious.
     * 
     * @param address
     *            Value to assign to <code>this</code> {@linkplain #__address address}.
     */
    final void setAddress(final String address) {
        __address = address;
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
    public enum EmailAddressType {
        @XmlEnumValue("Home")
        HOME,
        @XmlEnumValue("Office")
        OFFICE;
    }
}
