package com.liamma.collections.main.ui;

import com.liamma.collections.R;
import com.liamma.commons.frameworks.mvp.BaseToolsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/4/28 12:21
 * DESCRIPTION:
 */
public class SpinnerActivity extends BaseToolsActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_spinner;
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
        //spinner.setDataSet(strings);

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

}
