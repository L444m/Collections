package com.liamma.commons.adapters;

import android.content.Context;
import android.view.LayoutInflater;
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
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/7/31 15:55
 * DESCRIPTION: Base adapter for RecyclerView.
 */
public abstract class CommonRvAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Context context;
    private int layoutResId;
    private List<T> dataSet;
    private LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public CommonRvAdapter(@NonNull Context context, @LayoutRes int layoutResId) {
        this(context, layoutResId, null);
    }

    public CommonRvAdapter(@NonNull Context context, @LayoutRes int layoutResId, @Nullable List<T> dataSet) {
        this.context = context;
        this.layoutResId = layoutResId;
        this.dataSet = dataSet == null ? new ArrayList<T>() : dataSet;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
    }

    public void setDataSet(@Nullable List<T> dataSet) {
        if (dataSet == null) return;
        this.dataSet = dataSet;
        this.notifyDataSetChanged();
    }

    public void addDataSet(@Nullable List<T> dataSet) {
        if (EmptyUtils.isEmpty(dataSet)) return;
        int addStartIndex = this.dataSet.size();
        this.dataSet.addAll(dataSet);
        this.notifyItemRangeChanged(addStartIndex, dataSet.size());
    }

    @NonNull
    public List<T> getDataSet() {
        return dataSet;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecyclerViewHolder.getHolder(parent, layoutResId);
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
