/**
 * Copyright © ${project.inceptionYear}, Mycila
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */
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
