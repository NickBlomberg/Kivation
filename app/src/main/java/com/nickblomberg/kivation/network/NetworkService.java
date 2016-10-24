package com.nickblomberg.kivation.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nickblomberg.kivation.Config;
import com.nickblomberg.kivation.models.Description;
import com.nickblomberg.kivation.serializers.DescriptionDeserializer;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
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
        sHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Description.class, new DescriptionDeserializer())
                .create();

        sBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));

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
