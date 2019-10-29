package com.liamma.commons.base.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView Holder for all RecyclerView.
 * Created by Liam on 2018/7/31
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    // All views indexed with their Ids.
    private SparseArray<View> views;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.views = new SparseArray<>();
    }

    /**
     * An easy way to get a RecyclerViewHolder.
     *
     * @param parent   Parent Layout
     * @param layoutId Layout resource Id
     * @param <T>      View type
     * @return RecyclerViewHolder instance
     */
    @SuppressWarnings("unchecked")
    public static <T extends RecyclerViewHolder> T getHolder(@NonNull ViewGroup parent,
                                                             @LayoutRes int layoutId) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return (T) new RecyclerViewHolder(view);
    }

    /**
     * Gets a view according to the specified ViewId.
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * Returns the itemView.
     */
    public View getItemView() {
        return itemView;
    }

    /**
     * Sets the text of a TextView.
     *
     * @param viewId   View Id
     * @param sequence CharSequence
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setText(@IdRes int viewId, @NonNull CharSequence sequence) {
        TextView textView = getView(viewId);
        textView.setText(sequence);
        return this;
    }

    /**
     * Sets the text of a TextView.
     *
     * @param viewId View Id
     * @param resId  String resource Id
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setText(@IdRes int viewId, @StringRes int resId) {
        TextView textView = getView(viewId);
        textView.setText(resId);
        return this;
    }

    /**
     * Sets the text of a Button.
     *
     * @param viewId   View Id
     * @param sequence CharSequence
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setButtonText(@IdRes int viewId, @NonNull CharSequence sequence) {
        Button button = getView(viewId);
        button.setText(sequence);
        return this;
    }

    /**
     * Sets the text of a Button.
     *
     * @param viewId View Id
     * @param resId  String resource Id
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setButtonText(@IdRes int viewId, @StringRes int resId) {
        Button button = getView(viewId);
        button.setText(resId);
        return this;
    }

    /**
     * Sets the image of a ImageView from a Drawable resource Id.
     *
     * @param viewId View Id
     * @param resId  Image resource Id
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setImageResource(@IdRes int viewId, @DrawableRes int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    /**
     * Set the image of a ImageView from a Bitmap object.
     *
     * @param viewId View Id
     * @param bitmap Bitmap
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setImageBitmap(@IdRes int viewId, @NonNull Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    /**
     * Sets the image of a ImageView from a Drawable object.
     *
     * @param viewId   View Id
     * @param drawable Drawable
     * @return This instance for chain invoke
     */
    public RecyclerViewHolder setImageDrawable(@IdRes int viewId, @NonNull Drawable drawable) {
        ImageView imageView = getView(viewId);
        imageView.setImageDrawable(drawable);
        return this;
    }

    public RecyclerViewHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public RecyclerViewHolder setBackgroundRes(@IdRes int viewId, @DrawableRes int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
        return this;

    }

    public RecyclerViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        TextView textView = getView(viewId);
        textView.setTextColor(color);
        return null;
    }

    public RecyclerViewHolder setVisible(@IdRes int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public RecyclerViewHolder setOnClickListener(@IdRes int viewId,
                                                 @NonNull View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public RecyclerViewHolder setOnLongClickListener(@IdRes int viewId,
                                                     @NonNull View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    public RecyclerViewHolder setOnTouchListener(@IdRes int viewId,
                                                 @NonNull View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public RecyclerViewHolder setOnItemClickListener(@IdRes int viewId,
                                                     @NonNull AdapterView.OnItemClickListener listener) {
        AdapterView adapterView = getView(viewId);
        adapterView.setOnItemClickListener(listener);
        return this;
    }

    public RecyclerViewHolder setOnItemLongClickListener(@IdRes int viewId,
                                                         @NonNull AdapterView.OnItemLongClickListener listener) {
        AdapterView adapterView = getView(viewId);
        adapterView.setOnItemLongClickListener(listener);
        return this;
    }

    public RecyclerViewHolder setOnItemSelectedClickListener(@IdRes int viewId,
                                                             @NonNull AdapterView.OnItemSelectedListener listener) {
        AdapterView adapterView = getView(viewId);
        adapterView.setOnItemSelectedListener(listener);
        return this;
    }

}
