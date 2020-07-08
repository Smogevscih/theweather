package com.smic.weather.bmodel.temp;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class Kelvin implements Temperature {
    @Override
    public double getTemperature(double currentTemperature) {
        return currentTemperature + 273.15;
    }

    @Override
    public String toString() {
        return "Kelvin";
    }
}
