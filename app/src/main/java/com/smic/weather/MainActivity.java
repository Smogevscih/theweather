package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.smic.weather.contracts.ContractOne;
import com.smic.weather.presenters.PresenterOne;

public class MainActivity extends AppCompatActivity implements ContractOne.View, View.OnClickListener {
    private Button btnConnectBD, btnEditCity, btnGetListFromBD;
    private Spinner spnCity, spnSeason, spnModeScale;
    private TextView txtTypeCity, txtAnswer;
    PresenterOne presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PresenterOne(this);
        {
            btnConnectBD = findViewById(R.id.btnConnectBD);
            btnEditCity = findViewById(R.id.btnEditCity);
            btnGetListFromBD = findViewById(R.id.btnGetListFromBD);
            spnCity = findViewById(R.id.spnCity);
            spnSeason = findViewById(R.id.spnSeason);
            spnModeScale = findViewById(R.id.spnModeScale);
            txtTypeCity = findViewById(R.id.txtTypeCity);
            txtAnswer = findViewById(R.id.txtAnswer);
        }
        {
            ArrayAdapter<?> adapterSeasons = ArrayAdapter.createFromResource(this, R.array.seasons, android.R.layout.simple_spinner_item);
            adapterSeasons.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnSeason.setAdapter(adapterSeasons);
            adapterSeasons = ArrayAdapter.createFromResource(this, R.array.scale, android.R.layout.simple_spinner_item);
            adapterSeasons.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnModeScale.setAdapter(adapterSeasons);
        }
        btnConnectBD.setOnClickListener(this);
        btnEditCity.setOnClickListener(this);
        btnGetListFromBD.setOnClickListener(this);
    }

    @Override
    public void showSpinnerCity(ArrayAdapter adapterCity) {
        spnCity.setAdapter(adapterCity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConnectBD:
                presenter.onGetField();
                break;
            case R.id.btnEditCity:


                break;
            case R.id.btnGetListFromBD:

                break;
        }
    }
}