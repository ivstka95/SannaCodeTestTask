package com.example.ivstk.sannacodetesttask.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Forecast {
    @PrimaryKey
    private int ds;

    public int getDs() {
        return ds;
    }

    public void setDs(int ds) {
        this.ds = ds;
    }
}
