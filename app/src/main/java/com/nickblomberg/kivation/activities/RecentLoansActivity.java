package com.nickblomberg.kivation.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nickblomberg.kivation.KivationApp;
import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.PagedLoans;
import com.nickblomberg.kivation.network.KivaAPI;
import com.nickblomberg.kivation.views.adapters.LoanAdapter;

import oauth.signpost.OAuth;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

/**
 * An activity to display the most recent loans which have been added to the Kiva platform.
 */
public class RecentLoansActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private PagedLoans mPagedLoans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);

        mRecyclerView = (RecyclerView) findViewById(R.id.loans_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mPagedLoans = new PagedLoans();
        RecyclerView.Adapter adapter = new LoanAdapter(this, mPagedLoans);
        mRecyclerView.setAdapter(adapter);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String token = mPrefs.getString(OAuth.OAUTH_TOKEN, "");
        String secret = mPrefs.getString(OAuth.OAUTH_TOKEN_SECRET, "");

        KivationApp app = (KivationApp) getApplicationContext();
        KivaAPI loanClient = app.getNetworkService().getAPI();

        Call<PagedLoans> call = loanClient.getNewestLoans();

        call.enqueue(new Callback<PagedLoans>() {
            @Override
            public void onResponse(Response<PagedLoans> response, Retrofit retrofit) {
                mPagedLoans = response.body();
                mRecyclerView.swapAdapter(new LoanAdapter(RecentLoansActivity.this, response.body()), false);
            }

            @Override
            public void onFailure(Throwable t) {
                Timber.e("Failed to receive response from Kiva API");
            }
        });
    }
}
