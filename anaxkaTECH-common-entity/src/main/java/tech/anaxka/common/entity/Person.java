package tech.anaxka.common.entity;


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
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 */
@XmlRootElement(name = "person")
@XmlType(name = "Person")
@Entity(name = "Person")
@Table(
        name = "PERSONS",
        indexes = {
            @Index(columnList = "FAMILY_NAME", name = "PERSONS_FAMILY_NAME_INDEX"),
            @Index(columnList = "DATE_OF_BIRTH", name = "PERSONS_DATE_OF_BIRTH_INDEX"),
            @Index(columnList = "GENDER", name = "PERSONS_GENDER_INDEX")
        })
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person
        extends LegalEntity {

    @XmlElementWrapper(name = "givenNames", required = true, nillable = false)
    @XmlElement(name = "name")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "PERSON_GIVEN_NAMES",
            joinColumns = @JoinColumn(name = "PERSON_FK", referencedColumnName = "ID"))
    @Column(name = "GIVEN_NAME", length = 63, nullable = false)
    private final Set<String> __givenNames = new ConcurrentSkipListSet<>();

    @XmlElementWrapper(name = "aliases")
    @XmlElement(name = "alias")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "PERSON_ALIASES",
            joinColumns = @JoinColumn(name = "PERSON_FK", referencedColumnName = "ID"))
    @Column(name = "AKA", length = 63, nullable = false)
    private final Set<String> __alsoKnownAs = new ConcurrentSkipListSet<>();

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

    @XmlElement(name = "deceasedOn")
    @Temporal(TemporalType.DATE)
    @Column(name = "DECEASED_ON")
    private Date __deceasedOn;

    @XmlElement(name = "gender")
    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 7)
    private GenderType __gender;

    @XmlElementWrapper(name = "titles")
    @XmlElement(name = "title")
    // TODO: this should be a unidirectional many to one form the TitleType side to act like a
    // lookup. A Person should have only ONE title.
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "PERSON_TITLES",
            joinColumns = @JoinColumn(name = "PERSON_FK", referencedColumnName = "ID"))
    @Column(name = "TITLE", length = 15)
    private final Set<TitleType> __titles = new ConcurrentSkipListSet<>();

    /**
     * Default constructor.
     * <p/>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p/>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public Person() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * <p/>
     * @param emailAddresses    see {@link #getEmailAddresses() email addresses}.
     * @param numbers           see {@link #getTelephoneNumbers() telephone numbers}.
     * @param addresses         see {@link #getAddresses() addresses}.
     * @param givenNames        see {@link #getGivenNames() given names}.
     * @param aka               see {@link #getAlsoKnownAs() aliases}.
     * @param preferedGivenName see {@link #getPreferredGivenName() preferred given name}.
     * @param nickName          see {@link #getNickName() nick name}.
     * @param familyName        see {@link #getFamilyName() family name}.
     * @param dateOfBirth       see {@link #getDateOfBirth() birth date}.
     * @param deceasedOn        see {@link #getDeceasedOn() died on}.
     * @param gender            see {@link #getGender() gender}.
     * @param titles            see {@link #getTitles() titles}.
     */
    public Person(
            // LEGAL ENTITY PARAMETERS
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
            final Date deceasedOn,
            final GenderType gender,
            final Iterable<TitleType> titles) {
        super(emailAddresses, numbers, addresses);
        addGivenNames(givenNames);
        addAliases(aka);
        setPreferredGivenName(preferedGivenName);
        setNickName(nickName);
        setFamilyName(familyName);
        setDateOfBirth(dateOfBirth);
        setDeceasedOn(deceasedOn);
        setGender(gender);
        addTitles(titles);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * <p/>
     * @param template Uses template as template to initialise {@linkplain Person
     *                 <code>this</code>}.
     */
    public Person(final Person template) {
        super(template);
        addGivenNames(template.getGivenNames());
        addAliases(template.getAlsoKnownAs());
        setPreferredGivenName(template.getPreferredGivenName());
        setNickName(template.getNickName());
        setFamilyName(template.getFamilyName());
        setDateOfBirth(template.getDateOfBirth());
        setDeceasedOn(template.getDeceasedOn());
        setGender(template.getGender());
        addTitles(template.getTitles());
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__givenNames given names}.
     */
    public final Iterable<String> getGivenNames() {
        return __givenNames;
    }

    /**
     * Obvious.
     * <p/>
     * @param names {@linkplain Iterable Collection} of {@linkplain #__givenNames given names} to
     *              add to <code>this</code> instance.
     */
    public final void addGivenNames(final Iterable<String> names) {
        if (null != names) {
            for (final String name_ : names) {
                addGivenName(name_);
            }
        }
    }

    /**
     * Obvious.
     * <p/>
     * @param name Instance of given name to add to <code>this</code> {@linkplain #__givenNames
     *            given names} instance.
     */
    public final void addGivenName(final String name) {
        __givenNames.add(name);
    }

    /**
     * Obvious.
     * <p/>
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
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__alsoKnownAs aliases}.
     */
    public final Iterable<String> getAlsoKnownAs() {
        return __alsoKnownAs;
    }

    /**
     * Obvious.
     * <p/>
     * @param aka {@linkplain Iterable Collection} of {@linkplain # aliases} to add to
     *            <code>this</code> instance.
     */
    public final void addAliases(final Iterable<String> aka) {
        if (null != aka) {
            for (final String alias_ : aka) {
                addAlias(alias_);
            }
        }
    }

    /**
     * Obvious.
     * <p/>
     * @param alias Instance of an alias to add to <code>this</code> {@linkplain #__alsoKnownAs
     *            aliases} instance.
     */
    public final void addAlias(final String alias) {
        __alsoKnownAs.add(alias);
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__preferredGivenName
     *         preferred given name}.
     */
    public final String getPreferredGivenName() {
        return __preferredGivenName;
    }

    /**
     * Obvious.
     * <p/>
     * @param name Value to assign to <code>this</code> {@linkplain #__preferredGivenName
     *            preferred given name}.
     */
    final void setPreferredGivenName(final String name) {
        __preferredGivenName = name;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__nickName nickname}.
     */
    public final String getNickName() {
        return __nickName;
    }

    /**
     * Obvious.
     * <p/>
     * @param name Value to assign to <code>this</code> {@linkplain #__nickName nick name}.
     */
    final void setNickName(final String name) {
        __nickName = name;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__familyName family name}.
     */
    public final String getFamilyName() {
        return __familyName;
    }

    /**
     * Obvious.
     * <p/>
     * @param name Value to assign to <code>this</code> {@linkplain #__familyName family name}.
     */
    final void setFamilyName(final String name) {
        __familyName = name;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__deceasedOn date of death}.
     */
    public final Date getDeceasedOn() {
        return new Date(__deceasedOn.getTime());
    }

    /**
     * Obvious.
     * <p/>
     * @param date Value to assign to <code>this</code> {@linkplain #__deceasedOn date of death}.
     */
    final void setDeceasedOn(final Date date) {
        __deceasedOn = date;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__dateOfBirth date of birth}.
     */
    public final Date getDateOfBirth() {
        return new Date(__dateOfBirth.getTime());
    }

    /**
     * Obvious.
     * <p/>
     * @param date Value to assign to <code>this</code> {@linkplain #__dateOfBirth date of birth}.
     */
    final void setDateOfBirth(final Date date) {
        __dateOfBirth = date;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__gender gender}.
     */
    public final GenderType getGender() {
        return __gender;
    }

    /**
     * Obvious.
     * <p/>
     * @param gender Value to assign to <code>this</code> {@linkplain #__gender gender}.
     */
    final void setGender(final GenderType gender) {
        __gender = gender;
    }

    /**
     * Obvious.
     * <p/>
     * @return The value of <code>this</code> instance's {@linkplain #__titles titiles}.
     */
    public final Iterable<TitleType> getTitles() {
        return __titles;
    }

    /**
     * Obvious.
     * <p/>
     * @param titles Value to assign to <code>this</code> {@linkplain #__titles titles}.
     */
    public final void addTitles(final Iterable<TitleType> titles) {
        if (null != titles) {
            for (final TitleType title_ : titles) {
                addTitle(title_);
            }
        }
    }

    /**
     * Obvious.
     * <p/>
     * @param title Instance of title to add to <code>this</code> {@linkplain #__titles titles}
     *              instance.
     */
    public final void addTitle(final TitleType title) {
        __titles.add(title);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("Id", getId())
                .append("Version", getVersion())
                .append("Given Names", __givenNames)
                .append("Initials", getInitials())
                .append("Family Name", getFamilyName())
                .append("Also Known As", __alsoKnownAs)
                .append("Preferred Given Name", getPreferredGivenName())
                .append("Date of Birth", getDateOfBirth())
                .append("Deceased On", getDeceasedOn())
                .append("Gender", getGender())
                .append("Titles", __titles)
                .append("super", super.toString())
                .build();
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
        MALE,
        @XmlEnumValue("Unspecified")
        UNSPECIFIED;
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
        DOCTOR("Dr."),
        @XmlEnumValue("Unspecified")
        UNSPECIFIED("");

        /**
         *
         */
        private final String __abbreviation;

        /**
         * Instance variable constructor. Initialise <code>this</code> instance with the specified
         * arguments. <i>For state specifications see the see also section</i>.
         * <p/>
         * @param abbreviation
         */
        private TitleType(final String abbreviation) {
            __abbreviation = abbreviation;
        }

        /**
         * Obvious.
         * <p/>
         * @return The value of <code>this</code> instance's {@linkplain #__abbreviation
         *         abbreviation}.
         */
        public String abbreviation() {
            return __abbreviation;
        }
    }
}
