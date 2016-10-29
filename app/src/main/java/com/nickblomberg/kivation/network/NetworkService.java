package com.nickblomberg.kivation.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nickblomberg.kivation.Config;
import com.nickblomberg.kivation.models.Description;
import com.nickblomberg.kivation.models.Tags;
import com.nickblomberg.kivation.network.serializers.DescriptionDeserializer;
import com.nickblomberg.kivation.network.serializers.TagsDeserializer;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    private String mToken;
    private String mSecret;

    public NetworkService() {
        this.mToken = "";
        this.mSecret = "";
        setup();
    }

    public NetworkService(String token, String secret) {
        this.mToken = token;
        this.mSecret = secret;
        setup();
    }

    public void setup() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(loggingInterceptor);

        if (mToken != "" && mSecret != "") {
            OkHttpOAuthConsumer consumer =
                    new OkHttpOAuthConsumer(Config.CONSUMER_KEY, Config.CONSUMER_SECRET);

            consumer.setTokenWithSecret(mToken, mSecret);

            clientBuilder.addInterceptor(new SigningInterceptor(consumer));
        }

        sHttpClient = clientBuilder.build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Description.class, new DescriptionDeserializer())
                .registerTypeAdapter(Tags.class, new TagsDeserializer())
                .create();

        sBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));

        Retrofit retrofit = sBuilder.client(sHttpClient).build();
        mApi = retrofit.create(KivaAPI.class);
    }

    public KivaAPI getAPI() {
        return mApi;
    }
}
