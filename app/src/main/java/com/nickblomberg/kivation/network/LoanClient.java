package com.nickblomberg.kivation.network;

import com.nickblomberg.kivation.models.PagedLoans;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Defines the methods required for accessing API features connected to loans.
 */
public interface LoanClient {
    @GET("loans/newest.json")
    Call<PagedLoans> getNewestLoans();
}