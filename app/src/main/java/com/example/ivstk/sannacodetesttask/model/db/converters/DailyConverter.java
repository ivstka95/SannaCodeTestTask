package com.example.ivstk.sannacodetesttask.model.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.ivstk.sannacodetesttask.model.entity.forecast.Daily;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DailyConverter {
    @TypeConverter
    public static Daily fromString(String value) {
        Type type = new TypeToken<Daily>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromPOJO(Daily pojo) {
        Gson gson = new Gson();
        String json = gson.toJson(pojo);
        return json;
    }
}
