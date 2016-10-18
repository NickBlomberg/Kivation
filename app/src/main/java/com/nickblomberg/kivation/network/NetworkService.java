package com.nickblomberg.kivation.network;

import com.nickblomberg.kivation.Config;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * @author Nick Blomberg
 */

public class NetworkService {
    private static OkHttpClient sHttpClient;
    private static Retrofit.Builder sBuilder;

    private static final String BASE_URL = "https://api.kivaws.org/v1/";

    private KivaAPI mApi;

    public NetworkService() {
        sHttpClient = new OkHttpClient();

        sBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = sBuilder.client(sHttpClient).build();
        mApi = retrofit.create(KivaAPI.class);
    }

    public void addSigningInterceptor(String token, String secret) {
        OkHttpOAuthConsumer consumer =
                new OkHttpOAuthConsumer(Config.CONSUMER_KEY, Config.CONSUMER_SECRET);

        consumer.setTokenWithSecret(token, secret);

        sHttpClient.interceptors().add(new SigningInterceptor(consumer));
    }

    public KivaAPI getAPI() {
        return mApi;
    }
}
