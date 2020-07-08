package com.smic.weather.bmodel;

import com.smic.weather.bmodel.cities.BigCity;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.cities.MediumCity;
import com.smic.weather.bmodel.cities.SmallCity;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class FactoryCity {
    private static String[] sizeCities = new String[]{"BIG", "MEDIUM", "SMALL"};

    public FactoryCity() {

    }

    public City getCity(String typeCity) {
        City city = null;
        if (typeCity.equals(sizeCities[0]))
            city = new BigCity(0, "New City", sizeCities[0],0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        if (typeCity.equals(sizeCities[1]))
            city = new MediumCity(0, "New City", sizeCities[1],0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        if (typeCity.equals(sizeCities[2]))
            city = new SmallCity(0, "New City", sizeCities[2],0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        return city;
    }

    public static String[] getSizeCities() {
        return sizeCities;
    }
}
