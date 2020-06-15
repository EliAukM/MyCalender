package com.whx.mycalender.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 常用的控件TextView,EditText赋值处理
 */

public class SV {

    public static void show(TextView tv, String... str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String st : str) {
            if (StringUtils.isNotEmpty(st)) {
                stringBuffer.append(StringUtils.toString(st));
            }
        }
        if (StringUtils.isNotEmpty(stringBuffer)) {
            if (!checkVisibity(tv)) {
                tv.setVisibility(View.VISIBLE);
            }
            tv.setText(StringUtils.toString(str));
        } else {
            if (checkVisibity(tv)) {
                tv.setVisibility(View.GONE);
            }
        }
    }

    public static void show(EditText tv, String... str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String st : str) {
            if (StringUtils.isNotEmpty(st)) {
                stringBuffer.append(StringUtils.toString(st));
            }
        }
        if (StringUtils.isNotEmpty(stringBuffer)) {
            if (!checkVisibity(tv)) {
                tv.setVisibility(View.VISIBLE);
            }
            tv.setText(StringUtils.toString(str));
        } else {
            if (checkVisibity(tv)) {
                tv.setVisibility(View.GONE);
            }
        }
    }

    public static void show(EditText tv, TextView... str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (TextView st : str) {
            if (StringUtils.isNotEmpty(st)) {
                stringBuffer.append(StringUtils.toString(st));
            }

        }
        if (StringUtils.isNotEmpty(stringBuffer)) {
            if (!checkVisibity(tv)) {
                tv.setVisibility(View.VISIBLE);
            }
            tv.setText(StringUtils.toString(str));
        } else {
            if (checkVisibity(tv)) {
                tv.setVisibility(View.GONE);
            }
        }
    }

    public static void show(EditText tv, EditText... str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (EditText st : str) {
            if (StringUtils.isNotEmpty(st)) {
                stringBuffer.append(StringUtils.toString(st));
            }
        }
        if (StringUtils.isNotEmpty(stringBuffer)) {
            if (!checkVisibity(tv)) {
                tv.setVisibility(View.VISIBLE);
            }
            tv.setText(StringUtils.toString(str));
        } else {
            if (checkVisibity(tv)) {
                tv.setVisibility(View.GONE);
            }
        }
    }

    private static boolean checkVisibity(TextView tv) {
        if (tv != null) {
            if (tv.getVisibility() == View.VISIBLE || tv.getVisibility() == View.INVISIBLE) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkVisibity(EditText tv) {
        if (tv != null) {
            if (tv.getVisibility() == View.VISIBLE || tv.getVisibility() == View.INVISIBLE) {
                return true;
            }
        }
        return false;
    }

}
