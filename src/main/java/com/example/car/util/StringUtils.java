package com.example.car.util;

public class StringUtils {
	public static boolean isNotEmptyOrNull(String str) {
        return !(null == str || "".equals(str.trim()));
    }
}
