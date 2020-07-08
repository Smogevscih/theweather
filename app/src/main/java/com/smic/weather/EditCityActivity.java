package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.smic.weather.bmodel.FactoryCity;
import com.smic.weather.bmodel.cities.City;
import com.smic.weather.contracts.ContractTwo;
import com.smic.weather.presenters.PresenterTwo;

public class EditCityActivity extends AppCompatActivity implements ContractTwo.View , View.OnClickListener {
    private Button btnAddCity, btnEditTempCity, btnRemoveCity, btnEditCity;
    private Spinner spnCity, spnSizeCity;
    private PresenterTwo presenter;
    private EditText etxtNameCity;
    private String[] typeCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_city);
        presenter = new PresenterTwo(this);
        {
            btnAddCity = findViewById(R.id.btnAddCity);
            btnEditCity = findViewById(R.id.btnUpdateCity);
            btnEditTempCity = findViewById(R.id.btnEditTempCity);
            btnRemoveCity = findViewById(R.id.btnRemoveCity);
            spnCity = findViewById(R.id.spnCity);
            spnSizeCity = findViewById(R.id.spnSizeCity);
            etxtNameCity = findViewById(R.id.etxtNameCity);
        }
        typeCities = FactoryCity.getSizeCities();
        ArrayAdapter<?> adapterSizeCity = new ArrayAdapter(this, R.layout.custom_spinner, typeCities);
        adapterSizeCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSizeCity.setAdapter(adapterSizeCity);
        //заполнение полей
        presenter.onGetListCity();

        btnAddCity.setOnClickListener(this);
        btnEditTempCity.setOnClickListener(this);
        btnEditCity.setOnClickListener(this);
        btnRemoveCity.setOnClickListener(this);

        spnCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                City myCity = (City) spnCity.getSelectedItem();
                if (myCity != null) {
                    String typeCity = myCity.getTypeCity();
                    if (typeCity.equals(typeCities[0])) spnSizeCity.setSelection(0);
                    if (typeCity.equals(typeCities[1])) spnSizeCity.setSelection(1);
                    if (typeCity.equals(typeCities[2])) spnSizeCity.setSelection(2);
                    etxtNameCity.setText(myCity.getName());
                }else{
                    etxtNameCity.setText("null");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showSpinnerCity(ArrayAdapter adapterCity) {
        spnCity.setAdapter(adapterCity);
    }
    @Override
    public void onClick(View v) {
        City city = (City) spnCity.getSelectedItem();
        String typeCity = (String) spnSizeCity.getSelectedItem();
        String nameCity = etxtNameCity.getText().toString();
        switch (v.getId()) {
            case R.id.btnUpdateCity:
                if (city != null)  presenter.onBtnUpdateCity(city,nameCity,typeCity);
                break;
            case R.id.btnAddCity:
                presenter.onBtnAddNewCity(typeCity);
                break;
            case R.id.btnRemoveCity:
                if (city != null) presenter.onBtnDelCity(city);
                break;
            case R.id.btnEditTempCity:
                if (city != null) presenter.onBtnOpenActivityForEditTemp(city);
                    break;
        }
    }
}