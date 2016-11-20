package com.nickblomberg.kivation.presenters;

import com.nickblomberg.kivation.Config;
import com.nickblomberg.kivation.models.Location;
import com.nickblomberg.kivation.models.responses.LoansResponse;
import com.nickblomberg.kivation.network.NetworkService;
import com.nickblomberg.kivation.views.activities.LoanDetailActivity;

import java.net.URI;

import okhttp3.HttpUrl;
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
                .subscribe(new Observer<LoansResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Problem fetching full loan data: %s", e.getMessage());
                    }

                    @Override
                    public void onNext(LoansResponse loansResponse) {
                        mView.setSecondaryLoanData(loansResponse.getLoans().get(0));
                    }
                });
    }

    public URI createStaticGoogleMap(Location location) {

        float latitude = location.getLatitude();
        float longitude = location.getLongitude();

        return new HttpUrl.Builder()
                .scheme("https")
                .host("maps.googleapis.com")
                .addPathSegments("maps/api/staticmap")
                .addQueryParameter("center", latitude + "," + longitude)
                .addQueryParameter("size", "640x400")
                .addQueryParameter("scale", "2")
                .addQueryParameter("zoom", "10")
                .addQueryParameter("markers", "color:green|" + latitude + "," + longitude)
                .addQueryParameter("key", Config.GOOGLE_MAPS_API_KEY)
                .build()
                .uri();
    }
}
