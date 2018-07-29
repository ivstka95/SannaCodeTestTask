package com.example.ivstk.sannacodetesttask.model.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.ivstk.sannacodetesttask.model.entity.forecast.Hourly;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class HourlyConverter {
    @TypeConverter
    public static Hourly fromString(String value) {
        Type type = new TypeToken<Hourly>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromPOJO(Hourly pojo) {
        Gson gson = new Gson();
        String json = gson.toJson(pojo);
        return json;
    }
}
