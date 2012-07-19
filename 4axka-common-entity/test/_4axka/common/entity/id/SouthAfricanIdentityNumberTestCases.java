package _4axka.common.entity.id;


import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    private static enum SouthAfricanIdentityNumberTestVector {
        ID_6803015017089("680302 5017 0 8 9", "1968-03-02", GenderType.MALE, true, true),
        ID_6902040136088("690204 0136 0 8 8", "1969-02-04", GenderType.FEMALE, true, true),
        ID_7611020032089("761102 0032 0 8 9", "1976-11-02", GenderType.FEMALE, true, true),
        ID_7001014001129("700101 4001 1 2 9", "1970-01-01", GenderType.FEMALE, false, false);

        private String __number;
        private Date __dob;
        private GenderType __gender;
        private Boolean __wasBornInSA;
        private Boolean __isValid;

        private SouthAfricanIdentityNumberTestVector(
                final String number,
                final String dob,
                final GenderType gender,
                final Boolean wasBornInSA,
                final Boolean isValid) {
            final SimpleDateFormat format_ = new SimpleDateFormat("yyyy-MM-dd");
            __number = number;
            try {
                __dob = format_.parse(dob);
            } catch (final ParseException e_) {
                // FIXME! Log, or thrown?
                e_.printStackTrace();
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
    }
}
