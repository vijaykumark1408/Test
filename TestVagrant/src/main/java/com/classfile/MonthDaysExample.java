package com.classfile;

import java.util.Calendar;

public class MonthDaysExample {
	public static Calendar calendar;
	public static int maxDayinMonth;
	public static int year, month;
	public static int count = 0;
	public static int dayOfWeek;

	public MonthDaysExample(int year, int month) {
		// First get an instance of calendar object.

		MonthDaysExample.month = month;
		MonthDaysExample.year = year;
		calendar = Calendar.getInstance();

		calendar.set(year, month - 1, 1);

	}

	public int totalNumberOfDays() {
		maxDayinMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("Maximum Days in the month: " + maxDayinMonth);
		return maxDayinMonth;
	}

	public int numberofSundays() {
		count = 0;

		for (int day = 1; day <= maxDayinMonth; day++) {
			calendar.set(year, month - 1, day);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SUNDAY) {
				count++;
			}
		}
		System.out.println("Total number of Sundays-----> " + count);
		return count;
	}

	public int numberofSaturdays() {
		count = 0;

		for (int day = 1; day <= maxDayinMonth; day++) {
			calendar.set(year, month - 1, day);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SATURDAY) {
				count++;
			}

		}
		System.out.println("Total number of Staturdays------> " + count);
		return count;
	}

}
