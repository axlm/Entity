// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of Address.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
 * 
 */
//XML ANNOTATIONS
@XmlRootElement(name = "address")
@XmlType(name = "Address")
//ENTITY ANNOTATIONS
public class Address implements Serializable {
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
    private static final long serialVersionUID = 4184492517262397439L;

    @XmlAttribute(name = "type", required = true)
    private AddressType __type;

    @XmlElement(name = "location", required = true, nillable = false)
    private String __location;

    @XmlElement(name = "suburb")
    private String __suburb;

    @XmlElement(name = "city", required = true, nillable = false)
    private String __city;

    @XmlElement(name = "region")
    private String __region;

    @XmlElement(name = "country")
    private String __country;

    @XmlElement(name = "code", required = true, nillable = false)
    private String __code;

    @XmlTransient
    private Entity<?> __entity;

    /**
     * Default constructor.
     * <p>
     * This constructor is supplied to conform to the JavaBeans 1.01 Specification. It
     * <strong>MUST NOT</strong> be invoked directly.
     * 
     * @see <a href="http://bit.ly/BddaX">JavaBeans 1.01 Specification</a>.
     */
    public Address() {
        super();
    }

    /**
     * Instance variable constructor. Initialise <code>this</code> instance with the specified
     * arguments. <i>For state specifications see the see also section</i>.
     * 
     * @param type
     * @param location
     * @param suburb
     * @param city
     * @param region
     * @param country
     * @param code
     */
    public Address(
            final AddressType type,
            final String location,
            final String suburb,
            final String city,
            final String region,
            final String country,
            final String code) {
        this();
        setType(type);
        setLocation(location);
        setSuburb(suburb);
        setCity(city);
        setRegion(region);
        setCountry(country);
        setCode(code);
    }

    /**
     * Copy constructor. <i>For state specifications see the see also section</i>.
     * 
     * @param template
     *            Uses template as template to initialise {@linkplain Address
     *            <code>this</code>}.
     */
    public Address(final Address template) {
        this(
                template.getType(),
                template.getLocation(),
                template.getSuburb(),
                template.getCity(),
                template.getRegion(),
                template.getCountry(),
                template.getCode());
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__type address type}.
     */
    public final AddressType getType() {
        return __type;
    }

    /**
     * Obvious.
     * 
     * @param type
     *            Value to assign to <code>this</code> {@linkplain #__type address type}.
     */
    final void setType(final AddressType type) {
        __type = type;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__location location}.
     */
    public final String getLocation() {
        return __location;
    }

    /**
     * Obvious.
     * 
     * @param location
     *            Value to assign to <code>this</code> {@linkplain #__location location}.
     */
    final void setLocation(final String location) {
        __location = location;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__suburb suburb}.
     */
    public final String getSuburb() {
        return __suburb;
    }

    /**
     * Obvious.
     * 
     * @param suburb
     *            Value to assign to <code>this</code> {@linkplain #__suburb suburb}.
     */
    final void setSuburb(final String suburb) {
        __suburb = suburb;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__city city}.
     */
    public final String getCity() {
        return __city;
    }

    /**
     * Obvious.
     * 
     * @param city
     *            Value to assign to <code>this</code> {@linkplain #__city city}.
     */
    final void setCity(final String city) {
        __city = city;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__region region}.
     */
    public final String getRegion() {
        return __region;
    }

    /**
     * Obvious.
     * 
     * @param region
     *            Value to assign to <code>this</code> {@linkplain #__region region}.
     */
    final void setRegion(final String region) {
        __region = region;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__country country}.
     */
    public final String getCountry() {
        return __country;
    }

    /**
     * Obvious.
     * 
     * @param country
     *            Value to assign to <code>this</code> {@linkplain #__country country}.
     */
    final void setCountry(final String country) {
        __country = country;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__code code}.
     */
    public final String getCode() {
        return __code;
    }

    /**
     * Obvious.
     * 
     * @param code
     *            Value to assign to <code>this</code> {@linkplain #__code code}.
     */
    final void setCode(final String code) {
        __code = code;
    }

    /**
     * Obvious.
     * 
     * @return The value of <code>this</code> instance's {@linkplain #__entity entity reference}.
     */
    final Entity<?> getEntity() {
        return __entity;
    }

    /**
     * Obvious.
     * 
     * @param reference
     *            Value to assign to <code>this</code> {@linkplain #__entity entity reference}.
     */
    final void setEntity(final Entity<?> reference) {
        __entity = reference;
    }

    /**
     * @author <a href="mailto:axl.mattheus@4axka.net">4axka (Pty) Ltd</a>
     */
    @XmlEnum
    public enum AddressType {
        @XmlEnumValue("Home")
        HOME,
        @XmlEnumValue("Office")
        OFFICE,
        @XmlEnumValue("Postal")
        POSTAL;
    }
}
