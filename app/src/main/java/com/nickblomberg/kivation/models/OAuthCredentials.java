package com.nickblomberg.kivation.models;

/**
 * Represents the OAuth credentials provided to the authenticated user
 *
 * @author Nick Blomberg
 */

public class OAuthCredentials {
    private String token;
    private String secret;

    public OAuthCredentials(String secret, String token) {
        this.secret = secret;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "OAuthCredentials{" +
                "token='" + token + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
