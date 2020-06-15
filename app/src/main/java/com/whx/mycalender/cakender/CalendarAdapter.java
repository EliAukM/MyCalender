package com.whx.mycalender.cakender;

import android.content.Context;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.whx.mycalender.R;
import com.whx.mycalender.utils.SV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.whx.mycalender.cakender.CalendarUtils.checkEqual;
import static com.whx.mycalender.cakender.CalendarUtils.checkMonth;
import static com.whx.mycalender.cakender.CalendarUtils.checkStatus;
import static com.whx.mycalender.cakender.CalendarUtils.specificSize;


/**
 * 日历适配器.
 */

public class CalendarAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;
    private int status = 0;
    private SaveData fromData;
    private SaveData toData;
    private int currentYear = -1;
    private int currentMonth = -1;
    private int data = -1;    //当前月份1号是属于星期几

    public CalendarAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_calendar, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        try {
            if (currentYear == -1) {
                data = CalendarUtils.getWeek(new SaveData(CalendarUtils.getCurentYear(), CalendarUtils.getCurentMonth(), 1));
            } else {
                data = CalendarUtils.getWeek(new SaveData(currentYear, currentMonth, 1));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        // HH:mm:ss//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        String[] s = format.split("日");//s[0] 2020年06月05
        String[] s1 = s[0].split("月");
        Log.e("TAG", "当天" + s1[1]);
        Integer day = Integer.valueOf(s1[1]);


        if (!list.get(position).equals("0")) {

            for (int i = 0; i < list.size(); i++) {
                if (Integer.valueOf(list.get(position)) > day) {//day=5
                    SV.show(viewHolder.calendarShow, list.get(position));
                    viewHolder.calendarShow.setTextColor(context.getResources().getColor(R.color.color_ADADAD));
                } else {
                    if (Integer.valueOf(list.get(position)) == 1 || Integer.valueOf(list.get(position)) == 3) {
                        SV.show(viewHolder.calendarShow, list.get(position));
                        viewHolder.calendarShow.setTextColor(Color.WHITE);
                        viewHolder.calendarShow.setBackground(context.getResources().getDrawable(R.drawable.circle_yellow_calender));
                    } else {
                        SV.show(viewHolder.calendarShow, list.get(position));
                        viewHolder.calendarShow.setTextColor(Color.BLACK);
                    }

                }
            }

        } else {
            viewHolder.calendarShow.setText("");
            viewHolder.calendarShow.setBackgroundResource(R.drawable.chose_calendar_four);
        }
        return convertView;
    }

    public void updata(int currentYear, int currentMonth) {
        this.currentYear = currentYear;
        this.currentMonth = currentMonth;
    }

    public void updata(int status, SaveData saveData, int currentYear, int currentMonth) {
        this.currentYear = currentYear;
        this.currentMonth = currentMonth;
        this.status = status;
        if (status == 0) {
            fromData = saveData;
        } else if (status == 1) {
            toData = saveData;
        }
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView calendarShow;

        ViewHolder(View view) {
            calendarShow = view.findViewById(R.id.calendar_show);
        }
    }
}
