package com.liamma.commons.adapters;

import android.view.View;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/4/26 16:03
 * DESCRIPTION:
 */
public interface CommonAdapterListeners {

    interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T t);
    }

    interface OnItemLongClickListener<T> {
        void onItemLongClick(View view, int position, T t);
    }

}
