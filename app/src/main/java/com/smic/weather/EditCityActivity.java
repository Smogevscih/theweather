package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.smic.weather.contracts.ContractTwo;
import com.smic.weather.presenters.PresenterTwo;

public class EditCityActivity extends AppCompatActivity implements ContractTwo.View {
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
        presenter.onGetListCity();

    }

    @Override
    public void showSpinnerCity(ArrayAdapter adapterCity) {
        spnCity.setAdapter(adapterCity);
    }
}