package com.liamma.commons.base.adapter;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liam on 2019/1/4
 */
public abstract class ListViewAdapter<T> extends BaseAdapter {

    protected List<T> dataSet = new ArrayList<>();


}
