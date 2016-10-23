package com.nickblomberg.kivation.models;

import org.parceler.Parcel;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

@Parcel(Parcel.Serialization.BEAN)
public class Geo {
    private String level;

    private String pairs;

    private String type;

    @Override
    public String toString() {
        return "Geo{" +
                "level='" + level + '\'' +
                ", pairs='" + pairs + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPairs() {
        return pairs;
    }

    public void setPairs(String pairs) {
        this.pairs = pairs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
