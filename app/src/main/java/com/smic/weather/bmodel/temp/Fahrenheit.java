package com.smic.weather.bmodel.temp;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class Fahrenheit implements Temperature {
    @Override
    public double getTemperature(double currentTemperature) {

        return new BigDecimal(currentTemperature * 9 / 5 + 32).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Farenheit";
    }
}
