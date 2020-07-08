package com.smic.weather.presenters;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.smic.weather.PairAdapter;
import com.smic.weather.bmodel.TemperatureInCity;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.temp.PairTempAndMonth;
import com.smic.weather.contracts.ContractThree;

import java.util.List;
import java.util.Map;

import static com.smic.weather.bmodel.Constants.GOOD_OPERATION;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PresenterThree implements ContractThree.Presenter {
    private ContractThree.View view;
    private ContractThree.BModel model;
    Context context;
    PairAdapter pairAdapter;
    City city;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == GOOD_OPERATION) {
                onInitField();
            }
        }
    };

    public PresenterThree(ContractThree.View view) {
        this.view = view;
        model = new TemperatureInCity(handler);
        context = ((Activity) view).getApplicationContext();
        model.onConnectBD();
    }

    @Override
    public void onInitField(int id) {
        city = model.getCity(id);
        List<PairTempAndMonth> list = model.getListPair(city);
        pairAdapter = new PairAdapter(list);
        view.showTempAndMonth(pairAdapter);
    }

    public void onInitField() {
        List<PairTempAndMonth> list = model.getListPair(city);
        pairAdapter = new PairAdapter(list);
        view.showTempAndMonth(pairAdapter);
    }

    @Override
    public void onBtnSave(List listTemp) {
        model.updateTemp(city, listTemp);
    }
}
