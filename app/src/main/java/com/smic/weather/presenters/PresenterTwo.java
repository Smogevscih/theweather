package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ArrayAdapter;

import com.smic.weather.bmodel.City;
import com.smic.weather.bmodel.TemperatureInCity;
import com.smic.weather.contracts.ContractTwo;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PresenterTwo implements ContractTwo.Presenter {
    private ContractTwo.View view;
    private ContractTwo.BModel model;
    Context context;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {

        }
    };
    public PresenterTwo(ContractTwo.View view) {
        this.view = view;
        context = ((Activity) view).getApplicationContext();
        model = new TemperatureInCity(handler);

    }

}
