package com.nickblomberg.kivation.models.my;

/**
 * Provides a model for the user's current balance.
 *
 * @see http://build.kiva.org/api#GET*|my|balance
 * @author Nick Blomberg
 */

public class UserBalance {
    private String balance;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserBalance{" +
                "balance=" + balance +
                '}';
    }
}
