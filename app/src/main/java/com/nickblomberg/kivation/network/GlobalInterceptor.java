package com.nickblomberg.kivation.network;

import com.nickblomberg.kivation.Config;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * An interceptor to be applied to every request to add an app_id
 * parameter, as requested in the Kiva API documentation.
 *
 * @author Nick Blomberg
 */

public class GlobalInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalUrl = originalRequest.url();

        HttpUrl modifiedUrl =originalUrl.newBuilder()
                .addQueryParameter("app_id", Config.CONSUMER_KEY)
                .build();

        Request.Builder requestBuilder = originalRequest.newBuilder().url(modifiedUrl);
        Request modifiedRequest = requestBuilder.build();
        return chain.proceed(modifiedRequest);
    }
}
