package com.liamma.commons.adapters;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/4/27 14:19
 * DESCRIPTION:
 */
public interface IBaseAdapter {

    int getCount();

    Object getItem(int position);

    long getItemId(int position);

    View getView(int position, View convertView, ViewGroup parent);

}
