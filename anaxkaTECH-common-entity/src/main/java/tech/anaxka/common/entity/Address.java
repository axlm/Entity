/* 
 * Copyright © 2011, 4axka (Pty) Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */
package tech.anaxka.common.entity;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import static tech.anaxka.common.utility.lang.CompareTo.GREATER_THAN;
import static tech.anaxka.common.utility.lang.CompareTo.compareToBuilder;
import static tech.anaxka.common.utility.lang.CompareTo.isComparable;
import static tech.anaxka.common.utility.lang.Equals.equalsBuilder;
import static tech.anaxka.common.utility.lang.Equals.isEquatable;
import static tech.anaxka.common.utility.lang.HashCode.hashCodeBuilder;
import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 * <p/>
 */
@XmlRootElement(name = "address")
@XmlType(name = "Address")
@Entity(name = "Address")
@Table(name = "ADDRESSES")
public class Address
        implements Serializable, Comparable<Address> {
    @XmlTransient
    @Id
    @TableGenerator(
            name = "address_id_generator",
            table = "PRIMARY_KEYS",
            pkColumnName = "GENERATOR",
            pkColumnValue = "address_id",
            valueColumnName = "VALUE")
    @GeneratedValue(generator = "address_id_generator")
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

    /**
     * Default constructor.
     * <p/>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p/>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public Address() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * <p/>
     * @param type     see {@link #getType() type}.
     * @param location see {@link #getLocation() location}.
     * @param suburb   see {@link #getSuburb() suburb}.
     * @param city     see {@link #getCity() city}.
     * @param region   see {@link #getRegion() region}.
     * @param country  see {@link #getCountry() country}.
     * @param code     see {@link #getCode() code}.
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
     * <p/>
     * @param template Uses template as template to initialise {@linkplain Address
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

    void setId(final Long id) {
        __id = id;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__version version}.
     */
    public final Integer getVersion() {
        return __version;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__type address type}.
     */
    public final AddressType getType() {
        return __type;
    }

    /**
     * Obvious.
     * <p/>
     * @param type Value to assign to <code>this</code> {@linkplain #__type address type}.
     */
    final void setType(final AddressType type) {
        __type = type;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__location location}.
     */
    public final String getLocation() {
        return __location;
    }

    /**
     * Obvious.
     * <p/>
     * @param location Value to assign to <code>this</code> {@linkplain #__location location}.
     */
    final void setLocation(final String location) {
        __location = location;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__suburb suburb}.
     */
    public final String getSuburb() {
        return __suburb;
    }

    /**
     * Obvious.
     * <p/>
     * @param suburb Value to assign to <code>this</code> {@linkplain #__suburb suburb}.
     */
    final void setSuburb(final String suburb) {
        __suburb = suburb;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__city city}.
     */
    public final String getCity() {
        return __city;
    }

    /**
     * Obvious.
     * <p/>
     * @param city Value to assign to <code>this</code> {@linkplain #__city city}.
     */
    final void setCity(final String city) {
        __city = city;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__region region}.
     */
    public final String getRegion() {
        return __region;
    }

    /**
     * Obvious.
     * <p/>
     * @param region Value to assign to <code>this</code> {@linkplain #__region region}.
     */
    final void setRegion(final String region) {
        __region = region;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__country country}.
     */
    public final String getCountry() {
        return __country;
    }

    /**
     * Obvious.
     * <p/>
     * @param country Value to assign to <code>this</code> {@linkplain #__country country}.
     */
    final void setCountry(final String country) {
        __country = country;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__code code}.
     */
    public final String getCode() {
        return __code;
    }

    /**
     * Obvious.
     * <p/>
     * @param code Value to assign to <code>this</code> {@linkplain #__code code}.
     */
    final void setCode(final String code) {
        __code = code;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final Address that_ = Address.class.cast(that);

            result_ = equalsBuilder()
                    .append(getType(), that_.getType())
                    .append(getCode(), that_.getCode())
                    .append(getLocation(), that_.getLocation())
                    .append(getCity(), that_.getCity())
                    .build();
        }

        return result_;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(final Address that) {
        if (isComparable(that)) {
            return compareToBuilder()
                    .append(getType(), that.getType())
                    .append(getCode(), that.getCode())
                    .append(getLocation(), that.getLocation())
                    .append(getCity(), that.getCity())
                    .append(getSuburb(), that.getSuburb())
                    .build();
        } else {
            return GREATER_THAN;
        }
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getType())
                .append(getCode())
                .append(getLocation())
                .append(getCity())
                .append(getSuburb())
                .build();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Id", getId())
                .append("Version", getVersion())
                .append("Type", getType())
                .append("Location", getLocation())
                .append("Suburb", getSuburb())
                .append("City", getCity())
                .append("Region", getRegion())
                .append("Country", getCountry())
                .append("Code", getCode())
                .append("super", super.toString())
                .build();
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
        POSTAL,
        @XmlEnumValue("Unspecified")
        UNSPECIFIED;
    }
}
