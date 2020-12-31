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

    // patterns
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_MM_DD = "MM-dd";

    // Returns current timestamp value.
    private static long currentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Returns current timestamp in String formatTimestamp.
     */
    public static String getStringTimestamp() {
        return String.valueOf(currentTimestamp());
    }

    public static String formatTimestamp() {
        return formatTimestamp(currentTimestamp());
    }

    public static String formatTimestamp(long timestamp) {
        return formatTimestamp(timestamp, DEFAULT_PATTERN);
    }

    public static String formatTimestamp(long timestamp, @NonNull String pattern) {
        return formatTimestamp(timestamp, pattern, Locale.getDefault());
    }

    /**
     * Formats a timestamp with the specified pattern and Locale.
     *
     * @param timestamp Long Timestamp
     * @param pattern   pattern
     * @param locale    Locale
     * @return a formatted String
     */
    public static String formatTimestamp(long timestamp, @NonNull String pattern, @NonNull Locale locale) {
        Timestamp ts = new Timestamp(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        return sdf.format(ts);
    }

    public static String formatDate() {
        return formatDate(new Date());
    }

    public static String formatDate(@Nullable Date date) {
        return formatDate(date, DEFAULT_PATTERN);
    }

    public static String formatDate(@Nullable Date date, @NonNull String pattern) {
        return formatDate(date, pattern, Locale.getDefault());
    }

    /**
     * Formats a Date object with the specified pattern and Locale.
     *
     * @param date    Date
     * @param pattern pattern
     * @param locale  Locale
     * @return a formatted String
     */
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
        return getCurrent(DEFAULT_PATTERN);
    }

    public static String getCurrentDate() {
        return getCurrent(PATTERN_YYYY_MM_DD);
    }

    private static long toDay(long timestamp) {
        return (timestamp + TimeZone.getDefault().getOffset(timestamp)) / MILLS_IN_DAY;
    }

    public static boolean isSameDay(long timestamp1, long timestamp2) {
        long diff;
        diff = Math.abs(timestamp1 - timestamp2);
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
