package com.liamma.commons.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * 可以滚动的 ViewPage 指示器。
 * Created by Liam on 2020/7/1.
 */
public class ScrollablePagerIndicator extends FrameLayout implements View.OnClickListener {

    private ArrayList<String> titles;
    private ArrayList<TextView> titleViews;
    private int backgroundColor;
    private int selectedBackgroundColor;
    private int titleColor;
    private int selectedTitleColor;

    private int currentPosition;

    public ScrollablePagerIndicator(@NonNull Context context) {
        this(context, new ArrayList<String>());
    }

    public ScrollablePagerIndicator(@NonNull Context context, ArrayList<String> titles) {
        super(context);
        this.titles = titles;
        this.setBackgroundColor(backgroundColor);

        for (int i = 0; i < titles.size(); i++) {
            TextView textView = new TextView(context);
            textView.setTextSize(15);
            textView.setTextColor(titleColor);
            textView.setOnClickListener(this);
            titleViews.add(textView);
        }
    }

    @Override
    public void onClick(View v) {
        TextView textView;
        for (int i = 0; i < titleViews.size(); i++) {
            textView = titleViews.get(i);
            if (v == textView) {

            }
        }
    }
}
