package com.liamma.collections.main.ui;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liamma.collections.R;
import com.liamma.commons.frameworks.mvp.BaseToolsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for testing RecyclerView.
 */
public class RecyclerActivity extends BaseToolsActivity {

    private RecyclerView rvList;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_recycler;
    }

    @Override
    protected void initView() {
        rvList = findViewById(R.id.rvList);
        initRecyclerView();
    }

    /**
     * 初始化 RecyclerView.
     */
    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        DividerItemDecoration did = new DividerItemDecoration(this, llm.getOrientation());
        rvList.setLayoutManager(llm);
        rvList.addItemDecoration(did);
        rvList.setItemAnimator(new DefaultItemAnimator());
        /*CommonRvAdapter<String> adapter =
                new CommonRvAdapter<String>(this, R.layout.main_list_item_simple_string) {
                    @Override
                    protected void onBind(RecyclerViewHolder holder, String s, int position) {
                        holder.setText(R.id.tv_simple_string_text, s);
                    }
                };

        // string data
        List<String> dataSet = new ArrayList<>();
        dataSet.add("first");
        dataSet.add("second");
        dataSet.add("third");
        dataSet.add("fourth");
        dataSet.add("fifth");

        // adapter 设置数据 before setAdapter.
        // simpleStringAdapter.setDataSet(dataSet);
        rvList.setAdapter(adapter);

        // adapter 设置数据 after setAdapter .
        adapter.setDataSet(dataSet);*/
    }

}
