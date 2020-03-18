package com.InputData;
/*
 * import java.util.Calendar; public class YearCalendar { public static void
 * main(String[] args) { Calendar calendar = Calendar.getInstance();
 * System.out.println("The current date is : " + calendar.getTime());
 * calendar.add(Calendar.DATE, -15); System.out.println("15 days ago: " +
 * calendar.getTime()); calendar.add(Calendar.MONTH, 4);
 * System.out.println("4 months later: " + calendar.getTime());
 * calendar.add(Calendar.YEAR, 2); System.out.println("2 years later: " +
 * calendar.getTime()); } }
 */  

import java.time.*;  
import java.time.temporal.*;  
public class MonthEnumExample1 {  
    public static void main(String[] args) {  
        Month month = Month.valueOf("January".toUpperCase());  
        System.out.printf("For the month of %s all Sunday are:%n", month);  
        LocalDate localdate = Year.now().atMonth(month).atDay(1).  
        with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));  
        Month mi = localdate.getMonth();  
        while (mi == month) {  
            System.out.printf("%s%n", localdate);  
            localdate = localdate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));  
            mi = localdate.getMonth();  
        }  
    }  
}  