package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * A model to define the location from which a Loan originates.
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

    public float getLatitude() {
        String pairs = this.getGeo().getPairs();
        String longitude = pairs.split(" ")[0];

        return Float.parseFloat(longitude);
    }

    public float getLongitude() {
        String pairs = this.getGeo().getPairs();
        String latitude = pairs.split(" ")[1];

        return Float.parseFloat(latitude);
    }
}
