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


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 *
 */
public abstract class Person<ID extends Comparable<ID> & Serializable> extends Entity<ID> {
    /**
     * Determines if a de-serialised file is compatible with this class.
     * <p>
     * Maintainers <strong>MUST</strong> change this value if and only if the new version of
     * this class is not compatible with the previous version. It is not necessary to include
     * in first version of the class, but included here as a reminder of its importance.
     * 
     * @see <a href="http://bit.ly/aDUV5">Java Object Serialization Specification</a>.
     */
    private static final long serialVersionUID = -1623837639963962157L;
    private Set<String> __givenNames = new ConcurrentSkipListSet<>();
    private Set<String> __alsoKnownAs = new ConcurrentSkipListSet<>();
    private String __preferredGivenName;
    private String __nickName;
    private String __familyName;
    private Date __dateOfBirth;
    private GenderType __gender;
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
        __alsoKnownAs.add(name);
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
        __alsoKnownAs.add(name);
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

    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    public enum GenderType {
        FEMALE,
        MALE;
    }

    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    public enum TitleType {
        MISTER("Mr."),
        MISTRESS("Mrs."),
        MS("Ms."),
        MISS("Miss"),
        PROFESSOR("Prof."),
        DOCTOR("Dr.");

        private final String __abbreviation;

        private TitleType(final String abbreviation) {
            __abbreviation = abbreviation;
        }

        public String abbreviation() {
            return __abbreviation;
        }
    }
}
