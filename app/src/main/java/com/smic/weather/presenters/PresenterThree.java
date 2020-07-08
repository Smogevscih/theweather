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

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PresenterThree implements ContractThree.Presenter {
    private ContractThree.View view;
    private ContractThree.BModel model;
    Context context;
    PairAdapter pairAdapter;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {

        }
    };

    public PresenterThree(ContractThree.View view) {
        this.view = view;
        model = new TemperatureInCity(handler);
        context = ((Activity) view).getApplicationContext();
    }

    @Override
    public void onInitField(int id) {
        City myCity = model.getCity(id);
        List<PairTempAndMonth> list = model.getListPair(myCity);
        pairAdapter = new PairAdapter(list);
        view.showTempAndMonth(pairAdapter);
    }
}
