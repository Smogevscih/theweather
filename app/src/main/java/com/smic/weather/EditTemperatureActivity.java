package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smic.weather.presenters.PresenterThree;

public class EditTemperatureActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnSave;
    EditText etxtValue;
    TextView txtMonth;
    PresenterThree presenter;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_temperature);
    }

}