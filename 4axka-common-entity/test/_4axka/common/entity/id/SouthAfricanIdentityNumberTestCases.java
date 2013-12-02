// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of SouthAfricanIdentityNumberTestCases.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity.id;


import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import _4axka.common.entity.Person.GenderType;


public class SouthAfricanIdentityNumberTestCases {
    private static final Map<String, SouthAfricanIdentityNumberTestVector> __vectors = new HashMap<>();
    private static final Map<String, SouthAfricanIdentityNumber> __ids = new HashMap<>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {
        final SouthAfricanIdentityNumberTestVector[] vectors_ =
                SouthAfricanIdentityNumberTestVector.values();
        for (final SouthAfricanIdentityNumberTestVector vector_ : vectors_) {
            __vectors.put(vector_.number(), vector_);
            __ids.put(vector_.number(), new SouthAfricanIdentityNumber(vector_.number()));
        }
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public final void testGetNumber() {
        for (String key_ : __ids.keySet()) {
            final String vectorNumber_ = __vectors.get(key_).number().replaceAll(" ", "");
            final String idNumber_ = __ids.get(key_).getNumber().replaceAll(" ", "");
            assertTrue(vectorNumber_.equals(idNumber_));
        }
    }

    @Test
    public final void testGetDateOfBirth() {
        for (String key_ : __ids.keySet()) {
            final Date vectorDateOfBirth_ = __vectors.get(key_).dateOfBirth();
            final Date idDateOfBirth_ = __ids.get(key_).getDateOfBirth();
            assertTrue(vectorDateOfBirth_.equals(idDateOfBirth_));
        }
    }

    @Test
    public final void testGetGender() {
        for (String key_ : __ids.keySet()) {
            final GenderType vectorGender_ = __vectors.get(key_).gender();
            final GenderType idGender_ = __ids.get(key_).getGender();
            assertTrue(vectorGender_.equals(idGender_));
        }
    }

    @Test
    public final void testWasBornInSouthAfrica() {
        for (String key_ : __ids.keySet()) {
            final Boolean vectorWasBornInSouthAfrica_ = __vectors.get(key_).wasBornInSouthAfrica();
            final Boolean idWasBornInSouthAfrica_ = __ids.get(key_).wasBornInSouthAfrica();
            assertTrue(vectorWasBornInSouthAfrica_ == idWasBornInSouthAfrica_);
        }
    }

    @Test
    public final void testIsValid() {
        for (String key_ : __ids.keySet()) {
            final Boolean vectorIsValid_ = __vectors.get(key_).isValid();
            final Boolean idIsValid_ = __ids.get(key_).isValid();
            assertTrue(vectorIsValid_ == idIsValid_);
        }
    }

    @Test
    public void testCalculateCheckDigit() {
        for (String key_ : __ids.keySet()) {
            final int vectorCheckDigit_ = __vectors.get(key_).checkDigit();
            final int checkDigit_ = __ids.get(key_).calculateCheckDigit(
                    __ids.get(key_).getNumber());
            final Boolean checkDigitsMatch_ = __ids.get(key_).isValid();
            assertTrue((vectorCheckDigit_ == checkDigit_) == checkDigitsMatch_);
        }
    }

    private static enum SouthAfricanIdentityNumberTestVector {
        ID_6803015017089("680302 5017 0 8 9", "1968-03-02", GenderType.MALE, true, true),
        ID_6902040136088("690204 0136 0 8 8", "1969-02-04", GenderType.FEMALE, true, true),
        ID_7611020032089("761102 0032 0 8 9", "1976-11-02", GenderType.FEMALE, true, true),
        ID_7001014001129("700101 4001 1 2 9", "1970-01-01", GenderType.FEMALE, false, false);

        private final String __number;
        private Date __dob;
        private final GenderType __gender;
        private final Boolean __wasBornInSA;
        private final Boolean __isValid;

        /**
         * @param number
         *          South African identity number.
         * @param dob
         *          The date of birth test vector value.
         * @param gender
         *          Gender test vector value.
         * @param wasBornInSA
         *          Whether the {@linkplain SouthAfricanIdentityNumber id number}
         *          is that of someone born in South Africa.
         * @param isValid
         *          The validity of the test vector.
         */
        private SouthAfricanIdentityNumberTestVector(
                final String number,
                final String dob,
                final GenderType gender,
                final Boolean wasBornInSA,
                final Boolean isValid) {
            __number = number;
            try {
                __dob = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            } catch (final ParseException e_) {
                String name_ = SouthAfricanIdentityNumberTestVector.class.getName();
                Logger logger_ = Logger.getLogger(name_);
                if (logger_.isLoggable(Level.FINER)) {
                    logger_.exiting(name_, "<init>()");
                }
            }
            __gender = gender;
            __wasBornInSA = wasBornInSA;
            __isValid = isValid;
        }

        String number() {
            return __number;
        }

        Date dateOfBirth() {
            return __dob;
        }

        GenderType gender() {
            return __gender;
        }

        Boolean wasBornInSouthAfrica() {
            return __wasBornInSA;
        }

        Boolean isValid() {
            return __isValid;
        }

        Integer checkDigit() {
            char checkDigit_ = __number.charAt(__number.length() - 1);
            return Integer.parseInt(Character.toString(checkDigit_));
        }
    }
}
