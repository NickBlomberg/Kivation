package com.nickblomberg.kivation.network;

import com.nickblomberg.kivation.Config;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Provides a mechanism for building a rest client based on a defined Retrofit interface.
 */
public class RestClient {

    private static OkHttpClient sHttpClient = new OkHttpClient();

    private static final String END_POINT = "https://api.kivaws.org/v1/";

    private static Retrofit.Builder sBuilder =
            new Retrofit.Builder()
                    .baseUrl(END_POINT)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createClient(Class<S> clientClass, String token, String secret) {

        if (token != "" && secret != "") {

            // Create a consumer that can be used to sign requests with an Access Token
            OkHttpOAuthConsumer consumer =
                    new OkHttpOAuthConsumer(Config.CONSUMER_KEY, Config.CONSUMER_SECRET);

            consumer.setTokenWithSecret(token, secret);

            sHttpClient.interceptors().add(new SigningInterceptor(consumer));

            // Add a logging interceptor for debugging
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            sHttpClient.interceptors().add(logging);

        }

        Retrofit retrofit = sBuilder.client(sHttpClient).build();
        return retrofit.create(clientClass);
    }
}