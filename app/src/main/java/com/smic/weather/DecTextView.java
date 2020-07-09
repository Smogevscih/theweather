package com.smic.weather;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

/**
 * @autor Smogevscih Yuri
 * 09.07.2020
 **/
public class DecTextView extends androidx.appcompat.widget.AppCompatTextView {

    private TextView textView;
    private final String TAG = "DEC_TEXTVIEW";

    public DecTextView(Context context, TextView textView) {
        super(context);
        this.textView = textView;

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (textView != null) textView.setText(text, type);
        Log.d(TAG, text.toString());
    }
}
