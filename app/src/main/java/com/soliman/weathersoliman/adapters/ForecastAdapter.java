package com.soliman.weathersoliman.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soliman.weathersoliman.R;
import com.soliman.weathersoliman.database.ForecastModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by islam on 3/29/16.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {
    private List<ForecastModel> forecastdays;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivForecast;
        public TextView tvDescription;
        public TextView tvDate;
        public TextView tvDegreeHigh;
        public TextView tvDegreeLow;

        public MyViewHolder(View view) {
            super(view);
            ivForecast = (ImageView) view.findViewById(R.id.ivForecast);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvDegreeHigh = (TextView) view.findViewById(R.id.tvDegreeHigh);
            tvDegreeLow = (TextView) view.findViewById(R.id.tvDegreeLow);


        }
    }


    public ForecastAdapter(List<ForecastModel> forecastdays, Context context) {
        this.forecastdays = forecastdays;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ForecastModel forecastday = forecastdays.get(position);
        holder.tvDescription.setText(forecastday.getDescription());
        holder.tvDate.setText(forecastday.getDate());
        holder.tvDegreeHigh.setText(forecastday.getDegreeHigh());
        holder.tvDegreeLow.setText(forecastday.getDegreeLow());

        Picasso.with(this.context)
                .load(forecastday.getImageLink())
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher)
                .into(holder.ivForecast);

    }

    @Override
    public int getItemCount() {
        return forecastdays.size();
    }

}
