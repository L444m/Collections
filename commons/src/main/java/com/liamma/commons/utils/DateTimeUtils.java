package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Date and Time utils.
 * Created by Liam on 2017/12/6.
 */
public final class DateTimeUtils {

    private DateTimeUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static final long SECOND = 1000L;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;
    public static final long YEAR = 365 * DAY;

    public static final long HALF_HOUR = 30 * MINUTE;
    public static final long HALF_DAY = 12 * HOUR;

    private static final long SECONDS_IN_DAY = 24 * 60 * 60;
    private static final long MILLS_IN_DAY = 1000 * SECONDS_IN_DAY;

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String MM_DD = "MM-dd";

    // return current timestamp value.
    private static long now() {
        return System.currentTimeMillis();
    }

    /**
     * Returns a timestamp in String format.
     */
    public static String getStringTimestamp() {
        return String.valueOf(now());
    }

    /**
     * Formats "now" into string using default pattern.
     */
    public static String format() {
        return format(now());
    }

    /**
     * Formats a Long timestamp into String using default pattern.
     */
    public static String format(long timestamp) {
        return format(timestamp, DEFAULT_PATTERN);
    }

    /**
     * Formats a Long timestamp into String.
     *
     * @param timestamp timestamp
     * @param pattern   pattern
     * @return a formatted String
     */
    public static String format(long timestamp, String pattern) {
        Timestamp ts = new Timestamp(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(ts);
    }


    public static String getCurrentDateTime(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(date);
    }

    public static String getCurrentDateTime() {
        return getCurrentDateTime(DEFAULT_PATTERN);
    }

    public static String getCurrentDate() {
        return getCurrentDateTime(YYYY_MM_DD);
    }

    private static long toDay(long timestamp) {
        return (timestamp + TimeZone.getDefault().getOffset(timestamp)) / MILLS_IN_DAY;
    }

    public static boolean isSameDay(long timestamp1, long timestamp2) {
        long diff;
        diff = Math.abs(timestamp1 - timestamp2);
        // diff = timestamp1 >= timestamp2 ?
        //        timestamp1 - timestamp2 : timestamp2 - timestamp1;
        return diff < MILLS_IN_DAY && toDay(timestamp1) == toDay(timestamp2);
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
            return getCurrentDateTime(targetPattern);
        }
    }

    public static void testTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();
        LogUtils.i("current TimeZone displayName = " + timeZone.getDisplayName());
        LogUtils.i("current TimeZone ID = " + timeZone.getID());

        LogUtils.i("current TimeZone time : " + format());

        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN, Locale.US);
        TimeZone newTimeZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(newTimeZone);
        LogUtils.i("new TimeZone = " + newTimeZone.getDisplayName());
        LogUtils.i("new TimeZone ID = " + newTimeZone.getID());

        LogUtils.i("current US time : " + sdf.format(new Date()));

    }

}
