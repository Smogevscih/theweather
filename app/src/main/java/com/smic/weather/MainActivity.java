package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.smic.weather.contracts.ContractOne;
import com.smic.weather.presenters.PresenterOne;

public class MainActivity extends AppCompatActivity implements ContractOne.View {
    private Button button, button2, button3;
    private Spinner spinner1, spinner2, spnModeScale;
    private TextView txtTypeCity, txtAnswer;
    PresenterOne presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new PresenterOne(this);
        {
            button = findViewById(R.id.button);
            button2 = findViewById(R.id.button2);
            button3 = findViewById(R.id.button3);
            spinner1 = findViewById(R.id.spinner1);
            spinner2 = findViewById(R.id.spinner2);
            spnModeScale = findViewById(R.id.spnModeScale);
            txtTypeCity = findViewById(R.id.txtTypeCity);
            txtAnswer = findViewById(R.id.txtAnswer);
        }
    }

    @Override
    public void showSpinnerCity(ArrayAdapter adapterCity) {
        spinner1.setAdapter(adapterCity);
    }
}