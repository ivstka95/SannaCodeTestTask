package com.example.ivstk.sannacodetesttask.model.api.forecast;

import com.example.ivstk.sannacodetesttask.BuildConfig;
import com.example.ivstk.sannacodetesttask.model.api.ServiceGenerator;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;

import io.reactivex.Observable;

public class DarkSkyService {
    private static DarkSkyService instance = null;
    private DarkSkyApi api;

    private DarkSkyService(final DarkSkyApi api) {
        this.api = api;
    }

    public static synchronized DarkSkyService instance() {
        if (instance == null) instance =
                new DarkSkyService(ServiceGenerator.generate(DarkSkyApi.class));
        return instance;
    }

    public Observable<Forecast> fetchForecast(String coordinates) {
        return api.fetchForecast(BuildConfig.ApiKey, coordinates);
    }
}
