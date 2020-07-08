package com.smic.weather.bmodel.temp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class FahrenheitTest {
    Temperature temperature;
    final double EPS = 1e-9;

    @Before
    public void setUp() throws Exception {
        temperature = new Fahrenheit();
    }

    //F= 9 / 5*C + 32
    @Test
    public void getTemperature() {
      assertEquals(50, temperature.getTemperature(10), EPS);
      assertEquals(71.6, temperature.getTemperature(22), EPS);
    }
}