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

        mNetworkService = new NetworkService();
    }

    public NetworkService getNetworkService() {
        return mNetworkService;
    }
}
