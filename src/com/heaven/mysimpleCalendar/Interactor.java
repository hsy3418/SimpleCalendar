package com.heaven.mysimpleCalendar;

import java.util.Calendar;
import java.util.Scanner;

public class Interactor {

    public static String receiveInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static void outputPromptMessage(String message){
        System.out.println(message);
    }


    public static void main(String[] args){
        Interactor.outputPromptMessage("Please enter a valid date");
        String date = receiveInput();
        CalendarOperator calendarOperator = new CalendarOperator(date,"yyyy-MM-dd");
        int firstDay = calendarOperator.getFirstDayOfWeek();
        int theDate = calendarOperator.getTheDate();
        int maxNumOfDateInThatMonth = calendarOperator.getMaxNumOfdays();
        int startSkipSpace = firstDay - 1;
        StringBuilder stringBuilder = new StringBuilder("日\t一\t二\t三\t四\t五\t六\n");

        //set the date to the first day of that month
        calendarOperator.setDateToTheSpecificDay(1);

        // append the number of space into the stringBuilder
        for(int i = 1;i<=startSkipSpace;i++){
            stringBuilder.append(" \t");
        }
        for(int i = 1;i<=maxNumOfDateInThatMonth;i++){
            //String temp = (i-dateOnFirstSaturyday) %  7 == 0 ? i + "\n" : i + "\t";
            if(i ==theDate){
                stringBuilder.append("*");
            }
            //if the day is on Saturday, then need to skip to the next line.
            String temp = calendarOperator.getSaturdayDay() == calendarOperator.getDayOfTheWeek() ? i + "\n" : i + "\t";

            stringBuilder.append(temp);
            calendarOperator.increaseDay(1);


        }
        System.out.println(stringBuilder);


    }
}
