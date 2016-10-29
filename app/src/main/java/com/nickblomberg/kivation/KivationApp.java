package com.nickblomberg.kivation;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.nickblomberg.kivation.network.NetworkService;

import timber.log.Timber;

public class KivationApp extends Application {
    private NetworkService mNetworkService;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        Stetho.initializeWithDefaults(this);

        createNetworkService();
    }

    private void createNetworkService() {
        SessionManager sessionManager = new SessionManager(this);
        String[] credentials = sessionManager.getOAuthCredentials();

        if (credentials.length == 2) {
            mNetworkService = new NetworkService(credentials[0], credentials[1]);
        } else {
            mNetworkService = new NetworkService();
        }
    }

    public NetworkService getNetworkService() {
        return mNetworkService;
    }
}
