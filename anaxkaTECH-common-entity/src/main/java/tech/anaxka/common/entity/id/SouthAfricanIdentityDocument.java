// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of SouthAfricanIdentityDocument.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import static tech.anaxka.common.utility.lang.CompareTo.compareToBuilder;
import static tech.anaxka.common.utility.lang.Equals.equalsBuilder;
import static tech.anaxka.common.utility.lang.Equals.isEquatable;
import static tech.anaxka.common.utility.lang.HashCode.hashCodeBuilder;
import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;

@XmlRootElement(name = "southAfricanIdentityDocument")
@XmlType(name = "SouthAfricanIdentityDocument")
@Embeddable
public class SouthAfricanIdentityDocument implements Serializable, Comparable<SouthAfricanIdentityDocument> {

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
    private static final long serialVersionUID = -3101634788383695583L;

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

    /**
     * @{inheritDoc}
     * @param that
     */
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

    /**
     * @{inheritDoc}
     * @param that
     */
    @Override
    public int compareTo(final SouthAfricanIdentityDocument that) {
        return compareToBuilder()
                .append(getIdentityNumber(), that.getIdentityNumber())
                .build();
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getIdentityNumber())
                .build();
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Identity Number", getIdentityNumber())
                .append("Release Date", getReleaseDate())
                .append("super", super.toString())
                .build();
    }
}
