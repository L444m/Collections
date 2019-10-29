package com.liamma.collections;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liamma.collections.dialog.BaseDialogFragment;
import com.liamma.collections.event.MessageEvent;
import com.liamma.collections.widget.CustomSpinner;
import com.liamma.commons.base.BaseToolsActivity;
import com.liamma.commons.base.adapter.RecyclerViewAdapter;
import com.liamma.commons.base.adapter.RecyclerViewHolder;
import com.liamma.commons.common.SpannableEditor;
import com.liamma.commons.utils.DateTimeUtils;
import com.liamma.commons.utils.FormatUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseToolsActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.ll_layout)
    LinearLayout linearLayout;

    @BindView(R.id.tv_main_msg)
    TextView showMessage;

    @BindView(R.id.btn_main_start)
    Button start;

    @BindView(R.id.sp_main_spinner)
    CustomSpinner<String> spinner;

    @BindView(R.id.rv_main_list)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        start.setOnClickListener(this);

        // lambda
        // start.setOnClickListener(v -> ToastUtils.showShort(MainActivity.this, "click"));
        // showMessage.setText("testDataColor");
    }

    @Override
    protected void initData() {
        // setNormalSpinner();
        initRecyclerView();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        int id = view.getId();
        switch (id) {
            case R.id.btn_main_start:

                // Toast.makeText(this, "功能正常", Toast.LENGTH_LONG).show();
                // changeTextAttr();

                // Logger.d("testing message.");
                // Intent intent = new Intent(this, StatusMode.class);
                // startActivity(intent);

                // startShowDialogFragment();

                // testDoubleDecimal();
                testBigDecimal();

                break;
            default:
                break;
        }
    }

    // 初始化 RecyclerView .
    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        DividerItemDecoration did = new DividerItemDecoration(this, llm.getOrientation());
        recyclerView.setLayoutManager(llm);
        recyclerView.addItemDecoration(did);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerViewAdapter<String> adapter =
                new RecyclerViewAdapter<String>(this, R.layout.main_list_item_simple_string) {
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

        // adapter 设置数据 before setAdapter .
        // simpleStringAdapter.setDataSet(dataSet);
        recyclerView.setAdapter(adapter);


        // adapter 设置数据 after setAdapter .
        adapter.setDataSet(dataSet);
    }

    private void testDoubleDecimal() {
        float ff = 1056.12345678901234567899F;
        double ss = 1056.12345678901234567899D;
        // Log.i(TAG, "testDoubleDecimal: " + String.valueOf(ff));
        // Log.i(TAG, "testDoubleDecimal: " + String.valueOf(ss));

        BigDecimal big = new BigDecimal("1056.12345678901234567899");

        DecimalFormat df2 = new DecimalFormat("0.00");
        DecimalFormat df4 = new DecimalFormat("0.0000");
        DecimalFormat df6 = new DecimalFormat("0.000000");

        Log.i(TAG, df2.format(big.setScale(2, RoundingMode.DOWN)));
        Log.i(TAG, df4.format(big.setScale(2, RoundingMode.DOWN)));
        Log.i(TAG, df6.format(big.setScale(2, RoundingMode.DOWN)));
    }

    private void startShowDialogFragment() {
        BaseDialogFragment dialogFragment = new BaseDialogFragment();
        dialogFragment.show(getFragmentManager(), "test");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if ("test".equals(event.message)) {
            Log.i(TAG, "onMessageEvent: deal with event.");
            showMessage.setText("message has changed by second.");
        }
    }

    private void showAlertDialog() {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("Testing Message")
                .show();
    }

    private void compareInSecond() {

        String s1 = "2018-08-25 20:47:50";
        int result = DateTimeUtils.format().compareTo(s1);

        Timestamp timestamp = Timestamp.valueOf(s1);
        long value = timestamp.getTime();

        Log.i(TAG, "compareInSecond: result = " + result);
        Log.i(TAG, "compareInSecond: timestamp = " + timestamp.toString());
        Log.i(TAG, "compareInSecond: value = " + value);

        Log.i(TAG, "compareInSecond: current timestamp = " + System.currentTimeMillis());
    }

    private void copyToClipBorad(String content) {
        ClipboardManager cbm = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        if (cbm == null) return;
        cbm.setPrimaryClip(ClipData.newPlainText(null, content));

    }

    private void setNormalSpinner() {
        final List<String> strings = new ArrayList<>();
        strings.add("星期一");
        strings.add("星期二");
        strings.add("星期三");
        strings.add("星期四");
        strings.add("星期五");
        strings.add("星期六");
        strings.add("星期天");

        // use default item view.

        // R.layout.my_spinner_item
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, strings);
        spinner.setDataSet(strings);

        /*
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 去掉 spinner 的背景色及边框
        spinner.setBackgroundColor(0x0);
        spinner.setAdapter(adapter);
        spinner.setPopupBackgroundResource(R.drawable.rounded_white_r5);
        spinner.setDropDownVerticalOffset(DensityUtils.dp2px(this, 23));


        // set listener of spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, strings.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        */


        //        Spinner spinner = new Spinner(this, Spinner.MODE_DROPDOWN);
