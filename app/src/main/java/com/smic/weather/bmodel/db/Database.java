package com.smic.weather.bmodel.db;

import android.app.Application;

import androidx.room.Room;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class Database extends Application {
    public static Database instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
    }

    public static Database getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}