package com.example.ivstk.sannacodetesttask.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ivstk.sannacodetesttask.model.entity.Forecast;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by Ivan on 16.01.2018.
 */

@Dao
public interface ForecastDao {

    @Insert
    void insertEvents(Forecast forecast);

    @Query("DELETE FROM Forecast")
    int dropTable();

    @Query("SELECT * FROM Forecast")
    Maybe<Forecast> getForecast();
}
