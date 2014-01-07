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

import static _4axka.util.lang.CompareTo.compareToBuilder;
import static _4axka.util.lang.Equals.equalsBuilder;
import static _4axka.util.lang.Equals.isEquatable;
import static _4axka.util.lang.HashCode.hashCodeBuilder;
import static _4axka.util.lang.ToString.toStringBuilder;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
 * <p>
 */
@XmlRootElement(name = "telephoneNumber")
@XmlType(name = "TelephoneNumber")
@Entity(name = "TelephoneNumber")
@Table(
        name = "TELEPHONE_NUMBERS",
        schema = "ENTITY")
public class TelephoneNumber implements Serializable, Comparable<TelephoneNumber> {

    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of this
     * class is not compatible with the previous version. It is not necessary to include in first
     * version of the class, but included here as a reminder of its importance.
     * <p>
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

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public TelephoneNumber() {
        super();
    }

    /**
     * Instance variable constructor. Initialize <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * <p>
     * @param type        see {@link #getType() type}.
     * @param countryCode see {@link #getCountryCode() coutry code}.
     * @param areaCode    see {@link #getAreaCode() area code}.
     * @param number      see {@link #getNumber() number}.
     * @param extension   see {@link #getExtension() extension}.
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
     * <p>
     * @param template Uses template as template to initialise {@linkplain TelephoneNumber
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
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__id id}.
     */
    public final Long getId() {
        return __id;
    }

    void setId(final Long id) {
        __id = id;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__version version}.
     */
    public final Integer getVersion() {
        return __version;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__type telephone number type}.
     */
    public final TelephoneNumberType getType() {
        return __type;
    }

    /**
     * Obvious.
     * <p>
     * @param type Value to assign to <code>this</code> {@linkplain #__type telephone number type}.
     */
    final void setType(final TelephoneNumberType type) {
        __type = type;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__countryCode country code}.
     */
    public final String getCountryCode() {
        return __countryCode;
    }

    /**
     * Obvious.
     * <p>
     * @param code Value to assign to <code>this</code> {@linkplain #__countryCode country code}.
     */
    final void setCountryCode(final String code) {
        __countryCode = code;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__areaCode area code}.
     */
    public final String getAreaCode() {
        return __areaCode;
    }

    /**
     * Obvious.
     * <p>
     * @param code Value to assign to <code>this</code> {@linkplain #__areaCode area code}.
     */
    final void setAreaCode(final String code) {
        __areaCode = code;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__number number}.
     */
    public final String getNumber() {
        return __number;
    }

    /**
     * Obvious.
     * <p>
     * @param number Value to assign to <code>this</code> {@linkplain #__number number}.
     */
    final void setNumber(final String number) {
        __number = number;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__extension extension}.
     */
    public final String getExtension() {
        return __extension;
    }

    /**
     * Obvious.
     * <p>
     * @param extension Value to assign to <code>this</code> {@linkplain #__extension extension}.
     */
    final void setExtension(final String extension) {
        __extension = extension;
    }

    /**
     * {@inheritDoc}
     * <p>
     * @param that
     */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final TelephoneNumber that_ = TelephoneNumber.class.cast(that);

            result_ = equalsBuilder()
                    .append(getType(), that_.getType())
                    .append(getCountryCode(), that_.getCountryCode())
                    .append(getAreaCode(), that_.getAreaCode())
                    .append(getNumber(), that_.getNumber())
                    .isEqual();
        }

        return result_;
    }

    /**
     * {@inheritDoc}
     * <p>
     * @param that
     */
    @Override
    public int compareTo(final TelephoneNumber that) {
        return compareToBuilder()
                .append(getType(), that.getType())
                .append(getCountryCode(), that.getCountryCode())
                .append(getAreaCode(), that.getAreaCode())
                .append(getNumber(), that.getNumber())
                .compare();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getType())
                .append(getAreaCode())
                .append(getCountryCode())
                .append(getNumber())
                .hash();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Id", getId())
                .append("Version", getVersion())
                .append("Type", getType())
                .append("Contry Code", getCountryCode())
                .append("Area Code", getAreaCode())
                .append("Number", getNumber())
                .append("Extension", getExtension())
                .append("super", super.toString())
                .string();
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
        @XmlEnumValue("Satelite")
        SATELITE,
        @XmlEnumValue("Fax")
        FAX,
        @XmlEnumValue("Unspecified")
        UNSPECIFIED;
    }
}
