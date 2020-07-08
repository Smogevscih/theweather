package com.smic.weather.bmodel.temp;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PairTempAndMonth {
    private int month;
    private double temp;

    public PairTempAndMonth(int month, double temp) {
        this.month = month;
        this.temp = temp;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
