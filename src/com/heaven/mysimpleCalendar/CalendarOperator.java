package com.heaven.mysimpleCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarOperator {
    private Calendar calendar;

    private DateFormatParser dateFormatParser ;

    public CalendarOperator(String dateString,String format){
        calendar = new GregorianCalendar();
        dateFormatParser = new DateFormatParser();
        Date date =  dateFormatParser.generateDate(dateString,format);
        calendar.setTime(date);
    }

    public int getFirstDayOfWeek(){
        // create a copy of the calendar object, so the original date will not be changed.
        Calendar tempCalendar = (Calendar)calendar.clone();
        //set the tempCalendar to the first date of that month
        tempCalendar.set(Calendar.DATE,1);
        //get the day of the firstdate, 1 means sunday,2 means Monday,etc
        return tempCalendar.get(Calendar.DAY_OF_WEEK);

    }


    /**
     *
     * @return the number of days in that week, if march, return 31, if apr return 30
     */
    public int getMaxNumOfdays(){
       return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     *
     * @return the particular date of that month,1 means 1st,2 second
     */
    public int getTheDate(){
        return calendar.get(calendar.DATE);
    }

    /**
     *  get the day of the date, 1 means sunday,2 means Monday,etc
     * @return
     */

    public int getDayOfTheWeek(){
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * get the day of saturday
     */
    public int getSaturdayDay(){
        return Calendar.SATURDAY;
    }

    /**
     * reset the date of the original date to the day specified
     * number: 1 means set the date to the 1st of that mongth
     */

    public void setDateToTheSpecificDay(int number){
       calendar.set(Calendar.DATE,number);
    }

    /**
     * increase the date based on the number of days
     * @param numberOfDays
     */
    public void increaseDay(int numberOfDays){
        calendar.add(Calendar.DATE,numberOfDays);
    }

}
