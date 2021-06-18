package com.liamma.commons.frameworks.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liamma.commons.R;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2018/07/12 15:43
 * DESCRIPTION: Base activity with title bar function.
 */
public abstract class BaseTitleActivity extends BaseActivity {

    private FrameLayout flTitleBar;
    private ImageView ivLeftImage;
    private TextView tvLeftText;
    private LinearLayout llTitles;
    private TextView tvTitle;
    private TextView tvSubTitle;
    private LinearLayout llRightMenu;
    private TextView tvRightText;
    private ImageView ivRightImage;
    private ProgressBar pbProgress;
    private FrameLayout flBaseContainer;

    @Override
    protected void initContentView() {
        validateLayoutId();
        setContentView(R.layout.common_activity_base_title);
        addLayoutView();
        initBaseView();
        initBaseListeners();
    }

    /**
     * Add a content view into this layout.
     */
    protected void addLayoutView() {
        flBaseContainer = findViewById(R.id.flBaseContainer);
        View view = LayoutInflater.from(this).inflate(getLayoutId(), flBaseContainer, false);
        flBaseContainer.addView(view);
    }

    protected void initBaseView() {
        flTitleBar = findViewById(R.id.flTitleBar);
        ivLeftImage = findViewById(R.id.ivLeftImage);
        tvLeftText = findViewById(R.id.tvLeftText);
        llTitles = findViewById(R.id.llTitles);
        tvTitle = findViewById(R.id.tvTitle);
        tvSubTitle = findViewById(R.id.tvSubTitle);
        llRightMenu = findViewById(R.id.llRightMenu);
        tvRightText = findViewById(R.id.tvRightText);
        ivRightImage = findViewById(R.id.ivRightImage);
        pbProgress = findViewById(R.id.pbProgress);
    }

    protected void initBaseListeners() {
        ivLeftImage.setOnClickListener(this);
        tvLeftText.setOnClickListener(this);
        tvRightText.setOnClickListener(this);
        ivRightImage.setOnClickListener(this);
    }

    @Override
    protected void onSafeClick(View v) {
        super.onSafeClick(v);
        int id = v.getId();
        if (id == R.id.ivLeftImage) {
            onLeftImageClicked(v);
        } else if (id == R.id.tvLeftText) {
            onLeftTextClicked(v);
        } else if (id == R.id.tvRightText) {
            onRightTextClicked(v);
        } else if (id == R.id.ivRightImage) {
            onRightImageClicked(v);
        }
    }

    private void onLeftImageClicked(final View view) {
        onBackPressed();
    }

    private void onLeftTextClicked(final View view) {
    }

    private void onRightTextClicked(final View view) {
    }

    private void onRightImageClicked(final View view) {
    }

    public FrameLayout getBaseContainer() {
        return flBaseContainer;
    }

    public FrameLayout getTitleBar() {
        return flTitleBar;
    }

    public LinearLayout getRightMenu() {
        return llRightMenu;
    }

}
