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


import static _4axka.util.lang.ToString.wrap;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
// JAXB
@XmlRootElement(name = "address")
@XmlType(name = "Address")
// JPA
@Entity(name = "Address")
@Table(name = "ADDRESSES")
public class Address implements Serializable, Comparable<Address> {
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
    private static final long serialVersionUID = 4184492517262397439L;

    @XmlTransient
    @Id
    @TableGenerator(
            name = "address_id_generator",
            table = "PRIMARY_KEYS",
            pkColumnName = "GENERATOR",
            pkColumnValue = "address_id",
            valueColumnName = "VALUE")
    @Column(name = "ID")
    private Long __id;

    @XmlTransient
    @Version
    @Column(name = "VERSION_LOCK")
    private Integer __version;

    @XmlAttribute(name = "type", required = true)
    @Enumerated(EnumType.STRING)
    @Column(name = "ADDRESS_TYPE", length = 15, nullable = false)
    private AddressType __type;

    @XmlElement(name = "location", required = true, nillable = false)
    @Basic
    @Column(name = "LOCATION", length = 255, nullable = false)
    private String __location;

    @XmlElement(name = "suburb")
    @Basic
    @Column(name = "SUBURB", length = 63)
    private String __suburb;

    @XmlElement(name = "city", required = true, nillable = false)
    @Basic
    @Column(name = "CITY", length = 63, nullable = false)
    private String __city;

    @XmlElement(name = "region")
    @Basic
    @Column(name = "REGION", length = 63)
    private String __region;

    @XmlElement(name = "country")
    @Basic
    @Column(name = "COUNTRY", length = 63)
    private String __country;

    @XmlElement(name = "code", required = true, nillable = false)
    @Basic
    @Column(name = "CODE", length = 15, nullable = false)
    private String __code;

