package com.smic.weather.bmodel.temp;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class Celsium implements Temperature {
    @Override
    public double getTemperature(double currentTemperature) {
        return currentTemperature;
    }

    @Override
    public String toString() {
        return "Celsium";
    }
}
