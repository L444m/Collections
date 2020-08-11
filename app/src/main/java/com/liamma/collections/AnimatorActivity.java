package com.liamma.collections;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liamma.commons.utils.LogUtils;

import okhttp3.internal.Util;

public class AnimatorActivity extends AppCompatActivity {

    private ImageView vIndicator;
    private RelativeLayout rlTabs;
    private TextView tab1;
    private TextView tab2;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private Indicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        vIndicator = findViewById(R.id.v_animator_move);
        rlTabs = findViewById(R.id.rl_animator_tabs);
        tab1 = findViewById(R.id.tv_animator_tab1);
        tab2 = findViewById(R.id.tv_animator_tab2);
        viewPager = findViewById(R.id.vp_animator_pager);

        /*Drawable drawable = ContextCompat.getDrawable(this, R.drawable.bg_round_blue);
        vIndicator.setBackground(drawable);*/

        indicator = new Indicator(this, viewPager);
        rlTabs.addView(indicator, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        tab1.bringToFront();
        tab2.bringToFront();

        initViewPager();

        indicator.setCurrentPosition(0);

        /*textView = findViewById(R.id.tvAnimator);
        textView.setOnClickListener(v -> {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 300f);
            objectAnimator.setDuration(2000);
            objectAnimator.start();
        });*/


    }

    private void initViewPager() {
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = new ImageView(AnimatorActivity.this);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                if (position == 0) {
                    imageView.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    imageView.setBackgroundColor(getResources().getColor(R.color.red));
                }
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                ImageView imageView = (ImageView) object;
                container.removeView(imageView);
            }
        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //vIndicator.scrollTo((int) ((tab2.getLeft() - tab1.getLeft()) * positionOffset), tab1.getTop());
                indicator.setOffset(positionOffset, position);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class Indicator extends View {

        private Context context;
        private ViewPager viewPager;

        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private RectF rect = new RectF();
        private float progress;
        private int currentPosition;
        private int scrollPosition;

        public Indicator(Context context, ViewPager viewPager) {
            super(context);
            this.context = context;
            this.viewPager = viewPager;
        }

        public void setCurrentPosition(int currentPosition) {
            this.currentPosition = currentPosition;
            invalidate();
        }

        public void setOffset(float offset, int scrollPosition) {
            progress = offset;
            this.scrollPosition = scrollPosition;
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            paint.setColor(getResources().getColor(R.color.blue));
            currentPosition = viewPager.getCurrentItem();
            float left = currentPosition * Utils.dip2px(context, 150);

            if (progress != 0) {
                if (scrollPosition >= currentPosition) {
                    left = left + Utils.dip2px(context, 150) * progress;
                    rect.set(left, 0, left + Utils.dip2px(context, 150), Utils.dip2px(context, 50));
                } else {
                    left = left - Utils.dip2px(context, 150) * (1.0f - progress);
                    rect.set(left, 0, left + Utils.dip2px(context, 150), Utils.dip2px(context, 50));
                }
            } else {
                rect.set(left, 0, left + Utils.dip2px(context, 150), Utils.dip2px(context, 50));
            }
            canvas.drawRoundRect(rect, Utils.dip2px(context, 25), Utils.dip2px(context, 25), paint);
        }
    }
}
