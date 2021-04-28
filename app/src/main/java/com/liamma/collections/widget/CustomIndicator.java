package com.liamma.collections.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.liamma.collections.R;

/**
 * Created by Liam on 2020/7/3.
 */
public class CustomIndicator extends FrameLayout {

    public String[] titles = new String[]{"TAB1001", "TAB1002"};
    private TextView tab1;
    private TextView tab2;
    private View move;

    public CustomIndicator(@NonNull Context context) {
        super(context);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setBackgroundResource(R.drawable.bg_round_blue_stroke);
        addView(linearLayout, new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        tab1 = new TextView(context);
        tab1.setText(titles[0]);
        tab1.setTextSize(15);
        tab1.setTextColor(getResources().getColor(R.color.black));
        tab1.setGravity(Gravity.CENTER);
        linearLayout.addView(tab1, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));

        tab2 = new TextView(context);
        tab2.setText(titles[0]);
        tab2.setTextSize(15);
        tab2.setTextColor(getResources().getColor(R.color.black));
        tab2.setGravity(Gravity.CENTER);
        linearLayout.addView(tab2, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));

        move = new View(context);
        move.setBackgroundResource(R.drawable.bg_round_blue);
        addView(move, new LayoutParams(this.getMeasuredWidth() / 2, LayoutParams.MATCH_PARENT));
    }

}
