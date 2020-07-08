package com.smic.weather.bmodel.temp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class KelvinTest {
    Temperature temperature;
    final double EPS=1e-9;
    @Before
    public void setUp() throws Exception {
        temperature=new Kelvin();
    }
    @Test
    public void getTemperature() {
        assertEquals(273.15, temperature.getTemperature(0), EPS);
    }
}