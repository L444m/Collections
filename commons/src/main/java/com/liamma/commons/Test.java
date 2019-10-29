package com.liamma.commons;

/**
 * Created by Liam on 2019/1/11
 */
public class Test {

    public static void main(String[] args) {
        String s = "  testing    ";

//        boolean result = isBlank(s);
//        System.out.println("result = " + result);
//        System.out.println("s==" + s);

        System.out.println(Test.testEqual(s));
        System.out.println(Test.testEqual(null));

    }

    public static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

    public static boolean testEqual(String value) {
        String base = "testing";
        return base.equals(value);
    }


}
