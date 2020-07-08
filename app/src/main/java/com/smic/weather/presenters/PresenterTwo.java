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
    public static final int GOOD_CONNECT = 100;
    public static final int NO_CONNECT = 400;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == 2) {
                iniField();
            }
            if (msg.what == GOOD_CONNECT) {
                model.getListCity();
                          }
            if (msg.what == NO_CONNECT) {

            }
        }
    };
    public PresenterTwo(ContractTwo.View view) {
        this.view = view;
        context = ((Activity) view).getApplicationContext();
        model = new TemperatureInCity(handler);
    }


    @Override
    public void onGetListCity() {
        model.onConnectBD();
    }

    @Override
    public void iniField() {

    }
}
