package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ArrayAdapter;

import com.smic.weather.EditCityActivity;
import com.smic.weather.R;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.TemperatureInCity;
import com.smic.weather.bmodel.temp.Celsium;
import com.smic.weather.bmodel.temp.Fahrenheit;
import com.smic.weather.bmodel.temp.Kelvin;
import com.smic.weather.bmodel.temp.Temperature;
import com.smic.weather.contracts.ContractOne;

import java.util.ArrayList;

import static com.smic.weather.bmodel.Constants.GOOD_CONNECT;
import static com.smic.weather.bmodel.Constants.GOOD_OPERATION;
import static com.smic.weather.bmodel.Constants.NO_CONNECT;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PresenterOne implements ContractOne.Presenter {
    ContractOne.View view;
    ContractOne.BModel model;
    Context context;

    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == GOOD_OPERATION) {
                iniField();
            }
            if (msg.what == GOOD_CONNECT) {
                model.getListCity();
                view.showToast("Connect on BD");
            }
            if (msg.what == NO_CONNECT) {

                view.showToast("We have problem with BD. Maybe BD no such.");
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
    public void onBtnOpenEditActivity() {
        Intent intent = new Intent(context, EditCityActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onGetField() {
        model.onConnectBD();
    }

    @Override
    public void onSelectedCity(City city) {
        view.showTypeCity(city.getTypeCity());
    }

    @Override
    public void onGetAnswer(City city, String season, String scale) {
        Temperature scaleTemp = null;
        switch (scale) {
            case "Celsium":
                scaleTemp = new Celsium();
                break;
            case "Fahrenheit":
                scaleTemp = new Fahrenheit();
                break;
            case "Kelvin":
                scaleTemp = new Kelvin();
                break;
        }
        view.showAnswer(model.answerMediumTepmSeason(city, season, scaleTemp));
    }
}
