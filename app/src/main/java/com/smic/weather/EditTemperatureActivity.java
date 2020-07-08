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
    Button btnSave, btnBack, btnReset;

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
            btnBack = findViewById(R.id.btnBack);
            btnReset = findViewById(R.id.btnReset);
        }

        id = getIntent().getIntExtra("key", 0);
        presenter.onInitField(id);

        btnSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSave:
                presenter.onBtnSave(PairAdapter.getList());
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnReset:
                presenter.onInitField(id);
                break;

        }
    }

    @Override
    public void showTempAndMonth(PairAdapter pairAdapter) {
        recyclerView.setAdapter(pairAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showTitle(String title) {
        setTitle(title);
    }

}