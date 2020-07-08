package com.smic.weather.contracts;

import android.widget.ArrayAdapter;

import com.smic.weather.bmodel.City;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public interface ContractOne {
    interface BModel {
        void getListCity();
        ArrayList<City> getList();
    }

    interface Presenter {
        void iniField();

    }

    interface View {
        void showSpinnerCity(ArrayAdapter adapterCity);
    }
}