    @XmlTransient
    @ManyToOne(cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "ENTITY_FK", referencedColumnName = "ID")
    private LegalEntity<?> __entity;

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public Address() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param type
     * @param location
     * @param suburb
     * @param city
     * @param region
     * @param country
     * @param code
     */
    public Address(
            final AddressType type,
            final String location,
            final String suburb,
            final String city,
            final String region,
            final String country,
            final String code) {
        this();
        setType(type);
        setLocation(location);
        setSuburb(suburb);
        setCity(city);
        setRegion(region);
        setCountry(country);
        setCode(code);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain Address
     *            <code>this</code>}.
     */
    public Address(final Address template) {
        this(
                template.getType(),
                template.getLocation(),
                template.getSuburb(),
                template.getCity(),
                template.getRegion(),
                template.getCountry(),
                template.getCode());
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
     * @return The value of <code>this</code> instance's {@linkplain #__type address type}.
     */
    public final AddressType getType() {
        return __type;
    }

    /**
     * Obvious.
     * 
     * @param type
     *            Value to assign to <code>this</code> {@linkplain #__type address type}.
     */
    protected final void setType(final AddressType type) {
        __type = type;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__location location}.
     */
    public final String getLocation() {
        return __location;
    }

    /**
     * Obvious.
     * 
     * @param location
     *            Value to assign to <code>this</code> {@linkplain #__location location}.
     */
    protected final void setLocation(final String location) {
        __location = location;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__suburb suburb}.
     */
    public final String getSuburb() {
        return __suburb;
    }

    /**
     * Obvious.
     * 
     * @param suburb
     *            Value to assign to <code>this</code> {@linkplain #__suburb suburb}.
     */
    protected final void setSuburb(final String suburb) {
        __suburb = suburb;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__city city}.
     */
    public final String getCity() {
        return __city;
    }

    /**
     * Obvious.
     * 
     * @param city
     *            Value to assign to <code>this</code> {@linkplain #__city city}.
     */
    protected final void setCity(final String city) {
        __city = city;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__region region}.
     */
    public final String getRegion() {
        return __region;
    }

    /**
     * Obvious.
     * 
     * @param region
     *            Value to assign to <code>this</code> {@linkplain #__region region}.
     */
    protected final void setRegion(final String region) {
        __region = region;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__country country}.
     */
    public final String getCountry() {
        return __country;
    }

    /**
     * Obvious.
     * 
     * @param country
     *            Value to assign to <code>this</code> {@linkplain #__country country}.
     */
    protected final void setCountry(final String country) {
        __country = country;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__code code}.
     */
    public final String getCode() {
        return __code;
    }

    /**
     * Obvious.
     * 
     * @param code
     *            Value to assign to <code>this</code> {@linkplain #__code code}.
     */
    protected final void setCode(final String code) {
        __code = code;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__entity entity reference}.
     */
    protected final LegalEntity<?> getEntity() {
        return __entity;
    }

    /**
     * Obvious.
     * 
     * @param reference
     *            Value to assign to <code>this</code> {@linkplain #__entity entity reference}.
     */
    protected final void setEntity(final LegalEntity<?> reference) {
        __entity = reference;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (!(that.getClass().isAssignableFrom(Address.class))) {
            return false;
        }

        final Address that_ = Address.class.cast(that);
        if (getType() != that_.getType()) {
            return false;
        }
        if (getCode() == null) {
            if (that_.getCode() != null) {
                return false;
            }
        } else if (!getCode().equals(that_.getCode())) {
            return false;
        }
        if (getLocation() == null) {
            if (that_.getLocation() != null) {
                return false;
            }
        } else if (!getLocation().equals(that_.getLocation())) {
            return false;
        }
        if (getCity() == null) {
            if (that_.getCity() != null) {
                return false;
            }
        } else if (!getCity().equals(that_.getCity())) {
            return false;
        }
        if (getCity() == null) {
            if (that_.getCity() != null) {
                return false;
            }
        } else if (!getCity().equals(that_.getCity())) {
            return false;
        }

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(final Address that) {
        int result_ = 0;

        if (this == that) {
            return result_;
        }
        if (that == null) {
            return 1;
        }

        if (null == getType()) {
            if (null != that.getType()) {
                result_ = -1;
            }
        } else if (null != that.getType()) {
            result_ = getType().compareTo(that.getType());
        }
        if (result_ != 0) {
            return result_;
        }

        if (null == getCode()) {
            if (null != that.getCode()) {
                result_ = -1;
            }
        } else if (null != that.getCode()) {
            result_ = getCode().compareTo(that.getCode());
        }
        if (result_ != 0) {
            return result_;
        }

        if (null == getLocation()) {
            if (null != that.getLocation()) {
                result_ = -1;
            }
        } else if (null != that.getLocation()) {
            result_ = getLocation().compareTo(that.getLocation());
        }
        if (result_ != 0) {
            return result_;
        }

        if (null == getCity()) {
            if (null != that.getCity()) {
                result_ = -1;
            }
        } else if (null != that.getCity()) {
            result_ = getCity().compareTo(that.getCity());
        }
        if (result_ != 0) {
            return result_;
        }

        if (null == getSuburb()) {
            if (null != that.getSuburb()) {
                result_ = -1;
            }
        } else if (null != that.getSuburb()) {
            result_ = getSuburb().compareTo(that.getSuburb());
        }
        if (result_ != 0) {
            return result_;
        }

        return result_;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        int result_ = 1;

        final int PRIME = 31;
        result_ = PRIME * result_ + ((getType() == null) ? 0 : getType().hashCode());
        result_ = PRIME * result_ + ((getCode() == null) ? 0 : getCode().hashCode());
        result_ = PRIME * result_ + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result_ = PRIME * result_ + ((getCity() == null) ? 0 : getCity().hashCode());
        result_ = PRIME * result_ + ((getSuburb() == null) ? 0 : getSuburb().hashCode());

        return result_;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder builder_ = new StringBuilder();

        final String loadedFrom_ = getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString();

        builder_.append("Address@").append(System.identityHashCode(this))
                .append("{")
                .append("Id=").append(wrap(getId())).append(", ")
                .append("Version=").append(wrap(getVersion())).append(", ")
                .append("Type=").append(wrap(getType())).append(", ")
                .append("Location=").append(wrap(getLocation())).append(", ")
                .append("Suburb=").append(wrap(getSuburb())).append(", ")
                .append("City=").append(wrap(getCity())).append(", ")
                .append("Region=").append(wrap(getRegion())).append(", ")
                .append("Country=").append(wrap(getCountry())).append(", ")
                .append("Code=").append(wrap(getCode())).append(", ")
                .append("Bytecode Location=").append(loadedFrom_).append(", ")
                .append("super=").append(super.toString())
                .append("}");

        return builder_.toString();
    }

    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    @XmlEnum
    public enum AddressType {
        @XmlEnumValue("Home")
        HOME,
        @XmlEnumValue("Office")
        OFFICE,
        @XmlEnumValue("Postal")
        POSTAL;
    }
}
