package com.example.ivstk.sannacodetesttask.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ivstk.sannacodetesttask.R;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.DataPoint;
import com.example.ivstk.sannacodetesttask.utils.system.DateUtils;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.DataPointHolder> {

    private List<DataPoint> items;
    private String timeStampFormat;

    public ForecastAdapter(String timeStampFormat) {
        this.timeStampFormat = timeStampFormat;
        this.items = new ArrayList<>();
    }

    public void setItems(List<DataPoint> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataPointHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataPointHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_data_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataPointHolder holder, int position) {
        holder.setUp(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class DataPointHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTime)
        TextView tvTime;
        @BindView(R.id.tvTemperature)
        TextView tvTemperature;
        @BindView(R.id.tvPressure)
        TextView tvPressure;
        @BindView(R.id.tvHumidity)
        TextView tvHumidity;
        @BindView(R.id.tvWindSpeed)
        TextView tvWindSpeed;
        @BindView(R.id.tvPrecipProbability)
        TextView tvPrecipProbability;


        DataPointHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setUp(DataPoint dataPoint) {
            tvTime.setText(DateUtils.formatTimestamp(new DateTime(dataPoint.getTime()), timeStampFormat));
            tvTemperature.setText(String.valueOf(dataPoint.getTemperature()));
            tvPressure.setText(String.valueOf(dataPoint.getPressure()));
            tvHumidity.setText(String.valueOf(dataPoint.getHumidity()));
            tvWindSpeed.setText(String.valueOf(dataPoint.getWindSpeed()));
            tvPrecipProbability.setText(String.valueOf(dataPoint.getPrecipProbability()));
        }
    }
}
