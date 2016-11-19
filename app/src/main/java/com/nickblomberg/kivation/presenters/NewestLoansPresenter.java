package com.nickblomberg.kivation.presenters;

import com.nickblomberg.kivation.views.activities.NewestLoansActivity;
import com.nickblomberg.kivation.models.responses.LoansResponse;
import com.nickblomberg.kivation.network.NetworkService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * // TODO create class javadoc
 * @authoer Nick Blomberg
 */

public class NewestLoansPresenter {

    NewestLoansActivity mView;
    NetworkService mNetworkService;

    public NewestLoansPresenter(NewestLoansActivity view, NetworkService networkService) {
        this.mView = view;
        this.mNetworkService = networkService;
    }

    public void loadNewestLoans(int page) {
        mNetworkService.getAPI().getNewestLoans(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoansResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoansResponse loansResponse) {
                        mView.displayNewestLoans(loansResponse.getLoans());
                    }
                });
    }
}
