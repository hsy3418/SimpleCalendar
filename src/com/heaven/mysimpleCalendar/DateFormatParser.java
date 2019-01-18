package com.heaven.mysimpleCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatParser {

    public Date generateDate(String dateStr, String format){
        Date currentDate = new Date() ;
        DateFormat df = new SimpleDateFormat(format);
        try {
           currentDate = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }
}
