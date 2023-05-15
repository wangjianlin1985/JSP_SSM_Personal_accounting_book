// 
// 
// 

package com.taoxiuxia.util;

import java.time.temporal.TemporalAdjusters;
import java.time.LocalDate;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTimeUtil
{
    public static String nowTime() {
        final SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        final Date date = new Date();
        return bartDateFormat.format(date);
    }
    
    public static int compareTimeByMin(final String time1, final String time2) {
        int hours = 0;
        try {
            final SimpleDateFormat simpleFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            final long from = simpleFormat.parse(time1).getTime();
            final long to = simpleFormat.parse(time2).getTime();
            hours = Math.abs((int)((to - from) / 60000L));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return hours;
    }
    
    public static String firstDayOfThisMonth() {
        final LocalDate today = LocalDate.now();
        final LocalDate firstday = LocalDate.of(today.getYear(), today.getMonth(), 1);
        return new StringBuilder().append(firstday).toString();
    }
    
    public static String lastDayOfThisMonth() {
        final LocalDate today = LocalDate.now();
        final LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        return new StringBuilder().append(lastDay).toString();
    }
}
