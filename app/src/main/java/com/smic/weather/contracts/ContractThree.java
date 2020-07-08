package com.smic.weather.contracts;

import android.widget.ArrayAdapter;

import com.smic.weather.PairAdapter;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.temp.PairTempAndMonth;
import com.smic.weather.bmodel.temp.Temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public interface ContractThree {
    interface BModel {

        List<PairTempAndMonth> getListPair(City city);

        City getCity(int id);

        void updateTemp(City city, List<PairTempAndMonth> listTemp);

        void onConnectBD();
    }

    interface Presenter {
        void onInitField(int id);

        void onBtnSave(List listTemp);
    }

    interface View {

        void showTempAndMonth(PairAdapter pairAdapter);

        void showTitle(String title);
    }
}
