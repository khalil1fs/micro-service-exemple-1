package com.example.paimentv1.util;

// on'a le met a l'exterieur parcequ'il va etre consommer par le service et le ws
public class NumberUtil {
    public static Double toDouble(String value){
        if (value == null || value.isEmpty()) {
            return 0D;
        }else return Double.parseDouble(value);
    }

    public static String toString(Double value){
        if (value == null) {
            return "";
        }else
            return value.toString();
    }

}
