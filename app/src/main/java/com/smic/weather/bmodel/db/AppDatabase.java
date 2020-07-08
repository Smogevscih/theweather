package com.smic.weather.bmodel.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.smic.weather.bmodel.cities.City;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
@Database(entities = {City.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CitiesDAO citiesDAO();
}
