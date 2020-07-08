package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ArrayAdapter;

import com.smic.weather.EditCityActivity;
import com.smic.weather.EditTemperatureActivity;
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
                //добавить show  на тост
            }
        }
    };

    public PresenterTwo(ContractTwo.View view) {
        this.view = view;
        context = ((Activity) view).getApplicationContext();
        model = new TemperatureInCity(handler);
    }


    @Override
    public void onBtnUpdateCity(City city, String nameCity, String typeCity) {
        city.setName(nameCity);
        city.setTypeCity(typeCity);
        model.updateCity(city);
    }

    @Override
    public void onBtnAddNewCity(String typeCity) {
        model.addNewCity(typeCity);
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

    @Override
    public void onBtnOpenActivityForEditTemp(City city) {
        Intent intent = new Intent(context, EditTemperatureActivity.class);
        intent.putExtra("key", city.getId());
        context.startActivity(intent);
    }
}
