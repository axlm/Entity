package _4axka.common.entity;

import _4axka.common.entity.id.SouthAfricanIdentityDocument;
import _4axka.util.data.Identifiable;
import _4axka.util.functor.Builder;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity(name = "SouthAfricanCitizen")
@Table(name = "SOUTH_AFTICAN_CITIZENS")
public class SouthAfricanCitizen extends Person implements Identifiable<SouthAfricanIdentityDocument> {
    @XmlElement(name = "identifier", required = true, nillable = false)
    @Embedded
    private SouthAfricanIdentityDocument __id;

    protected SouthAfricanCitizen() {
    }

    public SouthAfricanCitizen(final SouthAfricanIdentityDocument id, final Person template) {
        super(template);
        __id = id;
    }

    public SouthAfricanCitizen(
            final SouthAfricanIdentityDocument id,
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
        __id = id;
    }

    public SouthAfricanCitizen(SouthAfricanIdentityDocument __id) {
        this.__id = __id;
    }
    
    public static final SouthAfricanCitizenBuilder southAfricanCitizenBuilder() {
        return new SouthAfricanCitizenBuilder();
    }

    @Override
    public SouthAfricanIdentityDocument getIdentifier() {
        return __id;
    }
    
    void setIdentifier(final SouthAfricanIdentityDocument id) {
        __id = id;
    }

    public static final class SouthAfricanCitizenBuilder implements Builder<SouthAfricanCitizen> {

        private static final SouthAfricanCitizen __ = new SouthAfricanCitizen();

        protected SouthAfricanCitizenBuilder() {
        }

        public SouthAfricanCitizenBuilder setLegalIdentifier(SouthAfricanIdentityDocument id) {
            __.setIdentifier(id);
            return this;
        }

        public SouthAfricanCitizenBuilder addEmailAddress(final EmailAddress address) {
            __.addEmailAddress(address);
            return this;
        }

        public SouthAfricanCitizenBuilder addTelephoneNumber(final TelephoneNumber number) {
            __.addTelephoneNumber(number);
            return this;
        }

        public SouthAfricanCitizenBuilder addAddress(final Address address) {
            __.addAddress(address);
            return this;
        }

        public SouthAfricanCitizenBuilder addGivenName(final String name) {
            __.addGivenName(name);
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
