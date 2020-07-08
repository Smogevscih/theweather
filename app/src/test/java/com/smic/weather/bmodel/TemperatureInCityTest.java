package com.smic.weather.bmodel;

import com.smic.weather.bmodel.temp.Celsium;
import com.smic.weather.bmodel.temp.Temperature;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class TemperatureInCityTest {

    Temperature temperature;
    final double EPS=1e-9;
    String season;
    City city;

    @Before
    public void setUp() throws Exception {
        temperature=new Celsium();
        city=new City(2, "Москва", "SMALL", 1,
                1, 2, 2, 2, 3, 3, 3,
                4, 4, 4, 1);
    }
    @Test
    public void averageTempInScale() {
        season="WINTER";
       // assertEquals(1,);
    }
}