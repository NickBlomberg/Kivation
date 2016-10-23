package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

@Parcel(Parcel.Serialization.BEAN)
public class Location {

    @SerializedName("country_code")
    private String countryCode;

    private String country;

    private String town;

    private Geo geo;

    @Override
    public String toString() {
        return "Location{" +
                "countryCode='" + countryCode + '\'' +
                ", country='" + country + '\'' +
                ", town='" + town + '\'' +
                ", geo=" + geo +
                '}';
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
