package com.whx.mycalender.cakender;

/**
 * 存储年月日
 */

public class SaveData {

    int year = -1;
    int month = -1;
    int day = -1;

    public SaveData(){}

    public SaveData(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public SaveData setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public SaveData setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public SaveData setDay(int day) {
        this.day = day;
        return this;
    }

    public String toString(){
        return "" + year + month + day;
    }

}