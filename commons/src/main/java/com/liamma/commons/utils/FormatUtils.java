package com.liamma.commons.utils;

import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * Format utils.
 * Created by Liam on 2018/10/13
 */
public final class FormatUtils {

    private FormatUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 格式化为 (最多) 8 位小数。
     * 当小数位大于 8 位时，格式为 8 位小数；小于 8 位时，则显示对应的位数。
     *
     * @param bigDecimal BigDecimal
     */
    public static String to8(@Nullable BigDecimal bigDecimal) {
        if (bigDecimal == null) return "0.00";

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
        if (EmptyUtils.isEmpty(value)) return "0.00";

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
        if (bigDecimal == null) return "0.00";

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
        if (StringUtils.isEmpty(value)) return "0.00";
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
