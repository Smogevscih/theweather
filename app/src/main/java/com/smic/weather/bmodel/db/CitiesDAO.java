package com.smic.weather.bmodel.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.smic.weather.bmodel.cities.City;

import java.util.List;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
@Dao
public interface CitiesDAO {
    @Query("SELECT * FROM city")
    List<City> getAll();
    @Insert
    void insert(City city);
    @Update
    void update(City city);

    @Delete
    void delete(City city);
}
