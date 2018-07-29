package com.example.ivstk.sannacodetesttask.model.api.forecast;

import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkSkyApi {
    @GET("{key}/{coordinates}?exclude=minutely,alerts,flags")
    Observable<Forecast> fetchForecast(@Path("key") String key, @Path("coordinates") String coordinates);
}
