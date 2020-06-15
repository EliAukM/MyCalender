package com.whx.mycalender.utils;

import android.widget.EditText;
import android.widget.TextView;


/**
 * 常用的控件，字符串判空和toString处理
 */

public class StringUtils {

    public static boolean isNotEmpty(TextView... textView) {
        for (TextView tv : textView) {
            if (tv == null || tv.getText().toString().trim().length() == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(EditText... editText) {
        for (EditText ed : editText) {
            if (ed == null || ed.getText().toString().trim().length() == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(String... string) {
        for (String str : string) {
            if (str == null || str.toString().trim().length() == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(StringBuffer string) {
        return isNotEmpty(string.toString());
    }

    public static String toString(TextView... tev) {
        StringBuffer stringBuffer = new StringBuffer();
        for (TextView tv : tev) {
            if (tv != null) {
                stringBuffer.append(tv.getText().toString().trim());
            }
        }
        return stringBuffer.toString();
    }

    public static String toString(EditText... etv) {
        StringBuffer stringBuffer = new StringBuffer();
        for (EditText tv : etv) {
            if (tv != null) {
                stringBuffer.append(tv.getText().toString().trim());
            }
        }
        return stringBuffer.toString();
    }

    public static String toString(String... Stv) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String tv : Stv) {
            if (tv != null) {
                stringBuffer.append(tv.toString().trim());
            }
        }
        return stringBuffer.toString();
    }

}
