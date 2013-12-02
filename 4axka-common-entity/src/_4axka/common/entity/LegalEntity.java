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

import static _4axka.util.lang.ToString.unroll;
import static _4axka.util.lang.ToString.wrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
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
@XmlRootElement(name = "legalEntity")
@XmlType(name = "LegalEntity")
@XmlSeeAlso({Person.class})
@Entity(name = "LegalEntity")
@Table(
        name = "LEGAL_ENTITIES",
        schema = "ENTITY")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class LegalEntity<ID extends Serializable & Comparable<ID>> implements Serializable {

    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of this
     * class is not compatible with the previous version. It is not necessary to include in first
     * version of the class, but included here as a reminder of its importance.
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
    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @OrderBy("__type ASC")
    @JoinColumn(name = "ENTITY_FK", referencedColumnName = "ID")
    private final Set<EmailAddress> __emailAddresses = new ConcurrentSkipListSet<>();

    @XmlElementWrapper(name = "telephoneNumbers")
    @XmlElement(name = "telephoneNumber")
    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @OrderBy("__type ASC")
    @JoinColumn(name = "ENTITY_FK", referencedColumnName = "ID")
    private final Set<TelephoneNumber> __telephoneNumbers = new ConcurrentSkipListSet<>();

    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @OrderBy("__type ASC")
    @JoinColumn(name = "ENTITY_FK", referencedColumnName = "ID")
    private final Set<Address> __addresses = new ConcurrentSkipListSet<>();

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     *
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public LegalEntity() {
        super();
    }

    /**
     * Instance variable constructor. Initialise {@code this} instance with the specified arguments.
     * <i>For state specifications see the see also section</i>.
     *
     * @param legalIdentifier
     * @param emailAddresses
     * @param numbers
     * @param addresses
     */
    public LegalEntity(
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
     * @param template Uses template as template to initialise
     * {@linkplain LegalEntity {@code this}}.
     * @see super
     */
    public LegalEntity(final LegalEntity<ID> template) {
        this(
                template.getLegalIdentifier(),
                template.getEmailAddresses(),
                template.getTelephoneNumbers(),
                template.getAddresses());
    }

    /**
     * Obvious.
     *
     * @return The value of {@code this} instance's {@linkplain #__id id}.
     */
    public final Long getId() {
        return __id;
    }

    /**
     * Obvious.
     *
     * @return The value of {@code this} instance's {@linkplain #__version version}.
     */
    public final Integer getVersion() {
        return __version;
    }

    /**
     * Obvious.
     *
     * @return The value of {@code this} instance's {@linkplain #__legalIdentifier legal
     *         identifier}.
     */
    public final ID getLegalIdentifier() {
        return __legalIdentifier;
    }

    /**
     * Obvious.
     *
     * @param id Value to assign to {@code this} {@linkplain #__legalIdentifier legal
     *            identifier}.
     */
    protected final void setLegalIdentifier(final ID id) {
        __legalIdentifier = id;
    }

    /**
     * Obvious.
     *
     * @return The value of {@code this} instance's {@linkplain #__emailAddresses email
     *         addresses}.
     */
    public final Iterable<EmailAddress> getEmailAddresses() {
        // what about defensive copies?
        return Collections.unmodifiableSet(__emailAddresses);
    }

    /**
     * Obvious.
     *
     * @param address
     *      Instance to add to {@code this} {@linkplain #__emailAddresses email addresses}.
     * @return
     *      {@code true} if the {@linkplain Address address} was successfully added to {@code this}.
     */
    public final boolean addEmailAddress(final EmailAddress address) {
        return __emailAddresses.add(new EmailAddress(address));
    }

    /**
     * Obvious.
     *
     * @param addresses
     *      {@linkplain Iterable Collection} of {@linkplain EmailAddress email addresses} to add to
     *      {@code this}.
     * @return
     *      The {@link Address addresses} added to {@code this}.
     */
    public final Iterable<EmailAddress> addEmailAddresses(final Iterable<EmailAddress> addresses) {
        final List<EmailAddress> result_ = new ArrayList<>();

        for (final EmailAddress address_ : addresses) {
            if (addEmailAddress(address_)) {
                result_.add(address_);
            }
        }

        return result_;
    }

    /**
     * Obvious.
     *
     * @param addresses {@code Array} of {@linkplain EmailAddress email addresses} to add to
     * {@code this}.
     * @return The {@link Address addresses} added to {@code this}.
     */
    public final Iterable<EmailAddress> addEmailAddresses(final EmailAddress... addresses) {
        final List<EmailAddress> result_ = new ArrayList<>();

        for (final EmailAddress address_ : addresses) {
            if (addEmailAddress(address_)) {
                result_.add(address_);
            }
        }

        return result_;
    }

    /**
     * Obvious.
     *
     * @param address {@link EmailAddress} to remove from {@code this} {@linkplain #__emailAddresses
     *  		email addresses}.
     * @return {@code true} if the {@linkplain EmailAddress email addess} was removed.
     */
    public final boolean removeEmailAddress(final EmailAddress address) {
        return __emailAddresses.remove(address);
    }

    /**
     * Obvious.
     *
     * @return The value of {@code this} instance's {@linkplain #__telephoneNumbers
     *         telephone numbers}.
     */
    public final Iterable<TelephoneNumber> getTelephoneNumbers() {
        return __telephoneNumbers;
    }

    /**
     * Obvious.
     *
     * @param numbers {@linkplain Iterable Collection} of {@linkplain TreeNode telephone numbers} to
     * add to {@code this}.
     */
    public final void addTelephoneNumbers(final Iterable<TelephoneNumber> numbers) {
        for (final TelephoneNumber number_ : numbers) {
            addTelephoneNumber(number_);
        }
    }

    /**
     * Obvious.
     *
     * @param number Instance to add to {@code this} {@linkplain #__telephoneNumbers
     *            telephone numbers}.
     */
    public final void addTelephoneNumber(final TelephoneNumber number) {
        final TelephoneNumber number_ = new TelephoneNumber(number);
        __telephoneNumbers.add(number_);
    }

    /**
     * Obvious.
     *
     * @param number {@link TelephoneNumber} to remove from {@code this} {@linkplain
     *  		#__telephoneNumbers telephone numbers}.
     */
    public final void removeTelephoneNumber(final TelephoneNumber number) {
        if (__telephoneNumbers.contains(number)) {
            __telephoneNumbers.remove(number);
        }
    }

    /**
     * Obvious.
     *
     * @return The value of {@code this} instance's {@linkplain #__addresses addresses}.
     */
    public final Iterable<Address> getAddresses() {
        return __addresses;
    }

    /**
     * Obvious.
     *
     * @param addresses {@linkplain Iterable Collection} of {@linkplain Address addresses} to add to
     * {@code this}.
     */
    public final void addAddresses(final Iterable<Address> addresses) {
        for (final Address address_ : addresses) {
            addAddress(address_);
        }
    }

    /**
     * Obvious.
     *
     * @param address Instance to add to {@code this} {@linkplain #__addresses  addresses}.
     */
    public final void addAddress(final Address address) {
        final Address adress__ = new Address(address);
        __addresses.add(adress__);
    }

    /**
     * Obvious.
     *
     * @param address {@link TelephoneNumber} to remove from {@code this} {@linkplain #__addresses
     *  		addresses}.
     */
    public final void removeAddress(final Address address) {
        if (__addresses.contains(address)) {
            __addresses.remove(address);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder builder_ = new StringBuilder();

        final String loadedFrom_ = getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString();

        builder_.append("Contact@").append(System.identityHashCode(this))
                .append("{")
                .append("Id=").append(wrap(getId())).append(", ")
                .append("Version=").append(wrap(getVersion())).append(", ")
                .append("Legal Identifier=").append(wrap(getLegalIdentifier())).append(", ")
                .append("Email Addresses=").append(unroll(__emailAddresses)).append(", ")
                .append("Telephone Numbers=").append(unroll(__telephoneNumbers)).append(", ")
                .append("Addresses=").append(unroll(__addresses)).append(", ")
                .append("Bytecode Location=").append(loadedFrom_).append(", ")
                .append("super=").append(super.toString())
                .append("}");

        return builder_.toString();
    }
}
