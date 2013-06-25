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
@XmlRootElement(name = "telephoneNumber")
@XmlType(name = "TelephoneNumber")
@Entity(name = "TelephoneNumber")
@Table(name = "TELEPHONE_NUMBERS")
public class TelephoneNumber implements Serializable, Comparable<TelephoneNumber> {
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
    private static final long serialVersionUID = -4884737104059972604L;

    @XmlTransient
    @Id
    @TableGenerator(
            name = "telephone_number_id_generator",
            table = "PRIMARY_KEYS",
            pkColumnName = "GENERATOR",
            pkColumnValue = "telephone_number_id",
            valueColumnName = "VALUE")
    @Column(name = "ID")
    private Long __id;

    @XmlTransient
    @Version
    @Column(name = "VERSION_LOCK")
    private Integer __version;

    @XmlAttribute(name = "type", required = true)
    @Enumerated(EnumType.STRING)
    @Column(name = "TELEPHONE_NUMBER_TYPE", length = 15, nullable = false)
    private TelephoneNumberType __type;

    @XmlElement(name = "coutryCode")
    @Basic
    @Column(name = "COUNTRY_CODE", length = 7)
    private String __countryCode;

    @XmlElement(name = "areaCode")
    @Basic
    @Column(name = "AREA_CODE", length = 7)
    private String __areaCode;

    @XmlElement(name = "number", required = true, nillable = false)
    @Basic
    @Column(name = "NUMBER", length = 9, nullable = false)
    private String __number;

    @XmlElement(name = "extension")
    @Basic
    @Column(name = "EXTENSION", length = 9)
    private String __extension;

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
    public TelephoneNumber() {
        super();
    }

    /**
     * Instance variable constructor. Initialize <code>this</code> instance with the specified
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
    protected final void setType(final TelephoneNumberType type) {
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
    protected final void setCountryCode(final String code) {
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
    protected final void setAreaCode(final String code) {
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
    protected final void setNumber(final String number) {
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
    protected final void setExtension(final String extension) {
        __extension = extension;
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
        if (!(that.getClass().isAssignableFrom(TelephoneNumber.class))) {
            return false;
        }
        final TelephoneNumber that_ = TelephoneNumber.class.cast(that);

        if (getType() != that_.getType()) {
            return false;
        }
        if (getCountryCode() == null) {
            if (that_.getCountryCode() != null) {
                return false;
            }
        } else if (!getCountryCode().equals(that_.getCountryCode())) {
            return false;
        }
        if (getAreaCode() == null) {
            if (that_.getAreaCode() != null) {
                return false;
            }
        } else if (!getAreaCode().equals(that_.getAreaCode())) {
            return false;
        }
        if (getAreaCode() == null) {
            if (that_.getAreaCode() != null) {
                return false;
            }
        } else if (!getAreaCode().equals(that_.getAreaCode())) {
            return false;
        }

        return true;
    }

   /** {@inheritDoc} */
    @Override
    public int compareTo(final TelephoneNumber that) {
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

        if (null == getCountryCode()) {
            if (null != that.getCountryCode()) {
                result_ = -1;
            }
        } else if (null != that.getCountryCode()) {
            result_ = getCountryCode().compareTo(that.getCountryCode());
        }
        if (result_ != 0) {
            return result_;
        }

        if (null == getAreaCode()) {
            if (null != that.getAreaCode()) {
                result_ = -1;
            }
        } else if (null != that.getAreaCode()) {
            result_ = getAreaCode().compareTo(that.getAreaCode());
        }
        if (result_ != 0) {
            return result_;
        }

        if (null == getNumber()) {
            if (null != that.getNumber()) {
                result_ = -1;
            }
        } else if (null != that.getNumber()) {
            result_ = getNumber().compareTo(that.getNumber());
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
        result_ = PRIME * result_ + ((getAreaCode() == null) ? 0 : getAreaCode().hashCode());
        result_ = PRIME * result_ + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result_ = PRIME * result_ + ((getNumber() == null) ? 0 : getNumber().hashCode());

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

        builder_.append("TelephoneNumber@").append(System.identityHashCode(this))
                .append("{")
                .append("Id=").append(wrap(getId())).append(", ")
                .append("Version=").append(wrap(getVersion())).append(", ")
                .append("Type=").append(wrap(getType())).append(", ")
                .append("Contry Code=").append(wrap(getCountryCode())).append(", ")
                .append("Area Code=").append(wrap(getAreaCode())).append(", ")
                .append("Number=").append(wrap(getNumber())).append(", ")
                .append("Extension=").append(wrap(getExtension())).append(", ")
                .append("Bytecode Location=").append(loadedFrom_).append(", ")
                .append("super=").append(super.toString())
                .append("}");

        return builder_.toString();
    }


    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    @XmlType(name = "TelephoneNumberType")
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
