package com.airwallex.assignment.utils;

public class Utils {

    public static boolean isNumber(String str) {
        try {
            // TODO consider other ways
            Double.parseDouble(str);
            return true;
//            return BigDecimal.(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
