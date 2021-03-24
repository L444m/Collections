package com.liamma.commons.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/1/4 14:32
 * DESCRIPTION: Base ViewHolder for ListView or RecyclerView.
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

    public View getItemView() {
        return itemView;
    }

    public BaseViewHolder setText(@IdRes int viewId, @NonNull CharSequence sequence) {
        TextView textView = getView(viewId);
        textView.setText(sequence);
        return this;
    }

    public BaseViewHolder setText(@IdRes int viewId, @StringRes int resId) {
        TextView textView = getView(viewId);
        textView.setText(resId);
        return this;
    }

    public BaseViewHolder setButtonText(@IdRes int viewId, @NonNull CharSequence sequence) {
        Button button = getView(viewId);
        button.setText(sequence);
        return this;
    }

    public BaseViewHolder setButtonText(@IdRes int viewId, @StringRes int resId) {
        Button button = getView(viewId);
        button.setText(resId);
        return this;
    }

    public BaseViewHolder setImageResource(@IdRes int viewId, @DrawableRes int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public BaseViewHolder setImageBitmap(@IdRes int viewId, @NonNull Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(@IdRes int viewId, @NonNull Drawable drawable) {
        ImageView imageView = getView(viewId);
        imageView.setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setBackgroundRes(@IdRes int viewId, @DrawableRes int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        TextView textView = getView(viewId);
        textView.setTextColor(color);
        return null;
    }

    public BaseViewHolder setVisible(@IdRes int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public BaseViewHolder setOnClickListener(@IdRes int viewId, @NonNull View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(@IdRes int viewId, @NonNull View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnTouchListener(@IdRes int viewId, @NonNull View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public BaseViewHolder setOnItemClickListener(@IdRes int viewId, @NonNull AdapterView.OnItemClickListener listener) {
        AdapterView adapterView = getView(viewId);
        adapterView.setOnItemClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnItemLongClickListener(@IdRes int viewId, @NonNull AdapterView.OnItemLongClickListener listener) {
        AdapterView adapterView = getView(viewId);
        adapterView.setOnItemLongClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnItemSelectedClickListener(@IdRes int viewId, @NonNull AdapterView.OnItemSelectedListener listener) {
        AdapterView adapterView = getView(viewId);
        adapterView.setOnItemSelectedListener(listener);
        return this;
    }

}
