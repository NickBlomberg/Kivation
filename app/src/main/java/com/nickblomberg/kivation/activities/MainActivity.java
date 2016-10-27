package com.nickblomberg.kivation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The main activity into which the activity launches. This currently just displays
 * the token and secret acquired from authenticating with a Kiva user account.
 */
public class MainActivity extends BaseActivity {

    private SessionManager sessionManager;
    @BindView(R.id.login_status) @Nullable TextView mLoginStatus;
    @BindView(R.id.button_logout) @Nullable Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(this);

        updateLoginDetails();

        // Temporary logout button for debugging
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
                updateLoginDetails();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void updateLoginDetails() {
        String[] credentials = sessionManager.getOAuthCredentials();
        String token = credentials[0];
        String secret = credentials[1];

        // Show the access token and secret when entries have been saved
        if (credentials.length == 2) {
            mLoginStatus.setText("\nToken: " + token + "\n\nSecret: " + secret);
        }
    }

}