//        spinner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//
//        linearLayout.addView(spinner);


//        spinner.setDropDownHorizontalOffset(spinner.getWidth());

//        int height = spinner.getHeight();
//        Logger.d("spinner height : " + height);
//        spinner.setDropDownVerticalOffset(-(spinner.getHeight()));
//
//        spinner.setPopupBackgroundResource(R.drawable.rounded_white_r5);
//        spinner.setAdapter(arrayAdapter);
    }

    // 使用 Spannable 更改 text 中的文字样式。
    private void changeTextAttr() {
        String text = showMessage.getText().toString();
        SpannableEditor spannableEditor = new SpannableEditor(this, text);
        spannableEditor.setTextSize(24, "test");
        showMessage.setText(spannableEditor.build());
    }

    // 测试多种不同的字符串拼接方法的速度。
    private void compareStrings() {
        int count = 10000;

        String result;
        long current = System.currentTimeMillis();

        // string concat
        for (int i = 0; i < count; i++) {
            result = "我们班" + "lily" + "学习成绩最好。";
        }
        Log.i(TAG, "compareStrings: f1: " + (System.currentTimeMillis() - current));
        current = System.currentTimeMillis();


        // string builder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("我们班");
            sb.append("lily");
            sb.append("学习成绩最好。");
            result = sb.toString();
        }
        Log.i(TAG, "compareStrings: f2: " + (System.currentTimeMillis() - current));
        current = System.currentTimeMillis();


        // String format
        for (int i = 0; i < count; i++) {
            result = String.format("我们班%1$s学习成绩最好。", "lily");
        }
        Log.i(TAG, "compareStrings: f3: " + (System.currentTimeMillis() - current));
    }

    private void testBigDecimal() {
        double dd = 123123123.456456456456D;
        String d0 = "123123123123123.456456456456";
        String d1 = "123456789.1234567";
        String d2 = "113";
        String d3 = "123456789.7";
        String d4 = "1.45";
        String d5 = "1.1234867";
        String d6 = "0.123456789";
        String d7 = "0.123456789456";

        BigDecimal bigDecimal = new BigDecimal(d5);
        Log.i(TAG, "testBigDecimal: scale = " + bigDecimal.scale());

        BigDecimal bigDecimal1 = new BigDecimal(d6);
        Log.i(TAG, "testBigDecimal: scale1 = " + bigDecimal1.scale());

        Log.i(TAG, "testBigDecimal: dd toString = " + Double.valueOf(dd));
        Log.i(TAG, "testBigDecimal: dd = " + FormatUtils.to8(dd));

        Log.i(TAG, "testBigDecimal: d0 = " + FormatUtils.to8(new BigDecimal(d0)));
        Log.i(TAG, "testBigDecimal: d1 = " + FormatUtils.to8(new BigDecimal(d1)));
        Log.i(TAG, "testBigDecimal: d2 = " + FormatUtils.to8(new BigDecimal(d2)));
        Log.i(TAG, "testBigDecimal: d3 = " + FormatUtils.to8(new BigDecimal(d3)));
        Log.i(TAG, "testBigDecimal: d4 = " + FormatUtils.to8(new BigDecimal(d4)));
        Log.i(TAG, "testBigDecimal: d5 = " + FormatUtils.to8(new BigDecimal(d5)));
        Log.i(TAG, "testBigDecimal: d6 = " + FormatUtils.to8(new BigDecimal(d6)));
        Log.i(TAG, "testBigDecimal: d7 = " + FormatUtils.to8(new BigDecimal(d7)));

    }


}
