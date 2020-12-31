package com.liamma.commons.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;


/**
 * Spannable editor, which is used to modify styles of parts of text string.
 * Created by Liam on 2018/4/26.
 */
public final class SpannableEditor {

    private Context context;
    private String text;
    private SpannableStringBuilder builder;

    public SpannableEditor(@NonNull Context context, @NonNull CharSequence text) {
        this.context = context;
        this.text = text.toString();
        builder = new SpannableStringBuilder(text);
    }

    /**
     * @return SpannableStringBuilder, invokes this method after all Spans have been set.
     */
    public SpannableStringBuilder build() {
        return builder;
    }

    // Sets span from start to end.
    private void setSpan(Object span, int start, int end) {
        builder.setSpan(span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    // Sets span with string array.
    private void setSpan(Object span, String... subTextArray) {
        for (String subText : subTextArray) {
            int start = 0;
            int end = 0;

            while ((start = this.text.indexOf(subText, end)) != -1) {
                end = start + subText.length();
                setSpan(span, start, end);
            }
        }
    }

    /**
     * Sets text color from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextColor(@ColorInt int textColor, int start, int end) {
        setSpan(new ForegroundColorSpan(textColor), start, end);
        return this;
    }

    /**
     * Sets text color of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    /*public SpannableEditor setTextColor(@ColorInt int textColor, String... subTextArray) {
        setSpan(new ForegroundColorSpan(textColor), subTextArray);
        return this;
    }*/


    public SpannableEditor setTextColor(int textColor, String... subTextArray) {
        int begin = 0;
        int end = 0;

        for (String subText : subTextArray) {
            begin = this.text.indexOf(subText, end);
            end = begin + subText.length();
            builder.setSpan(new ForegroundColorSpan(textColor), begin, end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return this;
    }

    /**
     * Sets text size from {@code start} to {@code end}. {@code textSize} in physical pixels.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextSize(int textSize, int start, int end) {
        setSpan(new AbsoluteSizeSpan(textSize), start, end);
        return this;
    }

    /**
     * Sets text size of part(s) of string. {@code textSize} in physical pixels.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextSize(int textSize, String... subTextArray) {
        setSpan(new AbsoluteSizeSpan(textSize), subTextArray);
        return this;
    }

    /**
     * Sets text's background color from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBgColor(@ColorInt int textBgColor, int start, int end) {
        setSpan(new BackgroundColorSpan(textBgColor), start, end);
        return this;
    }

    /**
     * Sets text's background color of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBgColor(@ColorInt int textBgColor, String... subTextArray) {
        setSpan(new BackgroundColorSpan(textBgColor), subTextArray);
        return this;
    }

    /**
     * Sets text's background image from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBgImage(@DrawableRes int resId, int start, int end) {
        setSpan(new ImageSpan(context, resId), start, end);
        return this;
    }

    /**
     * Sets text's background image of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBgImage(@DrawableRes int resId, String... subTextArray) {
        setSpan(new ImageSpan(context, resId), subTextArray);
        return this;
    }

    /**
     * Sets text's background image with specified width and height from {@code start}
     * to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBgImage(@DrawableRes int resId, int start, int end, int width, int height) {
        Drawable drawable = this.context.getResources().getDrawable(resId);
        drawable.setBounds(0, 0, width, height);
        setSpan(new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE), start, end);
        return this;
    }

    /**
     * Sets text's background image with specified width and height of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBgImage(@DrawableRes int resId, int width, int height, String... subTextArray) {
        Drawable drawable = this.context.getResources().getDrawable(resId);
        drawable.setBounds(0, 0, width, height);
        setSpan(new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE), subTextArray);
        return this;
    }

    /**
     * Sets text's typeface from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextTypeface(int textStyle, int start, int end) {
        setSpan(new StyleSpan(textStyle), start, end);
        return this;
    }

    /**
     * Sets text's typeface of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextTypeface(int textStyle, String... subTextArray) {
        setSpan(new StyleSpan(textStyle), subTextArray);
        return this;
    }

    /**
     * Sets text {@code Italy} from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextItalic(int start, int end) {
        return setTextTypeface(Typeface.ITALIC, start, end);
    }

    /**
     * Sets text {@code Italy} of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextItalic(String... subTextArray) {
        return setTextTypeface(Typeface.ITALIC, subTextArray);
    }

    /**
     * Sets text {@code Bold} from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBold(int start, int end) {
        return setTextTypeface(Typeface.BOLD, start, end);
    }

    /**
     * Sets text {@code Bold} of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextBold(String... subTextArray) {
        return setTextTypeface(Typeface.BOLD, subTextArray);
    }

    /**
     * Sets text strike through from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextStrikethrough(int start, int end) {
        setSpan(new StrikethroughSpan(), start, end);
        return this;
    }

    /**
     * Sets text strike through of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextStrikethrough(String... subTextArray) {
        setSpan(new StrikethroughSpan(), subTextArray);
        return this;
    }

    /**
     * Sets text underline from {@code start} to {@code end}.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextUnderline(int start, int end) {
        setSpan(new UnderlineSpan(), start, end);
        return this;
    }

    /**
     * Sets text underline of part(s) of string.
     *
     * @return SpannableEditor for chaining use.
     */
    public SpannableEditor setTextUnderline(String... subTextArray) {
        setSpan(new UnderlineSpan(), subTextArray);
        return this;
    }

}
