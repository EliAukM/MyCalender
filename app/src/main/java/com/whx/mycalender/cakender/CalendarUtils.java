package com.whx.mycalender.cakender;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 关于日期处理的工具
 */

public class CalendarUtils {

    private static Calendar calendar = Calendar.getInstance();

    //获取当前的年月
    public static String getCurentData() {
        return "" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH);
    }

    //获取当前的年
    public static int getCurentYear() {
        return calendar.get(Calendar.YEAR);
    }

    //获取当前的月
    public static int getCurentMonth() {
        return calendar.get(Calendar.MONTH);
    }


    //获取根据年，月所在的天数
    public static int getDayByMonth(int year, int month) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    //判断当前的年月日在不在指定范围内,此方法默认前提是fromdata一定比toData小，结合下面的specificSize使用即可
    public static boolean checkStatus(int tagYear, int tagMonth, int tagDay,
                                      SaveData fromdata,
                                      SaveData toData) {
        if (specificSize(new SaveData(tagYear, tagMonth, tagDay), toData) && specificSize(fromdata, new SaveData(tagYear, tagMonth, tagDay))) {
            return true;
        } else {
            return false;
        }
    }

    //检查俩个日期是否相等
    public static boolean checkEqual(SaveData tagOne, SaveData tagTwo) {
        if (tagOne.getYear() == tagTwo.getYear() && tagOne.getMonth() == tagTwo.getMonth() && tagOne.getDay() == tagTwo.getDay()) {
            return true;
        }
        return false;
    }

    //获取当前日期属于星期几
    public static int getWeek(SaveData saveData) throws ParseException {
        int weekData = -1;
        String time = saveData.getYear() + "-" + saveData.getMonth() + "-" + saveData.getDay();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String week = sdf.format(format.parse(time));
        switch (week) {
            case "周一":
                weekData = 1;
                break;
            case "周二":
                weekData = 2;
                break;
            case "周三":
                weekData = 3;
                break;
            case "周四":
                weekData = 4;
                break;
            case "周五":
                weekData = 5;
                break;
            case "周六":
                weekData = 6;
                break;
            case "周日":
                weekData = -1;    //这里返回的-1根据当前项目，咱不更改
                break;
        }
        return weekData;
    }

    //用来比较俩个日期大小，前面小就返回true
    public static boolean specificSize(SaveData tagOne, SaveData tagTwo) {
        if (tagOne.getYear() == tagTwo.getYear()) {
            if (tagOne.getMonth() == tagTwo.getMonth()) {
                if (tagOne.getDay() <= tagTwo.getDay()) {
                    return true;
                } else {
                    return false;
                }
            } else if (tagOne.getMonth() < tagTwo.getMonth()) {
                return true;
            } else {
                return false;
            }
        } else if (tagOne.getYear() < tagTwo.getYear()) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否是同一年同一月（不广泛使用）
    public static boolean checkMonth(SaveData tagOne, SaveData tagTwo) {
        if (tagOne.getYear() == tagTwo.getYear() && tagOne.getMonth() != tagTwo.getMonth()) {
            return true;
        }
        return false;
    }

}
