// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Factory.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


import _4axka.common.entity.Address.AddressType;
import _4axka.common.entity.EmailAddress.EmailAddressType;
import _4axka.common.entity.TelephoneNumber.TelephoneNumberType;
import _4axka.util.functor.Builder;


public class Factories {

    private Factories() {}

    public static final AddressFactory addressFactory() {
        return new AddressFactory();
    }

    public static final EmailAddressFactory emailAddressFactory() {
        return new EmailAddressFactory();
    }

    public static final TelephoneNumberFactory telephoneNumberFactory() {
        return new TelephoneNumberFactory();
    }

    public static final class AddressFactory implements Builder<Address> {
        private final Address __product = new Address();

        private AddressFactory() {
            super();
        }

        public final AddressFactory setCity(final String city) {
            __product.setCity(city);
            return this;
        }

        public final AddressFactory setCode(final String code) {
            __product.setCode(code);
            return this;
        }

        public final AddressFactory setCountry(final String country) {
            __product.setCountry(country);
            return this;
        }

        public final AddressFactory setRegion(final String region) {
            __product.setRegion(region);
            return this;
        }

        public final AddressFactory setSuburb(final String suburb) {
            __product.setSuburb(suburb);
            return this;
        }

        public final AddressFactory setType(final AddressType type) {
            __product.setType(type);
            return this;
        }

        @Override
        public final Address build() {
            return __product;
        }
    }

    public static final class EmailAddressFactory implements Builder<EmailAddress> {
        private final EmailAddress __product = new EmailAddress();

        private EmailAddressFactory() {
            super();
        }

        public EmailAddressFactory setAddress(final String address) {
            __product.setAddress(address);
            return this;
        }

        public EmailAddressFactory setType(final EmailAddressType type) {
            __product.setType(type);
            return this;
        }

        @Override
        public final EmailAddress build() {
            return __product;
        }
    }

    public static final class TelephoneNumberFactory implements Builder<TelephoneNumber> {
        private final TelephoneNumber __product = new TelephoneNumber();

        private TelephoneNumberFactory() {
            super();
        }

        public TelephoneNumberFactory setAreaCode(final String code) {
            __product.setAreaCode(code);
            return this;
        }

        public TelephoneNumberFactory setCountryCode(final String code) {
            __product.setCountryCode(code);
            return this;
        }

        public TelephoneNumberFactory setExtension(final String extension) {
            __product.setExtension(extension);
            return this;
        }

        public TelephoneNumberFactory setNumber(final String number) {
            __product.setNumber(number);
            return this;
        }

        public TelephoneNumberFactory setType(final TelephoneNumberType type) {
            __product.setType(type);
            return this;
        }

        @Override
        public TelephoneNumber build() {
            return null;
        }
    }
}
