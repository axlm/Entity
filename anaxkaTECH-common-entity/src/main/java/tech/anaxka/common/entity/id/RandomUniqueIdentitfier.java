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
package tech.anaxka.common.entity.id;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import static java.util.UUID.randomUUID;
import static tech.anaxka.common.utility.lang.CompareTo.GREATER_THAN;
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
public class RandomUniqueIdentitfier
        implements Serializable, Comparable<RandomUniqueIdentitfier> {
    private static final long serialVersionUID = -2333371160772410645L;

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

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final RandomUniqueIdentitfier that_ = RandomUniqueIdentitfier.class.cast(that);

            result_ = equalsBuilder().append(getId(), that_.getId()).build();
        }

        return result_;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(final RandomUniqueIdentitfier that) {
        if (isComparable(that)) {
            return compareToBuilder()
                    .append(getId(), that.getId())
                    .build();
        } else {
            return GREATER_THAN;
        }
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getId())
                .build();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Radix 32 Universally Unique Identity", getId())
                .append("super", super.toString())
                .build();
    }
}
