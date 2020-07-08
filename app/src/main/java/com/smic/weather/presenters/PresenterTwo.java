package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ArrayAdapter;

import com.smic.weather.R;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.TemperatureInCity;
import com.smic.weather.contracts.ContractTwo;

import java.util.ArrayList;

import static com.smic.weather.bmodel.Constants.GOOD_CONNECT;
import static com.smic.weather.bmodel.Constants.GOOD_OPERATION;
import static com.smic.weather.bmodel.Constants.NO_CONNECT;

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
            if (msg.what == GOOD_OPERATION) {
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
    public void onBtnDelCity(City city) {
        model.delCity(city);
    }

    @Override
    public void iniField() {
        ArrayList<City> listCyties;
        listCyties = model.getList();
        ArrayAdapter<?> adapter = new ArrayAdapter(context, R.layout.custom_spinner, listCyties.toArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        view.showSpinnerCity(adapter);
    }
}
