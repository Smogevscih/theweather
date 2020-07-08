package com.smic.weather;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smic.weather.bmodel.temp.PairTempAndMonth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class PairAdapter extends RecyclerView.Adapter<PairAdapter.PairViewHolder> {
    private static List<PairTempAndMonth> list;

    public static List<PairTempAndMonth> getList() {
        return list;
    }

    public PairAdapter(List<PairTempAndMonth> list) {
        PairAdapter.list = list;
    }


    @NonNull
    @Override
    public PairViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.temp_block, parent, false);

        return new PairViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PairViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setTag(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static final class PairViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtMonth;
        private final EditText etxtValue;


        public PairViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMonth = itemView.findViewById(R.id.txtMonth);
            etxtValue = itemView.findViewById(R.id.etxtValue);
            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    int a = getAdapterPosition();
                    double value = Double.parseDouble(s.toString());
                    list.get(a).setTemp(value);
                }
            };
            etxtValue.addTextChangedListener(textWatcher);
        }

        private void bind(@NonNull PairTempAndMonth pairTempAndMonth) {
            txtMonth.setText(String.valueOf(pairTempAndMonth.getMonth()));
            etxtValue.setText(String.valueOf(pairTempAndMonth.getTemp()));
        }
    }


}
