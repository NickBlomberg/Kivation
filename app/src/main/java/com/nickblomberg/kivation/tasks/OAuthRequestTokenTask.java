package com.nickblomberg.kivation.tasks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import timber.log.Timber;

/**
 * A background task to obtain a Request Token from Kiva using OAuth. This is the initial
 * step required to authenticate with the user's account.
 */
public class OAuthRequestTokenTask extends AsyncTask<Void, Void, Void> {

    private Context mContext;
    private OAuthProvider mProvider;
    private OAuthConsumer mConsumer;
    private String mCallback;

    public OAuthRequestTokenTask(Context context, OAuthConsumer consumer, OAuthProvider provider,
                                 String callback) {
        this.mContext = context;
        this.mProvider = provider;
        this.mConsumer = consumer;
        this.mCallback = callback;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {

            final String url = mProvider.retrieveRequestToken(mConsumer, mCallback);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    .setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                            Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_FROM_BACKGROUND |
                            Intent.FLAG_ACTIVITY_NEW_TASK);

            Timber.d("Obtaining a request token");

            mContext.startActivity(intent);

        } catch (Exception e) {
            Timber.e("Unable to obtain a request token" + e.getMessage());
        }

        return null;
    }

}
