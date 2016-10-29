package com.nickblomberg.kivation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.nickblomberg.kivation.KivationApp;
import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.UserAccount;
import com.nickblomberg.kivation.network.NetworkService;
import com.nickblomberg.kivation.presenters.AccountPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public class AccountActivity extends BaseActivity {
    private AccountPresenter mAccountPresener;

    @Nullable @BindView(R.id.full_name) TextView mFullName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        NetworkService networkService = ((KivationApp) getApplicationContext()).getNetworkService();
        mAccountPresener = new AccountPresenter(this, networkService);

        mAccountPresener.getUserAccount();
    }

    public void setUserAccountData(UserAccount account) {
        mFullName.setText(account.getFirstName() + " " + account.getLastName());
    }
}
