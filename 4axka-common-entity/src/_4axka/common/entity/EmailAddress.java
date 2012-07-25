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

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
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
@XmlRootElement(name = "emailAddress")
@XmlType(name = "EmailAddress")
@javax.persistence.Entity(name = "EmailAddress")
@Table(name = "EMAIL_ADDRESSES")
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
    @Transient
    private static final long serialVersionUID = -5046751178904428274L;

    @XmlTransient
    @Id
    @TableGenerator(
            name = "email_address_id_generator",
            table = "PRIMARY_KEYS",
            pkColumnName = "GENERATOR",
            pkColumnValue = "email_address_id",
            valueColumnName = "VALUE")
    @Column(name = "ID")
    private Long __id;

    @XmlTransient
    @Version
    @Column(name = "VERSION_LOCK")
    private Integer __version;

    @XmlAttribute(name = "type", required = true)
    @Enumerated(EnumType.STRING)
    @Column(name = "EMAIL_ADDRESS_TYPE", length = 15, nullable = false)
    private EmailAddressType __type;

    @XmlElement(name = "address", required = true, nillable = false)
    @Basic
    @Column(name = "ADDRESS", length = 127, nullable = false)
    private String __address;

    @XmlTransient
    @ManyToOne(cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "ENTITY_FK", referencedColumnName = "ID")
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
     * @return The value of <code>this</code> instance's {@linkplain #__id id}.
     */
    public final Long getId() {
        return __id;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__version version}.
     */
    public final Integer getVersion() {
        return __version;
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
    @XmlType(name = "EmailAddressType")
    @XmlEnum
    public enum EmailAddressType {
        @XmlEnumValue("Home")
        HOME,
        @XmlEnumValue("Office")
        OFFICE;
    }
}
