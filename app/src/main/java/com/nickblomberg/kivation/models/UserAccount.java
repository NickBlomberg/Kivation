package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

/**
 * Provides a model for basic user account data.
 *
 * @see http://build.kiva.org/api#GET*|my|account
 * @author Nick Blomberg
 */

public class UserAccount {
    private int id;

    @SerializedName("is_public")
    private boolean isPublic;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("lender_id")
    private String lenderId;

    @SerializedName("is_developer")
    private boolean isDeveloper;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(boolean developer) {
        isDeveloper = developer;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", isPublic=" + isPublic +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lenderId='" + lenderId + '\'' +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
