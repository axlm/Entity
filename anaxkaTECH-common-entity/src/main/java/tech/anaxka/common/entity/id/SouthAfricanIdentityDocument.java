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
