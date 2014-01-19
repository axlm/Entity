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
import java.util.Arrays;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import static tech.anaxka.common.utility.lang.CompareTo.GREATER_THAN;
import static tech.anaxka.common.utility.lang.CompareTo.compareToBuilder;
import static tech.anaxka.common.utility.lang.CompareTo.isComparable;
import static tech.anaxka.common.utility.lang.Equals.equalsBuilder;
import static tech.anaxka.common.utility.lang.Equals.isEquatable;
import static tech.anaxka.common.utility.lang.HashCode.hashCodeBuilder;
import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;


@XmlRootElement(name = "southAfricanIdentityDocument")
@XmlType(name = "SouthAfricanIdentityDocument")
@Embeddable
public class SouthAfricanIdentityDocument
        implements Serializable, Comparable<SouthAfricanIdentityDocument> {

    @XmlElement(name = "identityNumber", required = true, nillable = false)
    @Basic
    @Column(name = "IDENTITY_NUMBER", length = 20, nullable = false, unique = true)
    private String __number;

    @XmlElement(name = "image")
    @Lob
    @Column(name = "IMAGE")
    private Byte[] __image;

    @XmlElement(name = "releaseDate")
    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private Date __releaseDate;

    public SouthAfricanIdentityDocument() {
        super();
    }

    public SouthAfricanIdentityDocument(
            final String number,
            final Byte[] image,
            final Date releaseDate) {
        this();
        setIdentityNumber(number);
        setImage(image);
        setReleaseDate(releaseDate);
    }

    public SouthAfricanIdentityDocument(final SouthAfricanIdentityDocument template) {
        this(template.getIdentityNumber(), template.getImage(), template.getReleaseDate());
    }

    public String getIdentityNumber() {
        return __number;
    }

    final void setIdentityNumber(final String number) {
        __number = number;
    }

    public Byte[] getImage() {
        return Arrays.copyOf(__image, __image.length);
    }

    final void setImage(final Byte[] image) {
        __image = image;
    }

    public Date getReleaseDate() {
        return new Date(__releaseDate.getTime());
    }

    final void setReleaseDate(final Date date) {
        __releaseDate = date;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (isEquatable(this, that)) {
            final SouthAfricanIdentityDocument that_ = SouthAfricanIdentityDocument.class.cast(that);

            result_ = equalsBuilder()
                    .append(getIdentityNumber(), that_.getIdentityNumber())
                    .build();
        }

        return result_;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(final SouthAfricanIdentityDocument that) {
        if (isComparable(that)) {
            return compareToBuilder()
                    .append(getIdentityNumber(), that.getIdentityNumber())
                    .build();
        } else {
            return GREATER_THAN;
        }
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getIdentityNumber())
                .build();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Identity Number", getIdentityNumber())
                .append("Release Date", getReleaseDate())
                .append("super", super.toString())
                .build();
    }
}
