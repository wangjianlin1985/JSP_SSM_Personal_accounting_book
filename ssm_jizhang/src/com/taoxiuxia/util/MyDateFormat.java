// 
// 
// 

package com.taoxiuxia.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormat
{
    public static Date dateFormat(final String dateStr) {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
