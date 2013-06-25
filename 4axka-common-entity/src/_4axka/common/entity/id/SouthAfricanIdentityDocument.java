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
package _4axka.common.entity.id;


import static _4axka.util.lang.ToString.wrap;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "southAfricanIdentityDocument")
@XmlType(name = "SouthAfricanIdentityDocument")
@Embeddable
public final class SouthAfricanIdentityDocument implements Serializable, Comparable<SouthAfricanIdentityDocument> {
    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of
     * this class is not compatible with the previous version. It is not necessary to include
     * in first version of the class, but included here as a reminder of its importance.
     * 
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    @XmlTransient
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

    void setIdentityNumber(final String number) {
        __number = number;
    }

    public Byte[] getImage() {
        return __image;
    }

    void setImage(final Byte[] image) {
        __image = image;
    }

    public Date getReleaseDate() {
        return __releaseDate;
    }

    void setReleaseDate(final Date date) {
        __releaseDate = date;
    }

    /** @{inheritDoc} */
    @Override
    public boolean equals(final Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (!(that.getClass().isAssignableFrom(SouthAfricanIdentityDocument.class))) {
            return false;
        }
        final SouthAfricanIdentityDocument that_ = SouthAfricanIdentityDocument.class.cast(that);

        if (getIdentityNumber() == null) {
            if (that_.getIdentityNumber() != null) {
                return false;
            }
        } else if (!getIdentityNumber().equals(that_.getIdentityNumber())) {
            return false;
        }
        
        return true;
    }
    
    /** @{inheritDoc} */
    @Override
    public int compareTo(final SouthAfricanIdentityDocument that) {
        int result_ = 0;

        if (this == that) {
            return result_;
        }
        if (that == null) {
            return 1;
        }

        if (null == getIdentityNumber()) {
            if (null != that.getIdentityNumber()) {
                result_ = -1;
            }
        } else if (null != that.getIdentityNumber()) {
            result_ = getIdentityNumber().compareTo(that.getIdentityNumber());
        }
        if (result_ != 0) {
            return result_;
        }

        return result_;
    }

    /** @{inheritDoc} */
    @Override
    public int hashCode() {
        int result_ = 1;

        final int PRIME = 31;
        result_ = PRIME * result_ + ((getIdentityNumber() == null) ? 0 : getIdentityNumber().hashCode());

        return result_;
    }

    /** @{inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder builder_ = new StringBuilder();
        
        final String loadedFrom_ = getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString();
        
        builder_.append("SouthAfricanIdentityDocument@").append(System.identityHashCode(this))
                .append("{")
                .append("Identity Number=").append(wrap(getIdentityNumber())).append(", ")
                .append("Release Date=").append(wrap(getReleaseDate())).append(", ")
                .append("Bytecode Location=").append(loadedFrom_).append(", ")
                .append("super=").append(super.toString())
                .append("}");
        
        return builder_.toString();
    }
}
