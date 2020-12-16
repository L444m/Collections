package com.liamma.commons.adapters;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.IdRes;

/**
 * Created by Liam on 2019/1/4
 */
public abstract class BaseViewHolder {

    // The view of a single item in ListView or RecyclerView.
    protected View itemView;

    // All views indexed with their IDs.
    protected SparseArray<View> views;

    public BaseViewHolder(View itemView) {
        this.itemView = itemView;
        this.views = new SparseArray<>();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

}
