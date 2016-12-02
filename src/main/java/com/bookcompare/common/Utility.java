package com.bookcompare.common;

/**
 * Created by Raymond on 21/11/2016.
 */
public class Utility {
    private Utility() {}
    public static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }
}
