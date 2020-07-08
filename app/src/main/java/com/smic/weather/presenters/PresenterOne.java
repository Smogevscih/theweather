package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
public class PresenterOne implements ContractOne.Presenter {
    ContractOne.View view;
    ContractOne.BModel model;
    Context context;
    public static final int GOOD_CONNECT = 100;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == 2) {
                iniField();
            }
            if (msg.what == GOOD_CONNECT) {
                model.getListCity();
            }
        }
    };

    public PresenterOne(ContractOne.View view) {
        this.view = view;
        context = ((Activity) view).getApplicationContext();
        model = new TemperatureInCity(handler);
    }

    @Override
    public void iniField() {
        ArrayList<City> listCyties;
        listCyties = model.getList();
        ArrayAdapter<?> adapter = new ArrayAdapter(context, R.layout.custom_spinner, listCyties.toArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        view.showSpinnerCity(adapter);
    }

    @Override
    public void onGetField() {
        model.onConnectBD();
    }

    @Override
    public void onSelectedCity(City city) {
        view.showTypeCity(city.getTypeCity());
    }
}
