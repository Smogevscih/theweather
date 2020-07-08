package com.smic.weather.bmodel;

import android.os.Handler;

import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.db.AppDatabase;
import com.smic.weather.bmodel.db.CitiesDAO;
import com.smic.weather.bmodel.db.Database;
import com.smic.weather.bmodel.temp.Temperature;
import com.smic.weather.contracts.ContractOne;
import com.smic.weather.contracts.ContractTwo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static com.smic.weather.bmodel.Constants.GOOD_CONNECT;
import static com.smic.weather.bmodel.Constants.GOOD_OPERATION;
import static com.smic.weather.bmodel.Constants.NO_CONNECT;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class TemperatureInCity implements ContractOne.BModel, ContractTwo.BModel {
    private CitiesDAO citiesDAO;
    Handler handler;
    static ArrayList<City> list;
    FactoryCity factoryCity;


    public TemperatureInCity(Handler handler) {
        this.handler = handler;
        factoryCity = new FactoryCity();

    }

    @Override
    public void getListCity() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                list = (ArrayList<City>) citiesDAO.getAll();
                handler.sendEmptyMessage(GOOD_OPERATION);
            }
        });
        thread.start();
    }

    @Override
    public ArrayList<City> getList() {

        return list;
    }

    @Override
    public void delCity(final City city) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                citiesDAO.delete(city);
                list = (ArrayList<City>) citiesDAO.getAll();
                handler.sendEmptyMessage(GOOD_OPERATION);
            }
        });
        thread.start();
    }

    @Override
    public void updateCity(final City city) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                citiesDAO.update(city);
                list = (ArrayList<City>) citiesDAO.getAll();
                handler.sendEmptyMessage(GOOD_OPERATION);
            }
        });
        thread.start();

    }

    @Override
    public void addNewCity(final String typeCity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = citiesDAO.getAll().size() + 1;
                City newCity = factoryCity.getCity(typeCity);
                newCity.setId(count);
                citiesDAO.insert(newCity);
                list = (ArrayList<City>) citiesDAO.getAll();
                handler.sendEmptyMessage(GOOD_OPERATION);
            }
        }).start();
    }

    @Override
    public void onConnectBD() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = Database.getInstance().getDatabase();
                citiesDAO = db.citiesDAO();
                if (citiesDAO != null) {
                    handler.sendEmptyMessage(GOOD_CONNECT);
                } else {
                    handler.sendEmptyMessage(NO_CONNECT);
                }

            }
        });
        thread.start();
    }

    @Override
    public String answerMediumTepmSeason(City city, String season, Temperature scale) {

        return "Средняя температура за сезон " + season + " равна " + averageTempInScale(city, season, scale) + " град. по шкале " + scale;
    }

    private double averageTempInScale(City city, String season, Temperature scale) {
        double average = 0;

        switch (season) {
            case "WINTER":
                average = city.getAverageWinter();
                break;
            case "SPRING":
                average = city.getAverageSpring();
                break;
            case "SUMMER":
                average = city.getAverageSummer();
                break;
            case "AUTUMN":
                average = city.getAverageAutumn();
                break;

        }

        average = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP).doubleValue();
        average = scale.getTemperature(average);
        return average;
    }

//    City addCity() {
//        City city = new City(2, "Москва", "SMALL", 1,
//                1, 3, 4, 5, 6, 7, 8,
//                9, 10, 11, 12);
//        return city;
//    }
}
