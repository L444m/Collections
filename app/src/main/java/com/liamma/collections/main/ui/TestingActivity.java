package com.liamma.collections.main.ui;

import android.app.Dialog;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.liamma.collections.R;
import com.liamma.collections.dialog.BaseDialogFragment;
import com.liamma.commons.frameworks.mvp.BaseToolsActivity;
import com.liamma.commons.log.LogUtils;
import com.liamma.commons.utils.DateTimeUtils;
import com.liamma.commons.utils.SpannableEditor;

import java.math.BigDecimal;
import java.sql.Timestamp;

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

    @Override
    protected void initData() {
        testBigDecimal();
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
        int a = 101;
        long b = 1005325L;
        float c = 101.786512f;      // 101.7865142822265625
        double d = 101.1234567890d; // 101.1234567890000022316598915494978427886962890625
        String s = "101.1234567890";

        BigDecimal bd1 = new BigDecimal(a);
        BigDecimal bd2 = new BigDecimal(b);
        BigDecimal bd3 = new BigDecimal(c);     // use double
        BigDecimal bd4 = new BigDecimal(d);
        BigDecimal bd5 = new BigDecimal(s);

        LogUtils.d("int bd1 = " + bd1.toPlainString());
        LogUtils.d("long bd2 = " + bd2.toPlainString());
        LogUtils.d("float bd3 = " + bd3.toPlainString());
        LogUtils.d("double bd4 = " + bd4.toPlainString());
        LogUtils.d("string bd5 = " + bd5.toPlainString());

        /*double dd = 123123123.456456456456D;
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
        Log.i(TAG, "testBigDecimal: d7 = " + BigDecimalUtils.to8(new BigDecimal(d7)));*/
    }

    /**
     * 测试 2 个日期的间隔比较。
     */
    private void compareInSecond() {
        String s1 = "2018-08-25 20:47:50";
        int result = DateTimeUtils.formatTimestamp(System.currentTimeMillis()).compareTo(s1);

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
