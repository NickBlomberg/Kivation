package com.nickblomberg.kivation.presenters;

import com.nickblomberg.kivation.views.activities.AccountActivity;
import com.nickblomberg.kivation.models.responses.AccountResponse;
import com.nickblomberg.kivation.models.responses.BalanceResponse;
import com.nickblomberg.kivation.models.responses.LenderResponse;
import com.nickblomberg.kivation.network.NetworkService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public class AccountPresenter {
    private AccountActivity mView;
    private NetworkService networkService;

    public AccountPresenter(AccountActivity view, NetworkService networkService) {
        this.mView = view;
        this.networkService = networkService;
    }

    public void getUserAccount() {
        networkService.getAPI().getAccount()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AccountResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error with user %s", e.getMessage());
                    }

                    @Override
                    public void onNext(AccountResponse accountResponse) {
                        mView.setUserAccountData(accountResponse.getUserAccount());
                    }
                });
    }

    public void getBalance() {
        networkService.getAPI().getBalance()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BalanceResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error fetching user account balance %s", e.getMessage());
                    }

                    @Override
                    public void onNext(BalanceResponse balanceResponse) {
                        mView.setUserBalance(balanceResponse.getUserBalance());
                    }
                });
    }

    public void getMyLender() {
        networkService.getAPI().getMyLender()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LenderResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error fetching user lender data %s", e.getMessage());
                    }

                    @Override
                    public void onNext(LenderResponse lenderResponse) {
                        mView.setLenderData(lenderResponse.getLenders().get(0));
                    }
                });
    }
}
