package tech.anaxka.common.entity;

import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import tech.anaxka.common.entity.id.SouthAfricanIdentityDocument;
import tech.anaxka.common.utility.data.Identifiable;
import tech.anaxka.common.utility.functor.Builder;

@Entity(name = "SouthAfricanCitizen")
@Table(name = "SOUTH_AFTICAN_CITIZENS")
public class SouthAfricanCitizen extends Person implements Identifiable<SouthAfricanIdentityDocument> {
    @XmlElement(name = "identifier", required = true, nillable = false)
    @Embedded
    private SouthAfricanIdentityDocument __identifier;

    protected SouthAfricanCitizen() {
    }

    public SouthAfricanCitizen(final SouthAfricanIdentityDocument identifier, final Person template) {
        super(template);
        __identifier = identifier;
    }

    public SouthAfricanCitizen(
            final SouthAfricanIdentityDocument identifier,
            final Iterable<EmailAddress> emailAddresses,
            final Iterable<TelephoneNumber> numbers,
            final Iterable<Address> addresses,
            final Iterable<String> givenNames,
            final Iterable<String> aka,
            final String preferedGivenName,
            final String nickName,
            final String familyName,
            final Date dateOfBirth,
            final Date deceasedOn,
            final GenderType gender,
            final Iterable<TitleType> titles) {
        super(
                emailAddresses,
                numbers,
                addresses,
                givenNames,
                aka,
                preferedGivenName,
                nickName,
                familyName,
                dateOfBirth,
                deceasedOn,
                gender,
                titles);
        __identifier = identifier;
    }

    public SouthAfricanCitizen(final SouthAfricanIdentityDocument id) {
        __identifier = id;
    }
    
    public static final SouthAfricanCitizenBuilder southAfricanCitizenBuilder() {
        return new SouthAfricanCitizenBuilder();
    }

    @Override
    public SouthAfricanIdentityDocument getIdentifier() {
        return __identifier;
    }
    
    void setIdentifier(final SouthAfricanIdentityDocument id) {
        __identifier = id;
    }

    public static class SouthAfricanCitizenBuilder implements Builder<SouthAfricanCitizen> {

        private static final SouthAfricanCitizen __ = new SouthAfricanCitizen();

        protected SouthAfricanCitizenBuilder() {
        }

        public final SouthAfricanCitizenBuilder setId(final Long id) {
            __.setId(id);
            return this;
        }

        public SouthAfricanCitizenBuilder setLegalIdentifier(SouthAfricanIdentityDocument id) {
            __.setIdentifier(id);
            return this;
        }

        public SouthAfricanCitizenBuilder addEmailAddress(final EmailAddress address) {
            __.addEmailAddress(address);
            return this;
        }
        
        public SouthAfricanCitizenBuilder addEmailAddresses(final Iterable<EmailAddress> addresses) {
            __.addEmailAddresses(addresses);
            return this;
        }

        public SouthAfricanCitizenBuilder addTelephoneNumber(final TelephoneNumber number) {
            __.addTelephoneNumber(number);
            return this;
        }
        
        public SouthAfricanCitizenBuilder addTelephoneNumbers(final Iterable<TelephoneNumber> numbers) {
            __.addTelephoneNumbers(numbers);
            return this;
        }

        public SouthAfricanCitizenBuilder addAddress(final Address address) {
            __.addAddress(address);
            return this;
        }
        
        public SouthAfricanCitizenBuilder addAddresses(final Iterable<Address> addresses) {
            __.addAddresses(addresses);
            return this;
        }

        public SouthAfricanCitizenBuilder addGivenName(final String name) {
            __.addGivenName(name);
            return this;
        }
        
        public SouthAfricanCitizenBuilder addGivenNames(final Iterable<String> names) {
            __.addGivenNames(names);
            return this;
        }

        public SouthAfricanCitizenBuilder addAlias(final String alias) {
            __.addAlias(alias);
            return this;
        }

        public SouthAfricanCitizenBuilder setPreferredGivenName(final String name) {
            __.setPreferredGivenName(name);
            return this;
        }

        public SouthAfricanCitizenBuilder setNickname(final String name) {
            __.setNickName(name);
            return this;
        }

        public SouthAfricanCitizenBuilder setFamilyName(final String name) {
            __.setFamilyName(name);
            return this;
        }

        public SouthAfricanCitizenBuilder setDateOfBirth(final Date date) {
            __.setDateOfBirth(date);
            return this;
        }

        public SouthAfricanCitizenBuilder setDeceasedDate(final Date date) {
            __.setDeceasedOn(date);
            return this;
        }

        public SouthAfricanCitizenBuilder setGender(final GenderType gender) {
            __.setGender(gender);
            return this;
        }

        public SouthAfricanCitizenBuilder addTitle(final TitleType title) {
            __.addTitle(title);
            return this;
        }

        @Override
        public SouthAfricanCitizen build() {
            return __;
        }
    }
}
