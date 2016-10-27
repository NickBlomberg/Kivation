package com.nickblomberg.kivation.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nickblomberg.kivation.Config;
import com.nickblomberg.kivation.tasks.OAuthAccessTokenTask;
import com.nickblomberg.kivation.tasks.OAuthRequestTokenTask;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

/**
 * Provides the necessary steps required to authenticate the user with Kiva
 * in order to access protected user account data
 */
public class LoginActivity extends AppCompatActivity {

    private OAuthConsumer mConsumer;
    private OAuthProvider mProvider;

    private static final String OAUTH_CALLBACK = "x-oauthflow://callback";
    private static final String REQUEST_TOKEN_URL = "https://api.kivaws.org/oauth/request_token";
    private static final String ACCESS_TOKEN_URL = "https://api.kivaws.org/oauth/access_token";

    private static final String SCOPES = "access,user_balance,user_email,user_expected_repayments,user_anon_lender_data,user_anon_lender_loans,user_stats";

    private static final String AUTHORIZATION_URL =
            "https://www.kiva.org/oauth/authorize?response_type=code"
                    + "&oauth_callback=" + OAUTH_CALLBACK
                    + "&scope=" + SCOPES;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mConsumer = new CommonsHttpOAuthConsumer(Config.CONSUMER_KEY, Config.CONSUMER_SECRET);

        mProvider = new CommonsHttpOAuthProvider(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL,
                AUTHORIZATION_URL + "&client_id=" + Config.CONSUMER_KEY);

        mProvider.setOAuth10a(true);

        new OAuthRequestTokenTask(getApplicationContext(), mConsumer, mProvider, OAUTH_CALLBACK).execute();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        final Uri uri = intent.getData();
        if (uri != null && uri.getScheme().equals("x-oauthflow")) {
            new OAuthAccessTokenTask(this, mProvider, mConsumer).execute(uri);
            finish();
        }
    }
}
