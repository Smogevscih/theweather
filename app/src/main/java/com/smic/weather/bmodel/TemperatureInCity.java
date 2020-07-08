package com.smic.weather.bmodel;

import android.os.Handler;

import com.smic.weather.bmodel.db.AppDatabase;
import com.smic.weather.bmodel.db.CitiesDAO;
import com.smic.weather.bmodel.db.Database;
import com.smic.weather.bmodel.temp.Temperature;
import com.smic.weather.contracts.ContractOne;
import com.smic.weather.presenters.PresenterOne;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Override
    public void onConnectBD() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = Database.getInstance().getDatabase();
                citiesDAO = db.citiesDAO();
                if (citiesDAO != null) {
                    handler.sendEmptyMessage(PresenterOne.GOOD_CONNECT);
                } else {
                    handler.sendEmptyMessage(PresenterOne.NO_CONNECT);
                }

            }
        });
        thread.start();
    }

    @Override
    public String mediumTepmSeason(City city, String season, Temperature scale) {
        double average = 0;

        switch (season) {
            case "WINTER":
                average = (city.getAverageWinter()) / 3;
                break;
            case "SPRING":
                average = (city.getAverageSpring()) / 3;
                break;
            case "SUMMER":
                average = (city.getAverageSummer()) / 3;
                break;
            case "AUTUMN":
                average = (city.getAverageAutumn()) / 3;
                break;
        }

        average = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP).doubleValue();
        average = scale.getTemperature(average);
        return "Средняя температура за сезон " + season + " равна " + average + " град. по шкале " + scale;
    }

//    City addCity() {
//        City city = new City(2, "Москва", "SMALL", 1,
//                1, 3, 4, 5, 6, 7, 8,
//                9, 10, 11, 12);
//        return city;
//    }
}
