package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.smic.weather.bmodel.City;
import com.smic.weather.contracts.ContractTwo;
import com.smic.weather.presenters.PresenterTwo;

public class EditCityActivity extends AppCompatActivity implements ContractTwo.View , View.OnClickListener {
    private Button btnAddCity, btnEditTempCity, btnRemoveCity, btnEditCity;
    private Spinner spnCity, spnSizeCity;
    private PresenterTwo presenter;
    private EditText etxtNameCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_city);
        presenter = new PresenterTwo(this);
        {
            btnAddCity = findViewById(R.id.btnAddCity);
            btnEditCity = findViewById(R.id.btnEditCity);
            btnEditTempCity = findViewById(R.id.btnEditTempCity);
            btnRemoveCity = findViewById(R.id.btnRemoveCity);
            spnCity = findViewById(R.id.spnCity);
            spnSizeCity = findViewById(R.id.spnSizeCity);
            etxtNameCity = findViewById(R.id.etxtNameCity);
        }
        //заполнение полей
        presenter.onGetListCity();

        btnAddCity.setOnClickListener(this);
        btnEditTempCity.setOnClickListener(this);
        btnEditCity.setOnClickListener(this);
        btnRemoveCity.setOnClickListener(this);

    }

    @Override
    public void showSpinnerCity(ArrayAdapter adapterCity) {
        spnCity.setAdapter(adapterCity);
    }
    @Override
    public void onClick(View v) {
        City city = (City) spnCity.getSelectedItem();

        switch (v.getId()) {
            case R.id.btnEditCity:

                break;
            case R.id.btnAddCity:

                break;
            case R.id.btnRemoveCity:
                if (city != null) presenter.onBtnDelCity(city);
                break;
            case R.id.btnEditTempCity:

                break;
        }
    }
}