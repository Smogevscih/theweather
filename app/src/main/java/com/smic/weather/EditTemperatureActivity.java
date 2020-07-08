package com.smic.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smic.weather.contracts.ContractThree;
import com.smic.weather.presenters.PresenterThree;

public class EditTemperatureActivity extends AppCompatActivity implements ContractThree.View, View.OnClickListener {
    RecyclerView recyclerView;
    Button btnSave;

    PresenterThree presenter;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_temperature);
        presenter = new PresenterThree(this);
        {
            recyclerView = findViewById(R.id.recyclerView);
            btnSave = findViewById(R.id.btnSave);
        }

        id = getIntent().getIntExtra("key", 0);
        presenter.onInitField(id);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            presenter.onBtnSave(PairAdapter.getList());
        }
    }

    @Override
    public void showTempAndMonth(PairAdapter pairAdapter) {
        recyclerView.setAdapter(pairAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
    }
}