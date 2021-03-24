package com.liamma.commons.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.liamma.commons.utils.EmptyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Base adapter for RecyclerView or ListView.
 * Created by Liam on 2018/7/31
 */
public abstract class CommonRVAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Context context;
    private int layoutId;
    private List<T> dataSet;

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public CommonRVAdapter(@NonNull Context context, @NonNull int layoutId) {
        this(context, layoutId, null);
    }

    public CommonRVAdapter(@NonNull Context context, @LayoutRes int layoutId,
                           @Nullable List<T> dataSet) {
        this.context = context;
        this.layoutId = layoutId;
        this.dataSet = dataSet == null ? new ArrayList<T>() : dataSet;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * Get data set.
     */
    @NonNull
    public List<T> getDataSet() {
        return dataSet;
    }

    /**
     * Set new data set.
     */
    public void setDataSet(@Nullable List<T> dataSet) {
        if (dataSet == null) return;
        this.dataSet = dataSet;
    }

    /**
     * Adds data set into this.
     */
    public void addDataSet(@Nullable List<T> dataSet) {
        if (EmptyUtils.isEmpty(dataSet)) return;
        this.dataSet.addAll(dataSet);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecyclerViewHolder.getHolder(parent, layoutId);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        onBind(holder, dataSet.get(position), position);
    }

    private void bindListeners(final RecyclerViewHolder holder, final int position) {
        View view = holder.getItemView();

        view.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, position);
            }
        });

        view.setOnLongClickListener(v -> {
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLongClick(v, position);
                return true;
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    /**
     * SubAdapter 需要实现的数据绑定。
     */
    protected abstract void onBind(RecyclerViewHolder holder, T t, int position);

}
