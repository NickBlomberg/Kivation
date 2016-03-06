package com.nickblomberg.kivation;

import android.app.Application;

import timber.log.Timber;

public class KivationApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
