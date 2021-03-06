package com.smic.weather.bmodel;

import android.os.Handler;

import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.db.AppDatabase;
import com.smic.weather.bmodel.db.CitiesDAO;
import com.smic.weather.bmodel.db.Database;
import com.smic.weather.bmodel.temp.PairTempAndMonth;
import com.smic.weather.bmodel.temp.Temperature;
import com.smic.weather.contracts.ContractOne;
import com.smic.weather.contracts.ContractThree;
import com.smic.weather.contracts.ContractTwo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smic.weather.bmodel.Constants.GOOD_CONNECT;
import static com.smic.weather.bmodel.Constants.GOOD_OPERATION;
import static com.smic.weather.bmodel.Constants.NO_CONNECT;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class TemperatureInCity implements ContractOne.BModel, ContractTwo.BModel, ContractThree.BModel {
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

    //восстановление городов по типам после десериализации.
//    private void updateCities() {
//        ArrayList<City> newList = new ArrayList<>();
//        for (City city : list) {
//        if(city )
//        }
//    }

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
    public List<PairTempAndMonth> getListPair(City city) {
        List<PairTempAndMonth> listPair = new ArrayList<>();
        if (city != null) {
            listPair.add(new PairTempAndMonth(1, city.tJanuary));
            listPair.add(new PairTempAndMonth(2, city.tFebruary));
            listPair.add(new PairTempAndMonth(3, city.tMarch));
            listPair.add(new PairTempAndMonth(4, city.tApril));
            listPair.add(new PairTempAndMonth(5, city.tMay));
            listPair.add(new PairTempAndMonth(6, city.tJune));
            listPair.add(new PairTempAndMonth(7, city.tJuly));
            listPair.add(new PairTempAndMonth(8, city.tAugust));
            listPair.add(new PairTempAndMonth(9, city.tSeptember));
            listPair.add(new PairTempAndMonth(10, city.tOctober));
            listPair.add(new PairTempAndMonth(11, city.tNovember));
            listPair.add(new PairTempAndMonth(12, city.tDecember));
        }
        return listPair;
    }

    @Override
    public City getCity(int id) {
        for (City city : list) {
            if (city.getId() == id) return city;
        }
        return null;
    }

    @Override
    public void updateTemp(City city, List<PairTempAndMonth> listTemp) {
        city.settJanuary((Double) listTemp.get(0).getTemp());
        city.settFebruary((Double) listTemp.get(1).getTemp());
        city.settMarch((Double) listTemp.get(2).getTemp());
        city.settApril((Double) listTemp.get(3).getTemp());
        city.settMay((Double) listTemp.get(4).getTemp());
        city.settJune((Double) listTemp.get(5).getTemp());
        city.settJuly((Double) listTemp.get(6).getTemp());
        city.settAugust((Double) listTemp.get(7).getTemp());
        city.settSeptember((Double) listTemp.get(8).getTemp());
        city.settOctober((Double) listTemp.get(9).getTemp());
        city.settNovember((Double) listTemp.get(10).getTemp());
        city.settDecember((Double) listTemp.get(11).getTemp());
        updateCity(city);
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
