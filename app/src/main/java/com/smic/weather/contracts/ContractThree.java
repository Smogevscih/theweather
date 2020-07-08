package com.smic.weather.contracts;

import android.widget.ArrayAdapter;

import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.temp.Temperature;

import java.util.ArrayList;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public interface ContractThree {
    interface BModel {
        void getListCity();

        ArrayList<City> getList();

        void onConnectBD();

    }

    interface Presenter {

    }

    interface View {

    }
}
