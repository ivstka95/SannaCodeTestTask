package com.example.ivstk.sannacodetesttask.model.db.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.ivstk.sannacodetesttask.model.entity.forecast.Currently;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class CurrentlyConverter {

    @TypeConverter
    public static Currently fromString(String value) {
        Type type = new TypeToken<Currently>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromPOJO(Currently pojo) {
        Gson gson = new Gson();
        String json = gson.toJson(pojo);
        return json;
    }
}
