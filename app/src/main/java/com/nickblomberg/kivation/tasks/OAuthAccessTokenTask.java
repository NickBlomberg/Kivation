package com.nickblomberg.kivation.tasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import timber.log.Timber;

/**
 * This is the second step in the OAuth authentication process. The Access Token is requested
 * using the Request Token retrieved using the first step.
 */
public class OAuthAccessTokenTask extends AsyncTask<Uri, Void, Void> {

    private Context mContext;
    private OAuthProvider mProvider;
    private OAuthConsumer mConsumer;
    private SharedPreferences mPreferences;

    public OAuthAccessTokenTask(Context context, OAuthProvider provider,
                                OAuthConsumer consumer, SharedPreferences prefs) {
        this.mContext = context;
        this.mProvider = provider;
        this.mConsumer = consumer;
        this.mPreferences = prefs;
    }

    @Override
    protected Void doInBackground(Uri... params) {

        final Uri uri = params[0];

        final String oAuthVerifier = uri.getQueryParameter(OAuth.OAUTH_VERIFIER);

        try {
            Timber.d("Fetching an Access Token");

            mProvider.retrieveAccessToken(mConsumer, oAuthVerifier);

            final SharedPreferences.Editor edit = mPreferences.edit();

            // Write the Access Token components to preferences
            edit.putString(OAuth.OAUTH_TOKEN, mConsumer.getToken());
            edit.putString(OAuth.OAUTH_TOKEN_SECRET, mConsumer.getTokenSecret());
            edit.apply();

            String token = mPreferences.getString(OAuth.OAUTH_TOKEN, "");
            String secret = mPreferences.getString(OAuth.OAUTH_TOKEN_SECRET, "");

            mConsumer.setTokenWithSecret(token, secret);

        } catch (Exception e) {

            Timber.e("Problem fetching the Access Token: %s", e.getMessage());

        }

        return null;
    }


}
