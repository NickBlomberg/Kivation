package com.nickblomberg.kivation.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.Loan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TODO: Add a class comment header
 */
public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.ViewHolder> {

    private Context mContext;
    private List<Loan> mLoans;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.loan_name) TextView loanName;
        @BindView(R.id.loan_image) ImageView loanImage;
        @BindView(R.id.loan_amount) TextView loanAmount;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public LoanAdapter(Context context) {
        this.mContext = context;
        this.mLoans = new ArrayList<Loan>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_loan, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.loanName.setText(mLoans.get(i).getName());

        Picasso.with(mContext)
                .load(mLoans.get(i).getImage().getSmallImageURL())
                .into(viewHolder.loanImage);

        viewHolder.loanAmount.setText("$ " + mLoans.get(i).getLoanAmount());
    }

    @Override
    public int getItemCount() {
        return mLoans.size();
    }

    public void appendLoans(List<Loan> loans) {
        mLoans.addAll(loans);
    }
}
