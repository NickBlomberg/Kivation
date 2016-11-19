package com.nickblomberg.kivation.presenters;

import com.nickblomberg.kivation.views.activities.LoanDetailActivity;
import com.nickblomberg.kivation.models.PagedLoans;
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

public class LoanDetailPresenter {

    private LoanDetailActivity mView;
    private NetworkService mNetworkService;

    public LoanDetailPresenter(LoanDetailActivity mView, NetworkService mNetworkService) {
        this.mView = mView;
        this.mNetworkService = mNetworkService;
    }

    public void fetchCompleteLoanData(int loanID) {

        mNetworkService.getAPI().getLoan(loanID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PagedLoans>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Problem fetching full loan data: %s", e.getMessage());
                    }

                    @Override
                    public void onNext(PagedLoans pagedLoans) {
                        mView.setSecondaryLoanData(pagedLoans.getLoans().get(0));
                    }
                });
    }
}
