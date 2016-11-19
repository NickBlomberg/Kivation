package com.nickblomberg.kivation.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickblomberg.kivation.R;
import com.nickblomberg.kivation.models.Loan;
import com.nickblomberg.kivation.ui.CircleTransform;
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
    private static OnItemClickListener sListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.loan_name) TextView loanName;
        @BindView(R.id.loan_image) ImageView loanImage;
        @BindView(R.id.loan_amount) TextView loanAmount;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            sListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }
    }

    public LoanAdapter(Context context) {
        this.mContext = context;
        this.mLoans = new ArrayList<Loan>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        sListener = listener;
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
                .transform(new CircleTransform())
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

    public Loan getItem(int position) {
        return mLoans.get(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
