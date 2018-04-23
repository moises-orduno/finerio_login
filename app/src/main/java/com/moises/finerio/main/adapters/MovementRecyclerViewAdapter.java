package com.moises.finerio.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moises.finerio.R;
import com.moises.finerio.main.models.Datum;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MovementRecyclerViewAdapter extends RecyclerView.Adapter<MovementRecyclerViewAdapter.ViewHolder> {

    private final List<Datum> mValues;

    public MovementRecyclerViewAdapter(List<Datum> items) {
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTextViewName.setText(mValues.get(position).getCustomDescription());
        holder.mTextViewDate.setText(mValues.get(position).getCustomDate());
        holder.mTextViewAmount.setText("$ "+mValues.get(position).getAmount());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mTextViewName;
        private final TextView mTextViewAmount;
        private final TextView mTextViewDate;
        private Datum mItem;
//        private Datum mItem;

        private ViewHolder(View view) {
            super(view);
            mView = view;
            mTextViewName = view.findViewById(R.id.textview_name);
            mTextViewAmount = view.findViewById(R.id.textview_amount);
            mTextViewDate = view.findViewById(R.id.textview_date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewName.getText() + "'";
        }
    }
}
