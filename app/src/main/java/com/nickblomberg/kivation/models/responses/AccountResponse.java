package com.nickblomberg.kivation.models.responses;

import com.google.gson.annotations.SerializedName;
import com.nickblomberg.kivation.models.my.UserAccount;

/**
 * Provides a model for the response received by retrofit when requesting
 * basic account data for the authenticated user.
 *
 * @see http://build.kiva.org/api#GET*|my|account
 * @author Nick Blomberg
 */

public class AccountResponse {
    @SerializedName("user_account")
    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "userAccount=" + userAccount +
                '}';
    }
}
