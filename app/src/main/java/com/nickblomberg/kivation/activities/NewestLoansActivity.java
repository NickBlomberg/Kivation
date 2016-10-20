package com.nickblomberg.kivation.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nickblomberg.kivation.EndlessRecyclerViewScrollListener;
import com.nickblomberg.kivation.KivationApp;
import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.Loan;
import com.nickblomberg.kivation.presenters.NewestLoansPresenter;
import com.nickblomberg.kivation.views.adapters.LoanAdapter;

import java.util.List;

import butterknife.ButterKnife;

/**
 * An activity to display the most recent loans which have been added to the Kiva platform.
 */
public class NewestLoansActivity extends BaseActivity {

    RecyclerView mRecyclerView;

    private LoanAdapter mAdapter;
    private NewestLoansPresenter mNewestLoansPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        ButterKnife.bind(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.loans_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new LoanAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        KivationApp app = (KivationApp) getApplicationContext();

        mNewestLoansPresenter = new NewestLoansPresenter(this, app.getNetworkService());
        mNewestLoansPresenter.loadNewestLoans(1);

        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mNewestLoansPresenter.loadNewestLoans(page);
            }
        });
    }

    public void displayNewestLoans(List<Loan> loans) {
        mAdapter.appendLoans(loans);
        mAdapter.notifyDataSetChanged();
    }
}
