// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of LegalEntity.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 * 
 * @param <ID>
 */
@XmlRootElement(name = "entity")
@XmlType(name = "Entity")
@XmlSeeAlso({Person.class})
@javax.persistence.Entity(name = "Entity") // there are complaints if the fqn is not used
@Table(name = "ENTITIES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Entity<ID extends Comparable<ID> & Serializable> implements Serializable {
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
    @Transient
    private static final long serialVersionUID = 2724081153382480314L;

    @XmlTransient
    @Id
    @TableGenerator(
            name = "entity_id_generator",
            table = "PRIMARY_KEYS",
            pkColumnName = "GENERATOR",
            pkColumnValue = "entity_id",
            valueColumnName = "VALUE")
    @Column(name = "ID")
    private Long __id;

    @XmlTransient
    @Version
    @Column(name = "VERSION_LOCK")
    private Integer __version;

    @XmlElement(name = "identifier", required = true, nillable = false)
    @Embedded
    private ID __legalIdentifier;

    @XmlElementWrapper(name = "emailAddresses")
    @XmlElement(name = "emailAddress")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "__entity")
    private Set<EmailAddress> __emailAddresses = new ConcurrentSkipListSet<>();

    @XmlElementWrapper(name = "telephoneNumbers")
    @XmlElement(name = "telephoneNumber")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "__entity")
    private Set<TelephoneNumber> __telephoneNumbers = new ConcurrentSkipListSet<>();

    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "__entity")
    private Set<Address> __addresses = new ConcurrentSkipListSet<>();

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public Entity() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param legalIdentifier
     * @param emailAddresses
     * @param numbers
     * @param addresses
     */
    public Entity(
            final ID legalIdentifier,
            final Iterable<EmailAddress> emailAddresses,
            final Iterable<TelephoneNumber> numbers,
            final Iterable<Address> addresses) {
        this();
        setLegalIdentifier(legalIdentifier);
        addEmailAddresses(emailAddresses);
        addTelephoneNumbers(numbers);
        addAddresses(addresses);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain Entity <code>this</code>}.
     * @see super
     */
    public Entity(final Entity<ID> template) {
        this(
                template.getLegalIdentifier(),
                template.getEmailAddresses(),
                template.getTelephoneNumbers(),
                template.getAddresses());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__id id}.
     */
    public final Long getId() {
        return __id;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__version version}.
     */
    public final Integer getVersion() {
        return __version;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__legalIdentifier legal
     *         identifier}.
     */
    public final ID getLegalIdentifier() {
        return __legalIdentifier;
    }

    /**
     * Obvious.
     * 
     * @param ID
     *            Value to assign to <code>this</code> {@linkplain #__legalIdentifier legal
     *            identifier}.
     */
    final void setLegalIdentifier(final ID id) {
        __legalIdentifier = id;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__emailAddresses email
     *         addresses}.
     */
    public final Iterable<EmailAddress> getEmailAddresses() {
        return __emailAddresses;
    }

    /**
     * Obvious.
     * 
     * @param addresses
     *            {@linkplain Iterable Collection} of {@linkplain EmailAddress email addresses}
     *            to add to <code>this</code>.
     */
    public final void addEmailAddresses(final Iterable<EmailAddress> addresses) {
        for (final EmailAddress address_ : addresses) {
            addEmailAddress(address_);
        }
    }

    /**
     * Obvious.
     * 
     * @param address
     *            Instance to add to <code>this</code> {@linkplain #__emailAddresses email
     *            addresses}.
     */
    public final void addEmailAddress(final EmailAddress address) {
        final EmailAddress address_ = new EmailAddress(address);
        address_.setEntity(this);
        __emailAddresses.add(address_);
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__telephoneNumbers
     *         telephone numbers}.
     */
    public final Iterable<TelephoneNumber> getTelephoneNumbers() {
        return __telephoneNumbers;
    }


    /**
     * Obvious.
     * 
     * @param numbers
     *            {@linkplain Iterable Collection} of {@linkplain TreeNode telephone numbers}
     *            to add to <code>this</code>.
     */
    public final void addTelephoneNumbers(final Iterable<TelephoneNumber> numbers) {
        for (final TelephoneNumber number_ : numbers) {
            addTelephoneNumber(number_);
        }
    }
    
    /**
     * Obvious.
     * 
     * @param numbers
     *            Instance to add to <code>this</code> {@linkplain #__telephoneNumbers
     *            telephone numbers}.
     */
    public final void addTelephoneNumber(final TelephoneNumber number) {
        final TelephoneNumber number_ = new TelephoneNumber(number);
        number_.setEntity(this);
        __telephoneNumbers.add(number_);
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__addresses addresses}.
     */
    public final Iterable<Address> getAddresses() {
        return __addresses;
    }


    /**
     * Obvious.
     * 
     * @param addresses
     *            {@linkplain Iterable Collection} of {@linkplain Address addresses} to add to
     *            <code>this</code>.
     */
    public final void addAddresses(final Iterable<Address> addresses) {
        for (final Address address_ : addresses) {
            addAddress(address_);
        }
    }

    /**
     * Obvious.
     * 
     * @param address
     *            Instance to add to <code>this</code> {@linkplain #__addresses  addresses}.
     */
    public final void addAddress(final Address address) {
        final Address address_ = new Address(address);
        address_.setEntity(this);
        __addresses.add(address_);
    }
}
