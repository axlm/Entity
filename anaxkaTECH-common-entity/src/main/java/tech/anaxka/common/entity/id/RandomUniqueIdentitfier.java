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
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import static java.util.UUID.randomUUID;
import static tech.anaxka.common.utility.lang.CompareTo.EQUAL;
import static tech.anaxka.common.utility.lang.CompareTo.compareToBuilder;
import static tech.anaxka.common.utility.lang.CompareTo.isComparable;
import static tech.anaxka.common.utility.lang.Equals.equalsBuilder;
import static tech.anaxka.common.utility.lang.Equals.isEquatable;
import static tech.anaxka.common.utility.lang.HashCode.hashCodeBuilder;
import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;

/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 */
@XmlRootElement(name = "randomUniqueIdentity")
@XmlType(name = "RandomUniqueIdentity")
@Embeddable
public class RandomUniqueIdentitfier implements Serializable, Comparable<RandomUniqueIdentitfier> {

    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p/>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of this
     * class is not compatible with the previous version. It is not necessary to include in first
     * version of the class, but included here as a reminder of its importance.
     * <p/>
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    @XmlTransient
    @Transient
    private static final long serialVersionUID = -2315326616405271556L;

    @XmlElement(name = "radix32UUID", required = true, nillable = false)
    @Basic
    @Column(name = "RADIX_32_UUID", length = 63, nullable = false, unique = true)
    private String __id;

    /**
     * Default constructor.
     * <p/>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p/>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public RandomUniqueIdentitfier() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * <p/>
     * @param id
     */
    public RandomUniqueIdentitfier(final String id) {
        this();
        setId(id);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * <p/>
     * @param template Uses template as template to initialise {@linkplain RandomUniqueIdentitfier
     *            <code>this</code>}.
     */
    public RandomUniqueIdentitfier(final RandomUniqueIdentitfier template) {
        this(template.getId());
    }

    /**
     * Creates a new {@link RandomUniqueIdentitfier}.
     * <p/>
     * @return A newly created {@link RandomUniqueIdentitfier}.
     */
    public static RandomUniqueIdentitfier generate() {
        return new RandomUniqueIdentitfier(randomUUID().toString());
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__id identifier}.
     */
    public String getId() {
        return __id;
    }

    /**
     * Obvious.
     * <p/>
     * @param id Value to assign to <code>this</code> {@linkplain #__id identifier}.
     */
    final void setId(final String id) {
        try {
            final BigInteger radix32Identifier_ = new BigInteger(id.getBytes("UTF8"));
            __id = radix32Identifier_.toString(32);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RandomUniqueIdentitfier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param that
     * <p/>
     * @{inheritDoc}
     */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final RandomUniqueIdentitfier that_ = RandomUniqueIdentitfier.class.cast(that);

            result_ = equalsBuilder().append(getId(), that_.getId()).build();
        }

        return result_;
    }

    /**
     * @param that
     * <p/>
     * @{inheritDoc}
     */
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

    /**
     * @{inheritDoc}
     */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getId())
                .build();
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Radix 32 Universally Unique Identity", getId())
                .append("super", super.toString())
                .build();
    }
}
