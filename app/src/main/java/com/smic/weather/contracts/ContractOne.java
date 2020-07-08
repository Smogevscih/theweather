package com.smic.weather.contracts;

import android.widget.ArrayAdapter;

import com.smic.weather.bmodel.City;
import com.smic.weather.bmodel.temp.Temperature;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public interface ContractOne {
    interface BModel {
        void getListCity();
        ArrayList<City> getList();
        void onConnectBD();
        String answerMediumTepmSeason(City city, String season, Temperature scale);
    }

    interface Presenter {
        void iniField();
        void onGetField();
        void onSelectedCity(City city);
    }

    interface View {
        void showSpinnerCity(ArrayAdapter adapterCity);
        void showTypeCity(String typeCity);
        void showToast(String message);
    }
}
