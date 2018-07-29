package com.example.ivstk.sannacodetesttask.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.ivstk.sannacodetesttask.R;
import com.example.ivstk.sannacodetesttask.model.entity.Forecast;


/**
 * Created by Ivan on 16.01.2018.
 */

@Database(entities = {Forecast.class}, version = 1)
@TypeConverters({})
public abstract class MyDataBase extends RoomDatabase {

    private static MyDataBase INSTANCE;

    public static MyDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), MyDataBase.class,
                            context.getString(R.string.app_name))
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public abstract ForecastDao forecatDao();
}