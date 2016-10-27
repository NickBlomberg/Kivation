package com.nickblomberg.kivation.tasks;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.nickblomberg.kivation.SessionManager;

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
    private SessionManager sessionManager;

    public OAuthAccessTokenTask(Context context, OAuthProvider provider, OAuthConsumer consumer) {
        this.mContext = context;
        this.mProvider = provider;
        this.mConsumer = consumer;

        sessionManager = new SessionManager(mContext);
    }

    @Override
    protected Void doInBackground(Uri... params) {

        final Uri uri = params[0];

        final String oAuthVerifier = uri.getQueryParameter(OAuth.OAUTH_VERIFIER);

        try {
            Timber.d("Fetching an Access Token");

            mProvider.retrieveAccessToken(mConsumer, oAuthVerifier);

            String token = mConsumer.getToken();
            String secret = mConsumer.getTokenSecret();

            sessionManager.login(token, secret);
            
            mConsumer.setTokenWithSecret(token, secret);

        } catch (Exception e) {

            Timber.e("Problem fetching the Access Token: %s", e.getMessage());

        }

        return null;
    }


}
