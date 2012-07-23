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


import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 */
// JAXB
@XmlRootElement(name = "randomUniqueIdentity")
@XmlType(name = "RandomUniqueIdentity")
// JPA
public final class RandomUniqueIdentitfier implements Serializable {
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
    private static final long serialVersionUID = -2315326616405271556L;

    @XmlElement(name = "radix32UUID", required = true, nillable = false)
    private String __id;

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public RandomUniqueIdentitfier() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param id
     */
    public RandomUniqueIdentitfier(final String id) {
        this();
        setId(id);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain RandomUniqueIdentitfier
     *            <code>this</code>}.
     */
    public RandomUniqueIdentitfier(final RandomUniqueIdentitfier template) {
        this(template.getId());
    }

    /**
     * Creates a new {@link RandomUniqueIdentitfier}.
     * 
     * @return A newly created {@link RandomUniqueIdentitfier}.
     */
    public static RandomUniqueIdentitfier generate() {
        return new RandomUniqueIdentitfier(UUID.randomUUID().toString());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__id identifier}.
     */
    public String getId() {
        return __id;
    }

    /**
     * Obvious.
     * 
     * @param id
     *            Value to assign to <code>this</code> {@linkplain #__id identifier}.
     */
    void setId(final String id) {
        final BigInteger octalFormatter_ = new BigInteger(id.getBytes());
        __id = octalFormatter_.toString(32);
    }
}
