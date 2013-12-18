// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Builders.java is strictly CONFIDENTIAL.
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
import _4axka.common.entity.Person.GenderType;
import _4axka.common.entity.Person.TitleType;
import _4axka.common.entity.TelephoneNumber.TelephoneNumberType;
import _4axka.util.functor.Builder;
import java.io.Serializable;
import java.util.Date;

public class Builders {

    private Builders() {
    }

    public static final AddressBuilder addressBuilder() {
        return new AddressBuilder();
    }

    public static final EmailAddressBuilder emailAddressBuilder() {
        return new EmailAddressBuilder();
    }

    public static final TelephoneNumberBuilder telephoneNumberBuilder() {
        return new TelephoneNumberBuilder();
    }

    public static final class AddressBuilder implements Builder<Address> {

        private final Address __ = new Address();

        private AddressBuilder() {
            super();
        }

        public final AddressBuilder setType(final AddressType type) {
            __.setType(type);
            return this;
        }

        public final AddressBuilder setLocation(final String location) {
            __.setLocation(location);
            return this;
        }

        public final AddressBuilder setSuburb(final String suburb) {
            __.setSuburb(suburb);
            return this;
        }

        public final AddressBuilder setCity(final String city) {
            __.setCity(city);
            return this;
        }

        public final AddressBuilder setRegion(final String region) {
            __.setRegion(region);
            return this;
        }

        public final AddressBuilder setCountry(final String country) {
            __.setCountry(country);
            return this;
        }

        public final AddressBuilder setCode(final String code) {
            __.setCode(code);
            return this;
        }

        @Override
        public final Address build() {
            return __;
        }
    }

    public static final class EmailAddressBuilder implements Builder<EmailAddress> {

        private final EmailAddress __ = new EmailAddress();

        private EmailAddressBuilder() {
            super();
        }

        public EmailAddressBuilder setAddress(final String address) {
            __.setAddress(address);
            return this;
        }

        public EmailAddressBuilder setType(final EmailAddressType type) {
            __.setType(type);
            return this;
        }

        @Override
        public final EmailAddress build() {
            return __;
        }
    }

    public static final class TelephoneNumberBuilder implements Builder<TelephoneNumber> {

        private final TelephoneNumber __ = new TelephoneNumber();

        private TelephoneNumberBuilder() {
            super();
        }

        public TelephoneNumberBuilder setAreaCode(final String code) {
            __.setAreaCode(code);
            return this;
        }

        public TelephoneNumberBuilder setCountryCode(final String code) {
            __.setCountryCode(code);
            return this;
        }

        public TelephoneNumberBuilder setExtension(final String extension) {
            __.setExtension(extension);
            return this;
        }

        public TelephoneNumberBuilder setNumber(final String number) {
            __.setNumber(number);
            return this;
        }

        public TelephoneNumberBuilder setType(final TelephoneNumberType type) {
            __.setType(type);
            return this;
        }

        @Override
        public TelephoneNumber build() {
            return __;
        }
    }

    public static abstract class PersonBuilder<ID extends Serializable & Comparable<ID>> implements
            Builder<Person<ID>> {

        protected Person<ID> __;

        protected PersonBuilder() {
        }

        public PersonBuilder<ID> setLegalIdentifier(ID id) {
            __.setLegalIdentifier(id);
            return this;
        }

        public PersonBuilder addEmailAddress(final EmailAddress address) {
            __.addEmailAddress(address);
            return this;
        }

        public PersonBuilder addTelephoneNumber(final TelephoneNumber number) {
            __.addTelephoneNumber(number);
            return this;
        }

        public PersonBuilder addAddress(final Address address) {
            __.addAddress(address);
            return this;
        }

        public PersonBuilder addGivenName(final String name) {
            __.addGivenName(name);
            return this;
        }

        public PersonBuilder addAlias(final String alias) {
            __.addAlias(alias);
            return this;
        }

        public PersonBuilder setPreferredGivenName(final String name) {
            __.setPreferredGivenName(name);
            return this;
        }

        public PersonBuilder setNickname(final String name) {
            __.setNickName(name);
            return this;
        }

        public PersonBuilder setFamilyName(final String name) {
            __.setFamilyName(name);
            return this;
        }

        public PersonBuilder setDateOfBirth(final Date date) {
            __.setDateOfBirth(date);
            return this;
        }

        public PersonBuilder setDeceasedDate(final Date date) {
            __.setDeceasedOn(date);
            return this;
        }

        public PersonBuilder setGender(final GenderType gender) {
            __.setGender(gender);
            return this;
        }

        public PersonBuilder addTitle(final TitleType title) {
            __.addTitle(title);
            return this;
        }

        @Override
        public Person<ID> build() {
            return __;
        }
    }
}
