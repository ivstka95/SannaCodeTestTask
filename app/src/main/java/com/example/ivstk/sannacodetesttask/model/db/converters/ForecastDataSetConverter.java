package com.example.ivstk.sannacodetesttask.model.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.ivstk.sannacodetesttask.model.entity.forecast.ForecastDataSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ForecastDataSetConverter {
    @TypeConverter
    public static ForecastDataSet fromString(String value) {
        Type type = new TypeToken<ForecastDataSet>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromPOJO(ForecastDataSet pojo) {
        Gson gson = new Gson();
        String json = gson.toJson(pojo);
        return json;
    }
}
