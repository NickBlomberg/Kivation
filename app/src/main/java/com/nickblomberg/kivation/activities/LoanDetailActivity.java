package com.nickblomberg.kivation.activities;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.Loan;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;
import timber.log.Timber;

public class LoanDetailActivity extends BaseActivity {
    private Loan mLoan;

    @Nullable @BindView(R.id.detail_loan_image) ImageView mLoanImage;
    @Nullable @BindView(R.id.detail_loan_name) TextView mLoanName;
    @Nullable @BindView(R.id.detail_loan_sector) TextView mLoanTheme;
    @Nullable @BindView(R.id.detail_description) TextView mLoanDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_detail);
        ButterKnife.bind(this);

        mLoan = Parcels.unwrap(getIntent().getParcelableExtra("loan"));

        Timber.d("Detail Activity: " + mLoan.toString());

        Picasso.with(this)
                .load(mLoan.getImage().getSmallImageURL())
                .into(mLoanImage);

        mLoanName.setText(mLoan.getName());
        mLoanTheme.setText(mLoan.getSector());

        // TODO replace with actual loan description data (requires an additional API call)
        mLoanDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Nam ornare, erat non fermentum imperdiet, turpis ipsum molestie diam, eget " +
                "vulputate libero arcu eget massa. Integer quis ligula nibh. Suspendisse sit " +
                "amet mi eleifend, fringilla lorem non, elementum purus. Donec felis arcu, " +
                "feugiat eget augue ac, sodales tempus diam. Phasellus elit ipsum, scelerisque id " +
                "fermentum a, convallis maximus massa. Nulla finibus urna in imperdiet pretium. " +
                "Morbi rhoncus scelerisque magna, sed pulvinar lectus iaculis eget. Phasellus " +
                "interdum ut est suscipit ultricies. Maecenas tincidunt molestie felis in " +
                "maximus. Sed a dui et turpis pulvinar condimentum. In pretium dapibus velit, " +
                "vulputate iaculis neque rutrum vitae. Vestibulum pharetra elit ac risus " +
                "eleifend, in feugiat orci placerat. Etiam dui sem, egestas vel quam id, " +
                "egestas tristique quam. Maecenas viverra quis dolor sit amet interdum. " +
                "Quisque non consectetur ante.");
    }
}
