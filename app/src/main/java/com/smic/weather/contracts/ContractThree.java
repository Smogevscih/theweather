package com.smic.weather.contracts;

import android.widget.ArrayAdapter;

import com.smic.weather.PairAdapter;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.bmodel.temp.PairTempAndMonth;
import com.smic.weather.bmodel.temp.Temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public interface ContractThree {
    interface BModel {

        List<PairTempAndMonth> getListPair(City city);

    }

    interface Presenter {

    }

    interface View {

        void showTempAndMonth(PairAdapter pairAdapter);
    }
}
