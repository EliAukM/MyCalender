package com.whx.mycalender.cakender;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whx.mycalender.R;
import com.whx.mycalender.utils.SV;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.whx.mycalender.cakender.CalendarUtils.specificSize;

/**
 * 日历选择控件
 */

public class SelectCalendar extends RelativeLayout {

    private View view;
    private CalendarAdapter calendarAdapter;
    private List<String> list;
    private int status = 0;    //当前选中的状态，0表示未选择，1表示选择一个，二表示选择俩个
    private SaveData fromData;
    private SaveData toData;
    private int currentYear;    //当前显示的年份
    private int currentMonth;    //当前显示的月份
    private int week = -1;    //当前月份1号是星期几
    private int fromweek = -1;  //起始点所在月份1号星期几
    private int toweek = -1;     //结束点所在所在1号星期几
    private CalendarTime calendarTime;


    //通过下面这几行代码，将后台请求到的数据，传到适配器中
//    List<Integer> signList = new ArrayList<>();
//    public void setData(List<Integer> list) {
//        signList.clear();
//        signList.addAll(list);
//        calendarAdapter.setSignList(signList);
//        calendarAdapter.notifyDataSetChanged();
//    }


    public SelectCalendar(Context context) {
        super(context);
    }

    public SelectCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public SelectCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        list = new ArrayList<>();
        final ViewHolder viewHolder;
        currentYear = CalendarUtils.getCurentYear();
        currentMonth = CalendarUtils.getCurentMonth() + 1;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_calendar, SelectCalendar.this);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SV.show(viewHolder.calendarTime, currentYear + "-" + currentMonth);
        try {
            week = CalendarUtils.getWeek(new SaveData(currentYear, currentMonth, 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (week != -1) {
            for (int i = 0; i < week; i++) {
                list.add("0");    //添加空格
            }
        }
        for (int i = 0; i < CalendarUtils.getDayByMonth(currentYear, currentMonth); i++) {
            list.add(i + 1 + "");    //添加本月多少号
        }
        calendarAdapter = new CalendarAdapter(context, list);
        viewHolder.calendarDay.setAdapter(calendarAdapter);
    }


    static class ViewHolder {
        ImageView calendarUp;
        TextView calendarTime;
        ImageView calendarDown;
        GridView calendarDay;

        ViewHolder(View view) {
            calendarUp = view.findViewById(R.id.calendar_up);
            calendarTime = view.findViewById(R.id.calendar_time);
            calendarDown = view.findViewById(R.id.calendar_down);
            calendarDay = view.findViewById(R.id.calendar_day);
        }
    }

    //用于被外部监听
    public void setOnTimeLisenter(CalendarTime calendarTime) {
        this.calendarTime = calendarTime;
    }

    //用来供外部获取点击的时间数据
    public interface CalendarTime {
        void showData(SaveData fromData, SaveData toData);
    }

}
