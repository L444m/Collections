package com.liamma.collections;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liamma.collections.event.MessageEvent;
import com.liamma.collections.event.MessageEvent2;
import com.liamma.commons.frameworks.base.BaseTitleActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class SecondActivity extends BaseTitleActivity {

    private static final String TAG = "SecondActivity";

    TextView tvShowMsg;

    Button btnStart;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
        super.initView();
        btnStart.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        switch (view.getId()) {
            case R.id.btn_second_start:
                Log.i(TAG, "onClick: btnStart post event.");
                EventBus.getDefault().post(new MessageEvent("test"));
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void doSomething(MessageEvent2 event2) {
        // nothing.
        Log.i(TAG, "doSomething: if this would receive.");
    }

}
