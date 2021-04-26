package com.liamma.commons.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.utils.EmptyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/1/4 14:45
 * DESCRIPTION: Base common adapter for ListView.
 */
public class CommonLvAdapter<T> extends BaseAdapter {

    protected Context context;
    @LayoutRes
    protected final int layoutId;
    protected List<T> dataSet;
    protected LayoutInflater layoutInflater;

    public CommonLvAdapter(@NonNull Context context, @LayoutRes int layoutId) {
        this(context, layoutId, null);
    }

    public CommonLvAdapter(@NonNull Context context, @LayoutRes int layoutId, @Nullable List<T> dataSet) {
        this.context = context;
        this.layoutId = layoutId;
        this.dataSet = dataSet == null ? new ArrayList<>() : dataSet;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setDataSet(@Nullable List<T> dataSet) {
        if (dataSet == null) return;
        this.dataSet = dataSet;
        this.notifyDataSetChanged();
    }

    public void addDataSet(@Nullable List<T> dataSet) {
        if (EmptyUtils.isEmpty(dataSet)) return;
        // Question: It seems that listView adapter doesn't support updating part of data set.
        //int addStartIndex = this.dataSet.size();
        this.dataSet.addAll(dataSet);
        this.notifyDataSetChanged();
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
