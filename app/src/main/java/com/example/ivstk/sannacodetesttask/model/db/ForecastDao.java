package com.example.ivstk.sannacodetesttask.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;

import io.reactivex.Maybe;

/**
 * Created by Ivan on 16.01.2018.
 */

@Dao
public interface ForecastDao {

    @Insert
    void insertForecast(Forecast forecast);

    @Update
    void updateForecast(Forecast forecast);

    @Query("SELECT * FROM Forecast WHERE cityId =(:cityId)")
    Maybe<Forecast> getForecast(int cityId);
}
