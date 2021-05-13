package com.liamma.commons.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2020/12/30 10:05
 * DESCRIPTION: 大数据计算方法。
 */
public final class BigDecimalUtils {

    private BigDecimalUtils() {
        throw new UnsupportedOperationException("cannot be instantiated.");
    }

    public static BigDecimal fromString(String s) {
        return new BigDecimal(s);
    }

    /**
     * whether bd1 is equal to bd2.
     *
     * @return {@code true} if {@code bd1 == bd2}, otherwise {@code false}.
     */
    public static boolean isEqual(BigDecimal bd1, BigDecimal bd2) {
        return false;
    }

    /**
     * Whether bd1 is greater than bd2.
     *
     * @return {@code true} if {@code bd1 > bd2}, otherwise {@code false}.
     */
    public static boolean isGreater(BigDecimal bd1, BigDecimal bd2) {
        return false;
    }

    /**
     * Whether bd1 is less than bd2.
     *
     * @return {@code true} if {@code bd1 < bd2}, otherwise {@code false}.
     */
    public static boolean isLess(BigDecimal bd1, BigDecimal bd2) {
        return false;
    }

    /**
     * Whether bd1 is greater than or equal to bd2.
     *
     * @return {@code true} if {@code bd1 >= bd2}, otherwise {@code false}.
     */
    public static boolean isGreaterOrEqual(BigDecimal bd1, BigDecimal bd2) {
        return false;
    }

    /**
     * Whether bd1 is less than or equal to bd2.
     *
     * @return {@code true} if {@code bd1 <= bd2}, otherwise {@code false}.
     */
    public static boolean isLessOrEqual(BigDecimal bd1, BigDecimal bd2) {
        return false;
    }

    /**
     * +
     */
    @NonNull
    public static BigDecimal add(@Nullable BigDecimal bd, @Nullable BigDecimal... bdArray) {
        if (bd == null) {
            bd = BigDecimal.ZERO;
        }
        if (EmptyUtils.isEmpty(bdArray)) {
            return bd;
        }
        BigDecimal result = bd;
        for (BigDecimal bigDecimal : bdArray) {
            if (bigDecimal != null) {
                result = result.add(bigDecimal);
            }
        }
        return result;
    }

    @NonNull
    public static BigDecimal subtract(@Nullable BigDecimal bd, @Nullable BigDecimal... bdArray) {
        if (bd == null) {
            bd = BigDecimal.ZERO;
        }
        if (EmptyUtils.isEmpty(bdArray)) {
            return bd;
        }
        BigDecimal result = bd;
        for (BigDecimal bigDecimal : bdArray) {
            if (bigDecimal != null) {
                result = result.subtract(bigDecimal);
            }
        }
        return result;
    }

    public static BigDecimal multiply(@Nullable BigDecimal bd, @Nullable BigDecimal... bdArray) {
        if (bd == null) {
            LogUtils.d("Divisor is null, cannot exec multiply.");
            return BigDecimal.ZERO;
        }
        if (EmptyUtils.isEmpty(bdArray)) {
            return bd;
        }
        BigDecimal result = bd;
        for (BigDecimal bigDecimal : bdArray) {
            if (bigDecimal != null) {
                result = result.multiply(bd);
            }
        }
        return result;
    }

    public static BigDecimal divide(@Nullable BigDecimal bd1, @Nullable BigDecimal... bd2) {
        if (EmptyUtils.isEmpty(bd2)) return bd1 != null ? bd1 : BigDecimal.ZERO;
        if (bd1 == null) bd1 = BigDecimal.ONE;

        BigDecimal result = bd1;
        for (BigDecimal bd : bd2) {
            if (bd != null && !bd.equals(BigDecimal.ZERO)) result = bd1.divide(bd);
        }
        return result;
    }


    /**
     * 格式化为 (最多) 8 位小数。
     * 当小数位大于 8 位时，格式为 8 位小数；小于 8 位时，则显示对应的位数。
     *
     * @param bigDecimal BigDecimal
     */
    public static String to8(@Nullable BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "0.00";
        }

        int scale = bigDecimal.scale();
        DecimalFormat df;
        if (scale < 2) {
            df = new DecimalFormat("##,###,##0.00");
        } else if (scale <= 8) {
            df = new DecimalFormat("##,###,##0.00######");
        } else {
            df = new DecimalFormat("##,###,##0.00000000");
        }

        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(bigDecimal);
    }

    /**
     * Equals to method {@code to8(BigDecimal bigDecimal)} .
     */
    public static String to8(@Nullable String value) {
        if (EmptyUtils.isEmpty(value)) {
            return "0.00";
        }
        try {
            return to8(new BigDecimal(value));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "0.00";
        }
    }

    /**
     * Equals to method {@code to8(BigDecimal bigDecimal)} .
     */
    public static String to8(double value) {
        try {
            return to8(BigDecimal.valueOf(value));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "0.00";
        }
    }

    /**
     * 格式化为 (最多) 8 位小数，<strong>没有</strong> 逗号分隔。
     * 当小数位大于 8 位时，格式为 8 位小数；小于 8 位时，则显示对应的位数。
     *
     * @param bigDecimal BigDecimal
     * @return Formatted String
     */
    public static String to8NoComma(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "0.00";
        }

        int scale = bigDecimal.scale();
        if (scale < 2) {
            return bigDecimal.setScale(2, RoundingMode.HALF_UP).toPlainString();
        } else if (scale <= 8) {
            return bigDecimal.toPlainString();
        } else {
            return bigDecimal.setScale(8, RoundingMode.HALF_UP).toPlainString();
        }
    }

    /**
     * Equals to method {@code to8NoComma(BigDecimal bigDecimal)} .
     */
    public static String to8NoComma(String value) {
        if (StringUtils.isEmpty(value)) {
            return "0.00";
        }
        return to8NoComma(new BigDecimal(value));
    }

    /**
     * Equals to method {@code to8NoComma(BigDecimal bigDecimal)} .
     */
    public static String to8NoComma(double value) {
        try {
            return to8NoComma(BigDecimal.valueOf(value));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "0.00";
        }
    }

}
