package com.nickblomberg.kivation.network;

import com.nickblomberg.kivation.models.responses.LoansResponse;
import com.nickblomberg.kivation.models.responses.AccountResponse;
import com.nickblomberg.kivation.models.responses.BalanceResponse;
import com.nickblomberg.kivation.models.responses.LenderResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Defines the methods required for accessing API features connected to loans.
 */
public interface KivaAPI {
    @GET("loans/{ids}.json")
    Observable<LoansResponse> getLoan(
            @Path("ids") int id
    );

    @GET("loans/newest.json")
    Observable<LoansResponse> getNewestLoans(
            @Query("page") int page);

    // My (user data)
    @GET("my/account.json")
    Observable<AccountResponse> getAccount();

    @GET("my/balance.json")
    Observable<BalanceResponse> getBalance();

    @GET("my/lender.json")
    Observable<LenderResponse> getMyLender();
}