// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of SouthAfricanIdentityNumber.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package tech.anaxka.common.entity.id;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import tech.anaxka.common.entity.Person.GenderType;

import static java.lang.Integer.parseInt;
import static java.util.logging.Logger.getLogger;
import static tech.anaxka.common.utility.lang.CompareTo.EQUAL;
import static tech.anaxka.common.utility.lang.CompareTo.compareToBuilder;
import static tech.anaxka.common.utility.lang.CompareTo.isComparable;
import static tech.anaxka.common.utility.lang.Equals.equalsBuilder;
import static tech.anaxka.common.utility.lang.Equals.isEquatable;
import static tech.anaxka.common.utility.lang.HashCode.hashCodeBuilder;
import static tech.anaxka.common.utility.lang.ToString.toStringBuilder;

/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 */
@XmlRootElement(name = "southAfricanIdentityNumber")
@XmlType(name = "SouthAfricanIdentityNumber")
@Embeddable
public class SouthAfricanIdentityNumber implements Serializable, Comparable<SouthAfricanIdentityNumber> {

    private static final String NAME = SouthAfricanIdentityNumber.class.getName();
    private static final Logger LOGGER = getLogger(NAME);

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
    private static final long serialVersionUID = -2445401405948658566L;

    @XmlElement(name = "number", required = true, nillable = false)
    @Basic
    @Column(name = "SOUTH_AFRICAN_ID_NUMBER", length = 31, nullable = false, unique = true)
    private String __number;

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * <p>
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public SouthAfricanIdentityNumber() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * <p>
     * @param number The {@linkplain SouthAfricanIdentityNumber identity number}.
     */
    public SouthAfricanIdentityNumber(final String number) {
        this();
        setNumber(number);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * <p>
     * @param number Uses number as template to initialise {@linkplain SouthAfricanIdentityNumber
     *            <code>this</code>}.
     */
    public SouthAfricanIdentityNumber(final SouthAfricanIdentityNumber number) {
        this(number.getNumber());
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__number identity number}.
     */
    public String getNumber() {
        return __number;
    }

    /**
     * Obvious.
     * <p>
     * @param number Value to assign to <code>this</code> {@linkplain #__number identiy number}.
     */
    final void setNumber(final String number) {
        final String number_ = format(number);
        __number = number_;
    }

    /**
     * Formats the {@linkplain SouthAfricanIdentityNumber identity number} for easy reading.
     * <p>
     * The format is as follows:
     * <b>YYMMDD GSSS C R Z</b> where,
     * <dl>
     * <dt><b>YYMMDD</b></dt>
     * <dd>is the date of birth, the first two digits being the year of birth, the next two the
     * month of birth and last two being the day of the month of birth,</dd>
     * <dt><b>G</b></dt>
     * <dd>is the gender where 0 - 4 indicates <i>female</i> and 5 -9 indicates <i>male</i>,</dd>
     * <dt><b>SSS</b></dt>
     * <dd>is a sequence number,</dd>
     * <dd><b>C</b></dd>
     * <dt>is the country of birth where 0 is South Africa and 1 is another country,</dt>
     * <dd><b>R</b></dd>
     * <dt>is reserved for future use and</dt>
     * <dd><b>Z</b></dd>
     * <dt>is the check digit</dt>.
     * </dl>
     * <p>
     * @param number The {@link SouthAfricanIdentityNumber number} to format.
     * <p>
     * @return The formatted number.
     * <p>
     * @throws IllegalArgumentException if the {@link SouthAfricanIdentityNumber#__number number}
     *                                  cannot be formatted.
     */
    private String format(final String number) throws IllegalArgumentException {
        if (number == null) {
            throw new IllegalArgumentException("Argument may not be null!");
        }

        final String number_ = number.replaceAll(" ", "");
        if (number_.length() != 13 || !number_.matches("[0-9]{13}")) {
            throw new IllegalArgumentException("Argument has invalid format!");
        }

        final StringBuilder builder_ = new StringBuilder();

        builder_.append(number_.substring(0, 6)).append(" ")
                .append(number_.substring(6, 10)).append(" ")
                .append(number_.substring(10, 11)).append(" ")
                .append(number_.substring(11, 12)).append(" ")
                .append(number_.substring(12, 13)).append(" ");

        final String result_ = builder_.toString();

        return result_;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__number date of birth}.
     */
    public Date getDateOfBirth() {
        final String SIGNATURE = "Date getDateOfBirth()";

        Date result_ = null;

        final SimpleDateFormat format_ = new SimpleDateFormat("yyMMdd");
        try {
            result_ = format_.parse(__number.substring(
                    Offsets.BIRTH_DATE_START.offset(),
                    Offsets.BIRTH_DATE_STOP.offset()));
        } catch (final ParseException e_) {
            LOGGER.logp(Level.SEVERE, NAME, SIGNATURE, "Unable to pase date.", e_);
        }

        return result_;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__number gender}.
     */
    public GenderType getGender() {
        GenderType result_ = null;

        final String genderCode_ = __number.substring(
                Offsets.GENDER_START.offset(),
                Offsets.GENDER_STOP.offset());
        if (genderCode_.matches("[0-4]")) {
            result_ = GenderType.FEMALE;
        } else if (genderCode_.matches("[5-9]")) {
            result_ = GenderType.MALE;
        }

        return result_;
    }

    /**
     * Obvious.
     * <p>
     * @return The value of <code>this</code> instance's {@linkplain #__number country of birth}.
     */
    public Boolean wasBornInSouthAfrica() {
        Boolean result_ = false;

        final String bornInSACode_ = __number.substring(
                Offsets.CITIZENSHIP_START.offset(),
                Offsets.CITIZENSHIP_STOP.offset());
        if (bornInSACode_.matches("[0]")) {
            result_ = true;
        }

        return result_;
    }

    /**
     * Applies the {@link SouthAfricanIdentityNumber} validation algorithm to <code>this</code>
     * instance.
     * <p>
     * Given an South African identity number
     * Y<sub>1</sub>Y<sub>2</sub>M<sub>1</sub>M<sub>2</sub>D<sub>1</sub>D<sub>2</sub>
     * GS<sub>1</sub>S<sub>2</sub>S<sub>3</sub> C R Z, the algorithm to calculate the check digit is
     * as follows:
     * <dl>
     * <dt>Remove the check digit</dt>
     * <dd>This yields
     * Y<sub>1</sub>Y<sub>2</sub>M<sub>1</sub>M<sub>2</sub>D<sub>1</sub>D<sub>2</sub>
     * GS<sub>1</sub>S<sub>2</sub>S<sub>3</sub> C R.</dd>
     * <dt>Sum all odd digits</dt>
     * <dd>S<sub>0</sub> = Y<sub>1</sub> + M<sub>1</sub> + D<sub>1</sub> + G + S<sub>2</sub> +
     * C.</dd>
     * <dt>Place even digits sequentially</dt>
     * <dd>N<sub>e</sub> = Y<sub>2</sub>M<sub>2</sub>D<sub>2</sub>S<sub>1</sub>S<sub>3</sub>R.</dd>
     * <dt>Multiply N<sub>e</sub> by two.</dt>
     * <dd>N<sub>e2</sub> = N<sub>e</sub> x 2.</dd>
     * <dt>Add the digits of N<sub>e2</sub> together</dt>
     * <dd>While N<sub>e2</sub> has another digit S<sub>1</sub> += next(N<sub>e2</sub>).</dd>
     * <dt>Add two sums together</dt>
     * <dd>S<sub>2</sub> = S<sub>0</sub> + S<sub>1</sub>.</dd>
     * <dt>Take the right most digit of S<sub>2</sub></dt>
     * <dd>X = getRightDigit(S<sub>2</sub>).</dd>
     * <dt>The checksum is 10 - X</dt>
     * <dd>Z = 10 - X.</dd>
     * </dl>
     * <p>
     * @return {@code true} if <code>this</code> instance of
     *         {@linkplain SouthAfricanIdentityNumber the South African identity number} object is
     *         valid.
     */
    public Boolean isValid() {
        return isValid(__number);
    }

    /**
     * Determines if a {@linkplain SouthAfricanIdentityNumber South African identity number} is
     * valid.
     * <p>
     * @param number The number to verify.
     * <p>
     * @return {@code true} if the {@link SouthAfricanIdentityNumber} is valid.
     * <p>
     * @see #isValid()
     */
    private Boolean isValid(final String number) {
        Boolean result_;

        // Check the validity of the date first.
        result_ = getDateOfBirth() != null;
        if (!result_) {
            return result_;
        }

        // 1. Remove redundant white space AND remove check digit - we will calculate it here!
        final String numberWithCheckDigit_ = number.replaceAll(" ", "");
        final int checkSum_ = calculateCheckDigit(number);

        // 9. The number obtained in 8.) must equal the id number check digit.
        final int offset_ = numberWithCheckDigit_.length();
        result_ = (checkSum_ == parseInt(
                numberWithCheckDigit_.substring(offset_ - 1, offset_)));

        return result_;
    }

    /**
     * Calculates the check digit of a {@link SouthAfricanIdentityNumber}.
     * <p>
     * @param idNumber The {@link SouthAfricanIdentityNumber} for which the check digit should be
     *                 calculated.
     * <p>
     * @return The check digit for the supplied identity number.
     * <p>
     * @see #isValid()
     */
    public int calculateCheckDigit(final String idNumber) {
        // 1. Remove redundant white space AND remove check digit - we will calculate it here!
        final String numberWithCheckDigit_ = idNumber.replaceAll(" ", "");
        final String numberWithoutCheckDigit_ = numberWithCheckDigit_.substring(0, 12);

        // 2. Sum all odd digits, except for the 13th (last) one.
        int oddDigitSum_ = 0;
        for (int i_ = 0; i_ < numberWithoutCheckDigit_.length(); i_ += 2) {
            final String digitAsString_ = numberWithoutCheckDigit_.substring(i_, i_ + 1);
            oddDigitSum_ += parseInt(digitAsString_);
        }

        // 3. Build a number by placing even digits sequentially.
        final StringBuilder evenCatBuilder_ = new StringBuilder();
        for (int i_ = 1; i_ < numberWithoutCheckDigit_.length(); i_ += 2) {
            final String digitAsString_ = numberWithoutCheckDigit_.substring(i_, i_ + 1);
            evenCatBuilder_.append(digitAsString_);
        }
        final String evenCatAsString_ = evenCatBuilder_.toString();

        // 4. Multiply number in 3.) by two.
        int doubleEvenCat_ = parseInt(evenCatAsString_) * 2;

        // 5. Add numbers of number obtained in 4.) together.
        final String doubleEvenCatAsString_ = Integer.toString(doubleEvenCat_);
        int doubleEvenCatSum_ = 0;
        for (final Character digitAsCharacter_ : doubleEvenCatAsString_.toCharArray()) {
            doubleEvenCatSum_ += parseInt(digitAsCharacter_.toString());
        }

        // 6. Add numbers from 5.) and 2.) together.
        final int checkSumBase_ = oddDigitSum_ + doubleEvenCatSum_;
        final String checkSumBaseAsString_ = Integer.toString(checkSumBase_);

        // 7. Get the right most digit in the number from the number obtained in 6.).
        final int checkSumBaseRight_ = parseInt(
                checkSumBaseAsString_.substring(checkSumBaseAsString_.length() - 1));

        // 8. Subtract the number obtained in 7.) from 10.
        final int checkSum_ = 10 - checkSumBaseRight_;
        return checkSum_;
    }

    /**
     * @{inheritDoc}
     * @param that
     */
    @Override
    public boolean equals(final Object that) {
        boolean result_ = false;

        if (!isEquatable(this, that)) {
            final SouthAfricanIdentityNumber that_ = SouthAfricanIdentityNumber.class.cast(that);

            result_ = equalsBuilder()
                    .append(getNumber(), that_.getNumber())
                    .build();
        }

        return result_;
    }

    /**
     * @{inheritDoc}
     * @param that
     */
    @Override
    public int compareTo(final SouthAfricanIdentityNumber that) {
        if (isComparable(that)) {
            return compareToBuilder()
                    .append(getNumber(), that.getNumber())
                    .build();
        } else {
            return EQUAL;
        }
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public int hashCode() {
        return hashCodeBuilder()
                .append(getNumber())
                .build();
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public String toString() {
        return toStringBuilder(this)
                .append("South African Identity Number", getNumber())
                .append("super", super.toString())
                .build();
    }

    /* For internal use only. */
    private static enum Offsets {

        BIRTH_DATE_START(0),
        BIRTH_DATE_STOP(6),
        GENDER_START(7),
        GENDER_STOP(8),
        SEQUENCE_START(8),
        SEQUENCE_STOP(11),
        CITIZENSHIP_START(12),
        CITIZENSHIP_STOP(13),
        ETHNICITY_START(14),
        ETHNICITY_STOP(15),
        CHECKDIGIT_START(16),
        CHECKDIGIT_STOP(17);

        private final int __offset;

        private Offsets(final int offset) {
            __offset = offset;
        }

        Integer offset() {
            return __offset;
        }
    }
}
