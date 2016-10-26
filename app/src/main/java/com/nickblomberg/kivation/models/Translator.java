package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

@Parcel(Parcel.Serialization.BEAN)
public class Translator {
    @SerializedName("byline")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Translator{" +
                "name='" + name + '\'' +
                '}';
    }
}
