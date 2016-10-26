package com.nickblomberg.kivation.network;

import com.nickblomberg.kivation.models.PagedLoans;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Defines the methods required for accessing API features connected to loans.
 */
public interface KivaAPI {
    @GET("loans/{ids}.json")
    Observable<PagedLoans> getLoan(
            @Path("ids") int id
    );

    @GET("loans/newest.json")
    Observable<PagedLoans> getNewestLoans(
            @Query("page") int page);
}