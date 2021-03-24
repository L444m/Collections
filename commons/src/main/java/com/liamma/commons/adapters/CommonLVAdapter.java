package com.liamma.commons.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/1/4 14:45
 * DESCRIPTION: Base common adapter for ListView.
 */
public class CommonLVAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> dataSet;

    public CommonLVAdapter(Context context) {
        this(context, null);
    }

    public CommonLVAdapter(Context context, List<T> dataSet) {
        this.context = context;
        this.dataSet = dataSet == null ? new ArrayList<>() : dataSet;
    }

    public void setDataSet(List<T> dataSet) {
        if (dataSet == null) {
            return;
        }
        this.dataSet = dataSet;
    }

    @Override
    public int getCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
