package com.liamma.collections.main.ui;

import android.app.Dialog;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.liamma.collections.R;
import com.liamma.collections.dialog.BaseDialogFragment;
import com.liamma.commons.frameworks.mvp.BaseToolsActivity;
import com.liamma.commons.utils.BigDecimalUtils;
import com.liamma.commons.utils.DateTimeUtils;
import com.liamma.commons.utils.LogUtils;
import com.liamma.commons.utils.SpannableEditor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/4/28 9:40
 * DESCRIPTION:
 */
public class TestingActivity extends BaseToolsActivity {

    private TextView tvShowMessage;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_testing;
    }

    @Override
    protected void initView() {
        tvShowMessage = findViewById(R.id.tvShowMessage);
    }

    /**
     * 测试 Logger 的调用。
     */
    private void testLogger() {
        String s = "123";
        LogUtils.i("---> s == " + s);
        LogUtils.d("this is a debug log message.");
    }

    /**
     * 测试 AlertDialog 的展示。
     */
    private void showAlertDialog() {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("Testing Message")
                .show();
    }

    /**
     * 测试 DialogFragment 的使用。
     */
    private void startShowDialogFragment() {
        BaseDialogFragment dialogFragment = new BaseDialogFragment();
        dialogFragment.show(getFragmentManager(), "test");
    }

    /**
     * 测试 BigDecimal 数据格式化。
     */
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

    /**
     * 测试多种不同的字符串拼接方法的速度。
     */
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


        // String formatTimestamp
        for (int i = 0; i < count; i++) {
            result = String.format("我们班%1$s学习成绩最好。", "lily");
        }
        Log.i(TAG, "compareStrings: f3: " + (System.currentTimeMillis() - current));
    }

    /**
     * 测试 BigDecimal 的计算方法。
     */
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
        Log.i(TAG, "testBigDecimal: dd = " + BigDecimalUtils.to8(dd));

        Log.i(TAG, "testBigDecimal: d0 = " + BigDecimalUtils.to8(new BigDecimal(d0)));
        Log.i(TAG, "testBigDecimal: d1 = " + BigDecimalUtils.to8(new BigDecimal(d1)));
        Log.i(TAG, "testBigDecimal: d2 = " + BigDecimalUtils.to8(new BigDecimal(d2)));
        Log.i(TAG, "testBigDecimal: d3 = " + BigDecimalUtils.to8(new BigDecimal(d3)));
        Log.i(TAG, "testBigDecimal: d4 = " + BigDecimalUtils.to8(new BigDecimal(d4)));
        Log.i(TAG, "testBigDecimal: d5 = " + BigDecimalUtils.to8(new BigDecimal(d5)));
        Log.i(TAG, "testBigDecimal: d6 = " + BigDecimalUtils.to8(new BigDecimal(d6)));
        Log.i(TAG, "testBigDecimal: d7 = " + BigDecimalUtils.to8(new BigDecimal(d7)));
    }

    /**
     * 测试 2 个日期的间隔比较。
     */
    private void compareInSecond() {
        String s1 = "2018-08-25 20:47:50";
        int result = DateTimeUtils.formatTimestamp().compareTo(s1);

        Timestamp timestamp = Timestamp.valueOf(s1);
        long value = timestamp.getTime();

        Log.i(TAG, "compareInSecond: result = " + result);
        Log.i(TAG, "compareInSecond: timestamp = " + timestamp.toString());
        Log.i(TAG, "compareInSecond: value = " + value);

        Log.i(TAG, "compareInSecond: current timestamp = " + System.currentTimeMillis());
    }

    // 使用 Spannable 更改 text 中的文字样式。
    private void changeTextAttr() {
        String text = tvShowMessage.getText().toString();
        SpannableEditor spannableEditor = new SpannableEditor(this, text);
        spannableEditor.setTextSize(24, "test");
        tvShowMessage.setText(spannableEditor.build());
    }

}
