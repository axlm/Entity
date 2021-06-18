// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of RandomUniqueIdentity.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package tech.anaxka.common.entity.id;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import static java.util.UUID.randomUUID;
import static tech.anaxka.util.lang.CompareTo.*;
import static tech.anaxka.util.lang.Equals.equalsBuilder;
import static tech.anaxka.util.lang.Equals.isEquatable;
import static tech.anaxka.util.lang.HashCode.hashCodeBuilder;
import static tech.anaxka.util.lang.ToString.toStringBuilder;

/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 */
@XmlRootElement(name = "randomUniqueIdentity")
@XmlType(name = "RandomUniqueIdentity")
@Embeddable
public class RandomUniqueIdentitfier implements Serializable, Comparable<RandomUniqueIdentitfier> {

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
    private static final long serialVersionUID = -2315326616405271556L;

    @XmlElement(name = "radix32UUID", required = true)
    @Basic
    @Column(name = "RADIX_32_UUID", length = 63, nullable = false, unique = true)
    private String __id;

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public RandomUniqueIdentitfier() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * <p>
     * @param id Some identifier.
     */
    public RandomUniqueIdentitfier(final String id) {
        this();
        setId(id);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * <p>
     * @param template Uses template as template to initialise {@linkplain RandomUniqueIdentitfier
     *            <code>this</code>}.
     */
    public RandomUniqueIdentitfier(final RandomUniqueIdentitfier template) {
        this(template.getId());
    }

    /**
     * Creates a new {@link RandomUniqueIdentitfier}.
     * <p>
     * @return A newly created {@link RandomUniqueIdentitfier}.
     */
    public static RandomUniqueIdentitfier generate() {
        return new RandomUniqueIdentitfier(randomUUID().toString());
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__id identifier}.
     */
    public String getId() {
        return __id;
    }

    /**
     * Obvious.
     * <p>
     * @param id Value to assign to <code>this</code> {@linkplain #__id identifier}.
     */
    final void setId(final String id) {
        final BigInteger radix32Identifier_ = new BigInteger(id.getBytes(StandardCharsets.UTF_8));
        __id = radix32Identifier_.toString(32);
    }

    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final RandomUniqueIdentitfier that_ = (RandomUniqueIdentitfier) that;

            result_ = equalsBuilder().append(getId(), that_.getId()).build();
        }

        return result_;
    }

    @Override
    public int compareTo(final RandomUniqueIdentitfier that) {
        if (isComparable(that)) {
            return compareToBuilder()
                    .append(getId(), that.getId())
                    .build();
        } else {
            return EQUAL;
        }
    }

    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getId())
                .build();
    }

    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Radix 32 Universally Unique Identity", getId())
                .append("super", super.toString())
                .build();
    }
}
