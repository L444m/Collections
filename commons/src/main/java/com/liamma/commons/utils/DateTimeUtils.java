package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.log.LogUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2017/12/6 14:44
 * DESCRIPTION: Date and Time utils.
 */
public final class DateTimeUtils {

    private DateTimeUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // time unit in second
    public static final long SECOND = 1L;
    public static final long HALF_MINUTE = 30 * SECOND;
    public static final long MINUTE = 60 * SECOND;
    public static final long HALF_HOUR = 30 * MINUTE;
    public static final long HOUR = 60 * MINUTE;
    public static final long HALF_DAY = 12 * HOUR;
    public static final long DAY = 24 * HOUR;
    public static final long WEEK = 7 * DAY;
    public static final long HALF_MONTH = 15 * DAY;
    public static final long MONTH = 30 * DAY;
    public static final long YEAR = 365 * DAY;

    // time unit in millisecond
    public static final long SECOND_IN_MILLI = 1000L;
    public static final long HALF_MINUTE_IN_MILLI = 30 * SECOND_IN_MILLI;
    public static final long MINUTE_IN_MILLI = 60 * SECOND_IN_MILLI;
    public static final long HALF_HOUR_IN_MILLI = 30 * MINUTE_IN_MILLI;
    public static final long HOUR_IN_MILLI = 60 * MINUTE_IN_MILLI;
    public static final long HALF_DAY_IN_MILLI = 12 * HOUR_IN_MILLI;
    public static final long DAY_IN_MILLI = 24 * HOUR_IN_MILLI;
    public static final long WEEK_IN_MILLI = 7 * DAY_IN_MILLI;
    public static final long HALF_MONTH_IN_MILLI = 15 * DAY_IN_MILLI;
    public static final long MONTH_IN_MILLI = 30 * DAY_IN_MILLI;
    public static final long YEAR_IN_MILLI = 365 * DAY_IN_MILLI;

    // patterns
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_YYYY_MM = "yyyy-MM";
    public static final String PATTERN_MM_DD = "MM-dd";
    public static final String PATTERN_HH_MM = "HH:mm";

    @NonNull
    public static String formatTimestamp() {
        return formatTimestamp(System.currentTimeMillis());
    }

    @NonNull
    public static String formatTimestamp(long timestamp) {
        return formatTimestamp(timestamp, DEFAULT_PATTERN, null);
    }

    @NonNull
    public static String formatTimestamp(@NonNull String pattern) {
        return formatTimestamp(System.currentTimeMillis(), pattern, null);
    }

    public static String formatTimestamp(@Nullable String strTimestamp, @Nullable String pattern,
                                         @Nullable Locale locale) {
        if (EmptyUtils.isEmpty(strTimestamp)) {
            return "";
        }
        try {
            long timestamp = Long.parseLong(strTimestamp);
            return formatTimestamp(timestamp, pattern, locale);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    /**
     * Formats a timestamp with the specified pattern and Locale.
     */
    @NonNull
    public static String formatTimestamp(long timestamp, @Nullable String pattern, @Nullable Locale locale) {
        if (EmptyUtils.isEmpty(pattern)) {
            pattern = DEFAULT_PATTERN;
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Timestamp ts = new Timestamp(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        SimpleDateFormat sdf2 = new SimpleDateFormat(pattern);
        return sdf.format(ts);
    }

    @NonNull
    public static String formatDate() {
        return formatDate(new Date());
    }

    @NonNull
    public static String formatDate(@Nullable Date date) {
        return formatDate(date, DEFAULT_PATTERN);
    }

    @NonNull
    public static String formatDate(@NonNull String pattern) {
        return formatDate(new Date(), pattern);
    }

    @NonNull
    public static String formatDate(@Nullable Date date, @NonNull String pattern) {
        return formatDate(date, pattern, Locale.getDefault());
    }

    /**
     * Formats a Date object with the specified pattern and Locale.
     */
    @NonNull
    public static String formatDate(@Nullable Date date, @NonNull String pattern, @NonNull Locale locale) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        return sdf.format(date);
    }

    public static String getCurrent(@NonNull String pattern) {
        return formatDate(new Date(), pattern);
    }

    public static String getCurrent() {
        return formatTimestamp(DEFAULT_PATTERN);
    }

    public static String getCurrentDate() {
        return formatTimestamp(PATTERN_MM_DD);
    }

    public static String getCurrentTime() {
        return formatTimestamp(PATTERN_HH_MM);
    }

    public static long toTimestamp(@Nullable String strDate) {
        return toTimestamp(strDate, DEFAULT_PATTERN);
    }

    public static long toTimestamp(@Nullable String strDate, @NonNull String pattern) {
        return -1L;
    }

    private static long toDay(long timestamp) {
        return (timestamp + TimeZone.getDefault().getOffset(timestamp)) / DAY_IN_MILLI;
    }

    public static boolean isSameDay(long timestamp1, long timestamp2) {
        long diff = Math.abs(timestamp1 - timestamp2);
        return diff < DAY_IN_MILLI && toDay(timestamp1) == toDay(timestamp2);
    }

    public static boolean isSameDay(long timestamp) {
        return isSameDay(timestamp, System.currentTimeMillis());
    }

    public static String correctServerDate(@NonNull String strDate, @Nullable String svrPattern,
                                           @Nullable String targetPattern) {
        if (EmptyUtils.isEmpty(svrPattern)) svrPattern = DEFAULT_PATTERN;
        if (EmptyUtils.isEmpty(targetPattern)) targetPattern = DEFAULT_PATTERN;

        // 2018-10-14 02:01:58
        // 2018-10-14 10:01:58

        SimpleDateFormat sdf = new SimpleDateFormat(svrPattern, Locale.US);
        TimeZone svrTimeZone = TimeZone.getTimeZone("GMT"); // 这个值应该通过接口获得
        sdf.setTimeZone(svrTimeZone);

        Date date;
        try {
            date = sdf.parse(strDate);
            return (new SimpleDateFormat(targetPattern, Locale.getDefault())).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            LogUtils.e("The server time cannot be parsed.");
            return getCurrent(targetPattern);
        }
    }

    public static void testTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();
        LogUtils.i("current TimeZone displayName = " + timeZone.getDisplayName());
        LogUtils.i("current TimeZone ID = " + timeZone.getID());

        LogUtils.i("current TimeZone time : " + formatTimestamp());

        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN, Locale.US);
        TimeZone newTimeZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(newTimeZone);
        LogUtils.i("new TimeZone = " + newTimeZone.getDisplayName());
        LogUtils.i("new TimeZone ID = " + newTimeZone.getID());

        LogUtils.i("current US time : " + sdf.format(new Date()));
    }

}
