package com.nickblomberg.kivation.models;

import org.parceler.Parcel;

import java.util.List;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

@Parcel(Parcel.Serialization.BEAN)
public class Tags {

    private List<String> tags;

    public Tags() {

    }

    public Tags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tags=" + tags +
                '}';
    }
}
