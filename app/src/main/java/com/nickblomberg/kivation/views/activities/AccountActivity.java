package com.nickblomberg.kivation.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickblomberg.kivation.KivationApp;
import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.Lender;
import com.nickblomberg.kivation.models.my.UserAccount;
import com.nickblomberg.kivation.models.my.UserBalance;
import com.nickblomberg.kivation.network.NetworkService;
import com.nickblomberg.kivation.presenters.AccountPresenter;
import com.nickblomberg.kivation.views.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public class AccountActivity extends BaseActivity {
    private AccountPresenter mAccountPresener;

    @Nullable @BindView(R.id.account_full_name) TextView mFullName;
    @Nullable @BindView(R.id.account_image) ImageView mAccountImage;
    @Nullable @BindView(R.id.account_num_loans) TextView mNumLoans;
    @Nullable @BindView(R.id.account_num_invitees) TextView mNumInvitees;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        NetworkService networkService = ((KivationApp) getApplicationContext()).getNetworkService();
        mAccountPresener = new AccountPresenter(this, networkService);

        mAccountPresener.getUserAccount();
        mAccountPresener.getBalance();
        mAccountPresener.getMyLender();
    }

    public void setUserAccountData(UserAccount account) {
        mFullName.setText(account.getFirstName() + " " + account.getLastName());
    }

    public void setUserBalance(UserBalance userBalance) {
        return;
    }

    public void setLenderData(Lender lender) {
        Picasso.with(this)
                .load(lender.getImage().getSmallImageURL())
                .transform(new CircleTransform())
                .into(mAccountImage);

        mNumLoans.setText(Integer.toString(lender.getLoanCount()));

        mNumInvitees.setText(Integer.toString(lender.getInviteeCount()));
    }
}
