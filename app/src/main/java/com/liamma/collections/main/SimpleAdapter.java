package com.liamma.collections.main;

import android.content.Context;

import androidx.annotation.NonNull;

import com.liamma.commons.base.adapter.RecyclerViewAdapter;
import com.liamma.commons.base.adapter.RecyclerViewHolder;


/**
 * Uses {@code android.R.layout.simple_list_item_1} to display a simple string data.
 * Created by Liam on 2019/1/4
 */
public class SimpleAdapter extends RecyclerViewAdapter<String> {

    public SimpleAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }

    @Override
    protected void onBind(RecyclerViewHolder holder, String s, int position) {

    }
}
