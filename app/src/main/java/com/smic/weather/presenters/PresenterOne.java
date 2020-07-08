package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.smic.weather.R;
import com.smic.weather.bmodel.City;
import com.smic.weather.bmodel.TemperatureInCity;
import com.smic.weather.contracts.ContractOne;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PresenterOne implements ContractOne.Presenter{
    ContractOne.View view;
    ContractOne.BModel model;
    Context context;

    public PresenterOne(ContractOne.View view) {
        this.view = view;
        context = ((Activity) view).getApplicationContext();
        model = new TemperatureInCity();
    }

    @Override
    public void iniField() {

    }
}
