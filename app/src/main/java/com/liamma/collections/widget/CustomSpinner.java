package com.liamma.collections.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import com.liamma.collections.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liam on 2018/9/13
 */
public class CustomSpinner<T> extends AppCompatSpinner {

    private Context context;
    private List<T> dataSet;

    // Get a instance for settings.
    private CustomSpinner customSpinner;
    private ArrayAdapter<T> adapter;


    public CustomSpinner(Context context) {
        this(context, null, null);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, null);
    }

    public CustomSpinner(Context context, AttributeSet attrs, List<T> dataSet) {
        super(context, attrs);
        this.context = context;
        this.dataSet = dataSet == null ? new ArrayList<>() : dataSet;

        customSpinner = this;
        setCustomSpinner();
    }

    // Sets dataSet.
    public void setDataSet(List<T> dataSet) {
        this.dataSet = dataSet;

        if (adapter != null) {
            adapter.clear();
            adapter.addAll(dataSet);
            adapter.notifyDataSetChanged();
        }
    }

    // Spinner custom settings.
    private void setCustomSpinner() {
//        customSpinner.setBackgroundColor(0x0);
//        customSpinner.setPopupBackgroundResource(R.drawable.rounded_white_r5);

        // 初始化 adapter 时，这个 TextView 布局
        adapter = new ArrayAdapter<>(context, R.layout.my_spinnner_layout, R.id.tv_my_spinner_text, dataSet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        customSpinner.setAdapter(adapter);
    }


}
