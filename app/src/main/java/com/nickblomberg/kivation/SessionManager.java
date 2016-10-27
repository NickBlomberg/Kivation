package com.nickblomberg.kivation;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public class SessionManager {
    private Context mContext;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private static final String PREFS_NAME = "KivationPrefs";
    private static final int PREFS_MODE = 0;

    private static final String IS_AUTHENTICATED = "IsAuthenticated";
    private static final String OAUTH_TOKEN = "OAuthToken";
    private static final String OAUTH_SECRET = "OAuthSecret";


    public SessionManager(Context context) {
        this.mContext = context;
        mPreferences = mContext.getSharedPreferences(PREFS_NAME, PREFS_MODE);
        mEditor = mPreferences.edit();
    }

    public void login(String token, String secret) {
        mEditor.putBoolean(IS_AUTHENTICATED, true);
        mEditor.putString(OAUTH_TOKEN, token);
        mEditor.putString(OAUTH_SECRET, secret);
        mEditor.commit();
    }

    public boolean isUserAuthenticated() {
        return mPreferences.getBoolean(IS_AUTHENTICATED, false);
    }

    public void logout() {
        mEditor.remove(IS_AUTHENTICATED);
        mEditor.remove(OAUTH_TOKEN);
        mEditor.remove(OAUTH_SECRET);
        mEditor.commit();
    }

    public String[] getOAuthCredentials() {
        String token = mPreferences.getString(OAUTH_TOKEN, "");
        String secret = mPreferences.getString(OAUTH_SECRET, "");

        String[] credentials = new String[2];
        credentials[0] = token;
        credentials[1] = secret;

        return credentials;
    }
}
