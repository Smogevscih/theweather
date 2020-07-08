package com.smic.weather.bmodel;

import android.os.Handler;

import com.smic.weather.bmodel.db.AppDatabase;
import com.smic.weather.bmodel.db.CitiesDAO;
import com.smic.weather.bmodel.db.Database;
import com.smic.weather.contracts.ContractOne;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class TemperatureInCity implements ContractOne.BModel {
    private CitiesDAO citiesDAO;
    Handler handler;
    static ArrayList<City> list;

    public TemperatureInCity(Handler handler) {
        this.handler = handler;
        AppDatabase db = Database.getInstance().getDatabase();
        citiesDAO = db.citiesDAO();
    }

    @Override
    public void getListCity() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                list = (ArrayList<City>) citiesDAO.getAll();
                handler.sendEmptyMessage(2);
            }
        });
        thread.start();
    }

    @Override
    public ArrayList<City> getList() {

        return list;
    }
}
