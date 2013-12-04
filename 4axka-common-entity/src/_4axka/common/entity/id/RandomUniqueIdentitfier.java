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
package _4axka.common.entity.id;

import static _4axka.util.lang.CompareTo.compareToBuilder;
import static _4axka.util.lang.Equals.equalsBuilder;
import static _4axka.util.lang.Equals.isEquatable;
import static _4axka.util.lang.ToString.wrap;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

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

    @XmlElement(name = "radix32UUID", required = true, nillable = false)
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
     * @param id
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
        return new RandomUniqueIdentitfier(UUID.randomUUID().toString());
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
        final BigInteger radix32Identifier_ = new BigInteger(id.getBytes());
        __id = radix32Identifier_.toString(32);
    }

    /**
     * @param that
     * @{inheritDoc}
     */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final RandomUniqueIdentitfier that_ = RandomUniqueIdentitfier.class.cast(that);

            result_ = equalsBuilder().append(getId(), that_.getId()).isEqual();
        }

        return result_;
    }

    /**
     * @param that
     * @{inheritDoc}
     */
    @Override
    public int compareTo(final RandomUniqueIdentitfier that) {
        return compareToBuilder()
                .append(getId(), that.getId())
                .compare();
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public int hashCode() {
        int result_ = 1;
        final int PRIME = 31;

        result_ = PRIME * result_ + ((getId() == null) ? 0 : getId().hashCode());

        return result_;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder builder_ = new StringBuilder();

        final String loadedFrom_ = getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString();

        builder_.append("RandomUniqueIdentitfier@").append(System.identityHashCode(this))
                .append("=[")
                .append("Radix 32 Universally Unique Identity=").append(wrap(getId())).append(", ")
                .append("Bytecode Location=").append(loadedFrom_).append(", ")
                .append("super=[").append(super.toString()).append("]")
                .append("]");

        return builder_.toString();
    }
}
