// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Person.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


import static _4axka.util.lang.ToString.wrap;
import static _4axka.util.lang.ToString.unroll;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 *
 */
@XmlRootElement(name = "person")
@XmlType(name = "Person")
@Entity(name = "Person")
@Table(name = "PERSONS")
public abstract class Person<ID extends Comparable<ID> & Serializable> extends Contact<ID> {
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
    private static final long serialVersionUID = -1623837639963962157L;

    @XmlElementWrapper(name = "givenNames", required = true, nillable = false)
    @XmlElement(name = "name")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "GIVEN_NAMES")
    @Column(name = "GIVEN_NAME", length = 63, nullable = false)
    private Set<String> __givenNames = new ConcurrentSkipListSet<>();

    @XmlElementWrapper(name = "aliases")
    @XmlElement(name = "alias")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ALIASES")
    @Column(name = "ALIAS", length = 63, nullable = false)
    private Set<String> __alsoKnownAs = new ConcurrentSkipListSet<>();

    @XmlElement(name = "preferredGivenName")
    @Basic
    @Column(name = "PREFERRED_GIVEN_NAME", length = 63)
    private String __preferredGivenName;

    @XmlElement(name = "nickName")
    @Basic
    @Column(name = "NICK_NAME", length = 31)
    private String __nickName;

    @XmlElement(name = "familyName", required = true, nillable = false)
    @Basic
    @Column(name = "FAMILY_NAME", length = 63, nullable = false)
    private String __familyName;

    @XmlElement(name = "dateOfBirht")
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    private Date __dateOfBirth;

    @XmlElement(name = "gender")
    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 7)
    private GenderType __gender;

    @XmlElementWrapper(name = "titles")
    @XmlElement(name = "title")
    // TODO: this should be a unidirectional many to one form the TitleType side to act like a
    // lookup.
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TITLES")
    @Column(name = "TITLE", length = 15)
    private Set<TitleType> __titles = new ConcurrentSkipListSet<>();

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public Person() {
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
     * @param givenNames
     * @param aka
     * @param preferedGivenName
     * @param nickName
     * @param familyName
     * @param dateOfBirth
     * @param gender
     * @param titles
     */
    public Person(
            // ENTITY PARAMETERS
            final ID legalIdentifier,
            final Iterable<EmailAddress> emailAddresses,
            final Iterable<TelephoneNumber> numbers,
            final Iterable<Address> addresses,
            // PERSON PARAMETERS
            final Iterable<String> givenNames,
            final Iterable<String> aka,
            final String preferedGivenName,
            final String nickName,
            final String familyName,
            final Date dateOfBirth,
            final GenderType gender,
            final Iterable<TitleType> titles) {
        super(legalIdentifier, emailAddresses, numbers, addresses);
        addGivenNames(givenNames);
        addAliases(aka);
        setPreferredGivenName(preferedGivenName);
        setNickName(nickName);
        setFamilyName(familyName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        addTitles(titles);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain Person <code>this</code>}.
     */
   public Person(final Person<ID> template) {
        super(template);
        addGivenNames(template.getGivenNames());
        addAliases(template.getAlsoKnownAs());
        setPreferredGivenName(template.getPreferredGivenName());
        setNickName(template.getNickName());
        setFamilyName(template.getFamilyName());
        setDateOfBirth(template.getDateOfBirth());
        setGender(template.getGender());
        addTitles(template.getTitles());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__givenNames given names}.
     */
    public final Iterable<String> getGivenNames() {
        return __givenNames;
    }

    /**
     * Obvious.
     * 
     * @param names
     *            {@linkplain Iterable Collection} of {@linkplain #__givenNames given names} to
     *            add to <code>this</code> instance.
     */     
    public final void addGivenNames(final Iterable<String> names) {
        for (final String name_ : names) {
            addGivenName(name_);
        }
    }

    /**
     * Obvious.
     * 
     * @param name
     *            Instance of given name to add to <code>this</code> {@linkplain #__givenNames
     *            given names} instance.
     */
    public final void addGivenName(final String name) {
        __givenNames.add(name);
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's initials.
     */
    public final String getInitials() {
        final StringBuilder builder_ = new StringBuilder();

        for (final String name_ : getGivenNames()) {
            builder_.append(name_.charAt(0)).append(". ");
        }

        return builder_.toString();
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__alsoKnownAs aliases}.
     */
    public final Iterable<String> getAlsoKnownAs() {
        return __alsoKnownAs;
    }

    /**
     * Obvious.
     * 
     * @param aka
     *            {@linkplain Iterable Collection} of {@linkplain # aliases} to add to
     *            <code>this</code> instance.
     */
    public final void addAliases(final Iterable<String> aka) {
        for (final String alias_ : aka) {
            addAlias(alias_);
        }
    }

    /**
     * Obvious.
     * 
     * @param alias
     *            Instance of an alias to add to <code>this</code> {@linkplain #__alsoKnownAs
     *            aliases} instance.
     */
    public final void addAlias(final String alias) {
        __alsoKnownAs.add(alias);
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__preferredGivenName
     *         preferred given name}.
     */
    public final String getPreferredGivenName() {
        return __preferredGivenName;
    }

    /**
     * Obvious.
     * 
     * @param name
     *            Value to assign to <code>this</code> {@linkplain #__preferredGivenName
     *            preferred given name}.
     */
    final void setPreferredGivenName(final String name) {
        __preferredGivenName = name;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__nickName nickname}.
     */
    public final String getNickName() {
        return __nickName;
    }

    /**
     * Obvious.
     * 
     * @param name
     *            Value to assign to <code>this</code> {@linkplain #__nickName nick name}.
     */
    final void setNickName(final String name) {
        __nickName = name;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__familyName family name}.
     */
    public final String getFamilyName() {
        return __familyName;
    }

    /**
     * Obvious.
     * 
     * @param name
     *            Value to assign to <code>this</code> {@linkplain #__familyName family name}.
     */
    final void setFamilyName(final String name) {
        __familyName = name;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__dateOfBirth date of birth}.
     */
    public final Date getDateOfBirth() {
        return __dateOfBirth;
    }

    /**
     * Obvious.
     * 
     * @param date
     *            Value to assign to <code>this</code> {@linkplain #__dateOfBirth date of birth}.
     */
    final void setDateOfBirth(final Date date) {
        __dateOfBirth = date;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__gender gender}.
     */
    public final GenderType getGender() {
        return __gender;
    }

    /**
     * Obvious.
     * 
     * @param gender
     *            Value to assign to <code>this</code> {@linkplain #__gender gender}.
     */
    final void setGender(final GenderType gender) {
        __gender = gender;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__titles titiles}.
     */
    public final Iterable<TitleType> getTitles() {
        return __titles;
    }

    /**
     * Obvious.
     * 
     * @param titles
     *            Value to assign to <code>this</code> {@linkplain #__titles titles}.
     */
    public final void addTitles(final Iterable<TitleType> titles) {
        for (final TitleType title_ : titles) {
            addTitle(title_);
        }
    }

    /**
     * Obvious.
     * 
     * @param title
     *            Instance of title to add to <code>this</code> {@linkplain #__titles titles}
     *            instance.
     */
    public final void addTitle(final TitleType title) {
        __titles.add(title);
    }

    @Override
    public String toString() {
        final StringBuilder builder_ = new StringBuilder();

        final String loadedFrom_ = getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString();

        builder_.append("Person@").append(System.identityHashCode(this))
                .append("{")
                .append("Id=").append(wrap(getId())).append(", ")
                .append("Version=").append(wrap(getVersion())).append(", ")
                .append("Given Names=").append(unroll(__givenNames)).append(", ")
                .append("Initials=").append(wrap(getInitials())).append(", ")
                .append("Family Name=").append(wrap(getFamilyName())).append(", ")
                .append("Also Known As=").append(unroll(__alsoKnownAs)).append(", ")
                .append("Preferred Given Name=").append(wrap(getPreferredGivenName())).append(", ")
                .append("Date of Birth=").append(wrap(getDateOfBirth())).append(", ")
                .append("Gender=").append(wrap(getGender())).append(", ")
                .append("Titles=").append(unroll(__titles)).append(", ")
                .append("Bytecode Location=").append(loadedFrom_).append(", ")
                .append("super=").append(super.toString())
                .append("}");

        return builder_.toString();
    }

    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    @XmlType(name = "GenderType")
    @XmlEnum
    public enum GenderType {
        @XmlEnumValue("Female")
        FEMALE,
        @XmlEnumValue("Male")
        MALE;
    }

    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    @XmlType(name = "TitleType")
    @XmlEnum
    public enum TitleType {
        @XmlEnumValue("Mr")
        MISTER("Mr."),
        @XmlEnumValue("Mrs")
        MISTRESS("Mrs."),
        @XmlEnumValue("Ms")
        MS("Ms."),
        @XmlEnumValue("Miss")
        MISS("Miss"),
        @XmlEnumValue("Prof")
        PROFESSOR("Prof."),
        @XmlEnumValue("Dr")
        DOCTOR("Dr.");

        /**  */
        private final String __abbreviation;

        /**
         * Instance variable constructor. Initialise <code>this</code> instance with the
         * specified arguments. <i>For state specifications see the see also section</i>.
         * 
         * @param abbreviation
         */
        private TitleType(final String abbreviation) {
            __abbreviation = abbreviation;
        }

        /**
         * Obvious.
         * 
         * @return The value of <code>this</code> instance's {@linkplain #__abbreviation
         *         abbreviation}.
         */
        public String abbreviation() {
            return __abbreviation;
        }
    }
}
