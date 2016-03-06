package com.nickblomberg.kivation.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.TextView;

import com.nickblomberg.kivation.R;

import oauth.signpost.OAuth;

/**
 * The main activity into which the activity launches. This currently just displays
 * the token and secret acquired from authenticating with a Kiva user account.
 */
public class MainActivity extends BaseActivity {

    private SharedPreferences mPrefs;
    private TextView mLoginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        mLoginStatus = (TextView) findViewById(R.id.login_status);

        String token = mPrefs.getString(OAuth.OAUTH_TOKEN, "");
        String secret = mPrefs.getString(OAuth.OAUTH_TOKEN_SECRET, "");

        // Show the access token and secret when entries have been saved
        if (token != "" && secret != "") {
            mLoginStatus.setText("\nToken: " + token + "\n\nSecret: " + secret);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
