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
package _4axka.common.entity.id;


import static _4axka.util.lang.ToString.wrap;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import _4axka.common.entity.Person.GenderType;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 */
@XmlRootElement(name = "southAfricanIdentityNumber")
@XmlType(name = "SouthAfricanIdentityNumber")
@Embeddable
public final class SouthAfricanIdentityNumber implements Serializable, Comparable<SouthAfricanIdentityNumber> {
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
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public SouthAfricanIdentityNumber() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param number
     */
    public SouthAfricanIdentityNumber(final String number) {
        this();
        setNumber(number);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param number
     *            Uses number as template to initialise {@linkplain SouthAfricanIdentityNumber
     *            <code>this</code>}.
     */
    public SouthAfricanIdentityNumber(final SouthAfricanIdentityNumber number) {
        this(number.getNumber());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__number identity number}.
     */
    public String getNumber() {
        return __number;
    }

    /**
     * Obvious.
     * 
     * @param number
     *            Value to assign to <code>this</code> {@linkplain #__number identiy number}.
     */
    void setNumber(final String number) {
        final String number_ = format(number);
        __number = number_;
    }

    /**
     * TODO: Document!
     *
     * @param number
     * @return
     * @throws IllegalArgumentException
     */
    private String format(final String number) throws IllegalArgumentException {
        // format the number to look as follows:
        // YYMMDD GSSS C R Z where
        // YYMMDD is the date of birth
        // G is the gender; 0 - 4 is female, 5 -9 is male
        // SSS is a sequence number
        // C country of birth; 0 is South Africa, 1 is another country
        // R old race classification number, usually 8 or 9
        // Z check digit
        // OFFSETS:
        //                  17
        //                Z16|
        //                  ||
        //                15||
        //              R14|||
        //                ||||
        //              13||||
        //            C12|||||
        //              ||||||
        //            11||||||
        //       GS7   |||||||
        //         |   |||||||
        //        6|   |||||||
        // D0     ||   |||||||
        //  v     vv   vvvvvvv
        //  YYMMDD GSSS C R Z
        if (number == null) {
            throw new IllegalArgumentException("Argument may not be null!");
        }

        final String number_ = number.replaceAll(" ", "");
        if (number_.length() != 13 || !number_.matches("[0-9]{13}")) {
            throw new IllegalArgumentException("Argument has invalid format!");
        }

        final StringBuilder builder_ = new StringBuilder();

        builder_.append(number_.substring(0, 6)).append(" ");
        builder_.append(number_.substring(6, 10)).append(" ");
        builder_.append(number_.substring(10, 11)).append(" ");
        builder_.append(number_.substring(11, 12)).append(" ");
        builder_.append(number_.substring(12,  13)).append(" ");

        final String result_ = builder_.toString();

        return result_;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__number date of birth}.
     */
    public Date getDateOfBirth() {
        Date result_ = null;

        try {
            final SimpleDateFormat format_ = new SimpleDateFormat("yyMMdd");
            result_ = format_.parse(__number.substring(
                    Offsets.DATE_START.offset(),
                    Offsets.DATE_STOP.offset()));
        } catch (final ParseException e_) {
            // FIXME! Log, or throw?
            e_.printStackTrace();
        }

        return result_;
    }

    /**
     * Obvious.
     * 
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
     * 
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
     * Obvious.
     * 
     * @return The <code>this</code> instance's {@linkplain #__number validity}.
     */
    public Boolean isValid() {
        return isValid(__number);
    }

    /**
     * TODO: Document!
     *
     * @param number
     * @return
     */
    private Boolean isValid(final String number) {
        // 1. Remove redundant white space AND remove check digit - we will calculate it here!
        final String numberWithCheckDigit_ = number.replaceAll(" ", "");
        final String numberWithoutCheckDigit_ = numberWithCheckDigit_.substring(0, 12);

        // 2. Sum all odd digits, except for the 13th (last) one.
        int oddDigitSum_ = 0;
        for (int i_ = 0; i_ < numberWithoutCheckDigit_.length(); i_ += 2) {
            final String digitAsString_ = numberWithoutCheckDigit_.substring(i_, i_ + 1);
            oddDigitSum_ += Integer.parseInt(digitAsString_);
        }

        // 3. Build a number by placing even digits sequentially.
        final StringBuilder evenCatBuilder_ = new StringBuilder();
        for (int i_ = 1; i_ < numberWithoutCheckDigit_.length(); i_ += 2) {
            final String digitAsString_ = numberWithoutCheckDigit_.substring(i_, i_ + 1);
            evenCatBuilder_.append(digitAsString_);
        }
        final String evenCatAsString_ = evenCatBuilder_.toString();

        // 4. Multiply number in 3.) by two.
        int doubleEvenCat_ = Integer.parseInt(evenCatAsString_) * 2;

        // 5. Add numbers of number obtained in 4.) together.
        final String doubleEvenCatAsString_ = Integer.toString(doubleEvenCat_);
        int doubleEvenCatSum_ = 0;
        for (final Character digitAsCharacter_ : doubleEvenCatAsString_.toCharArray()) {
            doubleEvenCatSum_ += Integer.parseInt(digitAsCharacter_.toString());
        }

        // 6. Add numbers from 5.) and 2.) together.
        final int checkSumBase_ = oddDigitSum_ + doubleEvenCatSum_;
        final String checkSumBaseAsString_ = Integer.toString(checkSumBase_);

        // 7. Get the right most digit in the number from the number obtained in 6.).
        final int checkSumBaseRight_ = Integer.parseInt(
                checkSumBaseAsString_.substring(checkSumBaseAsString_.length() - 1));

        // 8. Subtract 10 from the number obtained in 7.).
        final int checkSum_ = 10 - checkSumBaseRight_;

        // 9. The number obtained in 8.) must equal the id number check digit.
        final int offset_ = numberWithCheckDigit_.length();
        return checkSum_ == Integer.parseInt(numberWithCheckDigit_.substring(
                offset_ - 1,
                offset_));
    }

    @Override
    public boolean equals(final Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (!(that.getClass().isAssignableFrom(SouthAfricanIdentityNumber.class))) {
            return false;
        }
        final SouthAfricanIdentityNumber that_ = SouthAfricanIdentityNumber.class.cast(that);

        if (getNumber() == null) {
            if (that_.getNumber() != null) {
                return false;
            }
        } else if (!getNumber().equals(that_.getNumber())) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(final SouthAfricanIdentityNumber that) {
        int result_ = 0;

        if (this == that) {
            return result_;
        }
        if (that == null) {
            return 1;
        }

        if (null == getNumber()) {
            if (null != that.getNumber()) {
                result_ = -1;
            }
        } else if (null != that.getNumber()) {
            result_ = getNumber().compareTo(that.getNumber());
        }
        if (result_ != 0) {
            return result_;
        }

        return result_;
    }

    @Override
    public int hashCode() {
        int result_ = 1;
        final int PRIME = 31;

        result_ = PRIME * result_ + ((getNumber() == null) ? 0 : getNumber().hashCode());

        return result_;
    }

    @Override
    public String toString() {
        final StringBuilder builder_ = new StringBuilder();
        
        final String loadedFrom_ = getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString();
        
        builder_.append("SouthAfricanIdentityNumber@").append(System.identityHashCode(this))
        .append("=[")
        .append("South African Identity Number=").append(wrap(getNumber())).append(", ")
        .append("super=[").append(super.toString()).append("]").append(", ")
        .append("Bytecode Location=").append(loadedFrom_)
        .append("]");
        
        return builder_.toString();
    }

    /* For internal use only. */
    private static enum Offsets {
        DATE_START(0),
        DATE_STOP(6),
        GENDER_START(7),
        GENDER_STOP(8),
        SEQUENCE_START(8),
        SEQUENCE_STOP(11),
        CITIZENSHIP_START(12),
        CITIZENSHIP_STOP(13),
        BUFFER_START(14),
        BUFFER_STOP(15),
        CHECKDIGIT_START(16),
        CHECKDIGIT_STOP(17);
        private int __offset;

        private Offsets(final int offset) {
            __offset = offset;
        }

        Integer offset() {
            return __offset;
        }
    }
}
