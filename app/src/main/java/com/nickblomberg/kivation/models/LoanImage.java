package com.nickblomberg.kivation.models;

import org.parceler.Parcel;

/**
 * Defines the image which is attached to a specific Kiva Loan.
 *
 * @see http://build.kiva.org/docs/data/media
 */
@Parcel(Parcel.Serialization.BEAN)
public class LoanImage {

    private static final String BASE_URL = "http://www.kiva.org/img/";
    private static final String IMAGE_SMALL = "s300/";

    private long id;

    public String getSmallImageURL() {
        return BASE_URL + IMAGE_SMALL + id + ".jpg";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoanImage{" + id + "}";
    }

}
