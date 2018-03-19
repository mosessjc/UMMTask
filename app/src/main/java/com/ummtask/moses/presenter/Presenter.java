package com.ummtask.moses.presenter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ummtask.moses.R;
import com.ummtask.moses.model.Model;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Moses on 18-03-2018.
 */

public class Presenter extends RecyclerView
        .Adapter<Presenter
        .DataObjectHolder> {
    private static ArrayList<Model> mDataset;
    private static MyClickListener myClickListener;
    Context context;
    Typeface myTypeface;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        @BindView(R.id.tvName) TextView tvName;
        @BindView(R.id.tvAddress) TextView tvAddress;
        @BindView(R.id.tvDistance) TextView tvDistance;
        @BindView(R.id.tvStatus) TextView tvStatus;
        @BindView(R.id.tvOffer) TextView tvOffer;
        @BindView(R.id.ivLogo) ImageView ivLogo;
        @BindView(R.id.ivPlaceImage) ImageView ivPlaceImage;
        @BindView(R.id.ivAlert) ImageView ivAlert;
        @BindView(R.id.ivRatingOne) ImageView ivRatingOne;
        @BindView(R.id.ivRatingTwo) ImageView ivRatingTwo;
        @BindView(R.id.ivRatingThree) ImageView ivRatingThree;
        @BindView(R.id.ivRatingFour) ImageView ivRatingFour;
        @BindView(R.id.ivRatingFive) ImageView ivRatingFive;


        public DataObjectHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public Presenter(Context context, ArrayList<Model> myDataset) {
        this.context = context;
        mDataset = myDataset;
        myTypeface = Typeface.createFromAsset(context.getAssets(), "font/arialbd.ttf");
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_childview_layout, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {
        final Model mTrending = mDataset.get(position);

        holder.tvName.setTypeface(myTypeface);
        holder.tvName.setText(mDataset.get(position).getName());
        holder.tvAddress.setText(mDataset.get(position).getAddress());
        holder.tvDistance.setText(mDataset.get(position).getDistance());
        holder.tvOffer.setText(mDataset.get(position).getOffer());
        holder.ivPlaceImage.setImageResource(mTrending.getImage());
        holder.ivLogo.setImageResource(mTrending.getLogo());

        int alert = mTrending.getAlert();
        if (alert == 0)
            holder.ivAlert.setImageResource(R.drawable.ic_alert_off);
        else if (alert == 1) {
            holder.ivAlert.setImageResource(R.drawable.ic_alert_on);
        }

        int rating = mTrending.getRating();
        if (rating == 0) {
        } else if (rating == 1)
            holder.ivRatingOne.setImageResource(R.drawable.ic_star_coloured);
        else if (rating == 2) {
            holder.ivRatingOne.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingTwo.setImageResource(R.drawable.ic_star_coloured);
        } else if (rating == 3) {
            holder.ivRatingOne.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingTwo.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingThree.setImageResource(R.drawable.ic_star_coloured);
        } else if (rating == 4) {
            holder.ivRatingOne.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingTwo.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingThree.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingFour.setImageResource(R.drawable.ic_star_coloured);
        } else if (rating == 5) {
            holder.ivRatingOne.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingTwo.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingThree.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingFour.setImageResource(R.drawable.ic_star_coloured);
            holder.ivRatingFive.setImageResource(R.drawable.ic_star_coloured);
        }

        String status = mTrending.getStatus();
        if (status.equals(context.getString(R.string.status_open))) {
            holder.tvStatus.setBackground(context.getDrawable(R.drawable.status_open_background));
            holder.tvStatus.setText(context.getString(R.string.status_open));
        } else if (status.equals(context.getString(R.string.status_closed))) {
            holder.tvStatus.setBackground(context.getDrawable(R.drawable.status_closed_background));
            holder.tvStatus.setText(context.getString(R.string.status_closed));
        }

        holder.ivAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int alert = mDataset.get(position).getAlert();
                Model trending;
                if (alert == 0) {
                    trending = new Model(mDataset.get(position).getId(),
                            mDataset.get(position).getName(),
                            mDataset.get(position).getAddress(),
                            mDataset.get(position).getStatus(),
                            mDataset.get(position).getImage(),
                            mDataset.get(position).getRating(),
                            1,
                            mDataset.get(position).getLogo(),
                            mDataset.get(position).getDistance(),
                            mDataset.get(position).getOffer());
                    mDataset.set(position, trending);
                } else if (alert == 1) {
                    trending = new Model(mDataset.get(position).getId(),
                            mDataset.get(position).getName(),
                            mDataset.get(position).getAddress(),
                            mDataset.get(position).getStatus(),
                            mDataset.get(position).getImage(),
                            mDataset.get(position).getRating(),
                            0,
                            mDataset.get(position).getLogo(),
                            mDataset.get(position).getDistance(),
                            mDataset.get(position).getOffer());
                    mDataset.set(position, trending);
                }

                notifyDataSetChanged();
            }

        });
    }

    public void addItem(Model dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
