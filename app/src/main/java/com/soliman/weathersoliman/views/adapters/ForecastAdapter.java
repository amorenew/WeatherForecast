package com.soliman.weathersoliman.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soliman.weathersoliman.R;
import com.soliman.weathersoliman.models.MyForecastModel;
import com.soliman.weathersoliman.utils.Util;

import java.util.List;

/**
 * Created by islam on 3/29/16.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {
    private List<MyForecastModel> forecastdays;
    private Context context;

    public ForecastAdapter(List<MyForecastModel> forecastdays, Context context) {
        this.forecastdays = forecastdays;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_forecast, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyForecastModel forecastday = forecastdays.get(position);
        holder.tvDescription.setText(forecastday.getDescription());
        holder.tvDate.setText(forecastday.getDate());
        holder.tvDegreeHigh.setText(forecastday.getDegreeHigh());
        holder.tvCondition.setText(forecastday.getCondition());
        //load image from url and set it in image view
        Util.getInstance().loadImage(context, holder.ivForecast, forecastday.getImageLink(), R.drawable.error_image);

    }

    @Override
    public int getItemCount() {
        return forecastdays.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivForecast;
        public TextView tvDescription;
        public TextView tvDate;
        public TextView tvDegreeHigh;
        public TextView tvCondition;

        public MyViewHolder(View view) {
            super(view);
            ivForecast = (ImageView) view.findViewById(R.id.ivForecast);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvDegreeHigh = (TextView) view.findViewById(R.id.tvDegreeHigh);
            tvCondition = (TextView) view.findViewById(R.id.tvCondition);


        }
    }

}
