package com.nickblomberg.kivation.models.responses;

import com.google.gson.annotations.SerializedName;
import com.nickblomberg.kivation.models.my.UserBalance;

/**
 * Represents the JSON response received by retrofit when requesting the
 * user's balance. Required to deserialize the request without writing
 * a custom deserializer.
 *
 * @author Nick Blomberg
 */

public class BalanceResponse {
    @SerializedName("user_balance")
    private UserBalance userBalance;

    public UserBalance getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(UserBalance userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "userBalance=" + userBalance +
                '}';
    }
}
