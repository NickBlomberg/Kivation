package com.nickblomberg.kivation.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickblomberg.kivation.KivationApp;
import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.Loan;
import com.nickblomberg.kivation.network.NetworkService;
import com.nickblomberg.kivation.presenters.LoanDetailPresenter;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoanDetailActivity extends BaseActivity {
    private LoanDetailPresenter mLoanDetailPresenter;

    @Nullable @BindView(R.id.detail_loan_image) ImageView mLoanImage;
    @Nullable @BindView(R.id.detail_loan_name) TextView mLoanName;
    @Nullable @BindView(R.id.detail_loan_sector) TextView mLoanTheme;
    @Nullable @BindView(R.id.detail_description) TextView mLoanDescription;
    @Nullable @BindView(R.id.detail_loan_country) TextView mLoanCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_detail);
        ButterKnife.bind(this);

        Loan loan = Parcels.unwrap(getIntent().getParcelableExtra("loan"));
        setPrimaryLoanData(loan);

        NetworkService networkService = ((KivationApp) getApplicationContext()).getNetworkService();
        mLoanDetailPresenter = new LoanDetailPresenter(this, networkService);
        mLoanDetailPresenter.fetchCompleteLoanData(Integer.parseInt(loan.getId()));
    }

    public void setPrimaryLoanData(Loan loan) {
        Picasso.with(this)
                .load(loan.getImage().getSmallImageURL())
                .into(mLoanImage);

        mLoanName.setText(loan.getName());
        mLoanTheme.setText(loan.getSector());


        mLoanCountry.setText(loan.getLocation().getCountry());
    }

    public void setSecondaryLoanData(Loan loan) {
        mLoanDescription.setText(loan.getDescription().getDescription());
    }
}
