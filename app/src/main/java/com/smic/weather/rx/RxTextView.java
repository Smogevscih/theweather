package com.smic.weather.rx;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
public class RxTextView {
    public static Observable<String> textChange(final TextView textView) {
        final PublishSubject<String> subject = PublishSubject.create();
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                subject.onNext(s.toString());
            }
        });

        return subject;
    }
}
