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
import com.nickblomberg.kivation.network.NetworkService;
import com.nickblomberg.kivation.presenters.NewestLoansPresenter;
import com.nickblomberg.kivation.views.adapters.LoanAdapter;

import butterknife.ButterKnife;
import oauth.signpost.OAuth;
import timber.log.Timber;

/**
 * An activity to display the most recent loans which have been added to the Kiva platform.
 */
public class RecentLoansActivity extends BaseActivity {

    RecyclerView mRecyclerView;

    private PagedLoans mPagedLoans;
    private NewestLoansPresenter mNewestLoansPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        ButterKnife.bind(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.loans_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mPagedLoans = new PagedLoans();
        RecyclerView.Adapter adapter = new LoanAdapter(this, mPagedLoans);
        mRecyclerView.setAdapter(adapter);

        KivationApp app = (KivationApp) getApplicationContext();
        NetworkService networkService = app.getNetworkService();

        mNewestLoansPresenter = new NewestLoansPresenter(this, networkService);
        mNewestLoansPresenter.loadNewestLoans();
    }

    public void displayNewestLoans(PagedLoans pagedLoans) {
        mRecyclerView.swapAdapter(new LoanAdapter(RecentLoansActivity.this, pagedLoans), false);
    }
}
