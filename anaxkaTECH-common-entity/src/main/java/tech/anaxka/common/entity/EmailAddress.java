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
@XmlRootElement(name = "emailAddress")
@XmlType(name = "EmailAddress")
@Entity(name = "EmailAddress")
@Table(name = "EMAIL_ADDRESSES")
public class EmailAddress
        implements Serializable, Comparable<EmailAddress> {
    private static final long serialVersionUID = -7280360135659131354L;

    @XmlTransient
    @Id
    @TableGenerator(
            name = "email_address_id_generator",
            table = "PRIMARY_KEYS",
            pkColumnName = "GENERATOR",
            pkColumnValue = "email_address_id",
            valueColumnName = "VALUE")
    @GeneratedValue(generator = "email_address_id_generator")
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

    /**
     * Default constructor.
     * <p/>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p/>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public EmailAddress() {
        super();
    }

    /**
     * Instance variable constructor. Initialise {@code this} instance with the specified arguments.
     * <i>For state specifications see the see also section</i>.
     * <p/>
     * @param type    see {@link #getType() type}.
     * @param address see {@link #getAddress() address}.
     */
    public EmailAddress(final EmailAddressType type, final String address) {
        this();
        setType(type);
        setAddress(address);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * <p/>
     * @param template Uses template as template to initialise {@linkplain EmailAddress
     *            {@code this}}.
     */
    public EmailAddress(final EmailAddress template) {
        this(template.getType(), template.getAddress());
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of {@code this} instance's {@linkplain #__id id}.
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
     * @return The value of {@code this} instance's {@linkplain #__version version}.
     */
    public final Integer getVersion() {
        return __version;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of {@code this} instance's {@linkplain #__type type}.
     */
    public final EmailAddressType getType() {
        return __type;
    }

    /**
     * Obvious.
     * <p/>
     * @param type Value to assign to {@code this} {@linkplain #__type email address type}.
     */
    final void setType(final EmailAddressType type) {
        __type = type;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of {@code this} instance's {@linkplain #__address address}.
     */
    public final String getAddress() {
        return __address;
    }

    /**
     * Obvious.
     * <p/>
     * @param address Value to assign to {@code this} {@linkplain #__address address}.
     */
    final void setAddress(final String address) {
        __address = address;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final EmailAddress that_ = EmailAddress.class.cast(that);

            result_ = equalsBuilder()
                    .append(getType(), that_.getType())
                    .append(getAddress(), that_.getAddress())
                    .build();
        }

        return result_;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(final EmailAddress that) {
        if (isComparable(that)) {
            return compareToBuilder()
                    .append(getType(), that.getType())
                    .append(getAddress(), that.getAddress())
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
                .append(getAddress())
                .build();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Id", getId())
                .append("Version", getVersion())
                .append("Type", getType())
                .append("Address", getAddress())
                .append("super", super.toString())
                .build();
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
        OFFICE,
        @XmlEnumValue("Unspecified")
        UNSPECIFIED;
    }
}
