package com.smic.weather.contracts;

import android.widget.ArrayAdapter;

import com.smic.weather.bmodel.cities.City;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public interface ContractTwo {
    interface BModel {
        void addNewCity(String typeCity);

        void onConnectBD();

        void getListCity();

        ArrayList<City> getList();

        void delCity(City city);
    }

    interface Presenter {
        void onBtnAddNewCity(String typeCity);

        void onGetListCity();

        void onBtnDelCity(City city);

        void iniField();
    }

    interface View {
        void showSpinnerCity(ArrayAdapter adapterCity);
    }
}
