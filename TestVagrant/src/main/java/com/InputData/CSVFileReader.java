package com.InputData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.classfile.MonthDaysExample;
import com.interfaces.FileReadr;
import com.opencsv.CSVReader;

public class CSVFileReader implements FileReadr {
	CSVReader reader = null;
	float weekdaysPrice, saturdayPrice;

	int totalNumberOfDays, totalNumberOfSaturdays, totalNumberOfSundays, totalweekdays;
	float weekdaysTotalPrice, saturdaysPrice, sundayprice, sundaysprice, totalprice;

	String[] row;
	String[] newspapers;
	static List<String[]> allRows;
	HashMap<String, Object> newspaperObj = new HashMap<String, Object>();
	public MonthDaysExample cal;

	public String[] rowData(int rownumber) throws FileNotFoundException, IOException {

		try {

			CSVReader reader = new CSVReader(new FileReader("CSVfiles\\Inputdata.csv"));
			allRows = reader.readAll();
			row = allRows.get(rownumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	public void availableNewspapers() throws FileNotFoundException, IOException {

		row = rowData(0);

		for (int i = 0; i < row.length; i++) {
			System.out.println(i + 1 + "." + row[i]);
		}

	}

	public void selectedNewsPaper(int rowumbern) throws FileNotFoundException, IOException {
		String newspaperName;
		newspapers = rowData(0);
		String paperName = newspapers[rowumbern - 1];
		System.out.println("Selected NewsPaper is--->" + newspapers[rowumbern - 1]);
		paperTotalPrice(paperName, 10 + rowumbern - 1);
	}

	public void paperTotalPrice(String paperName, int num) throws FileNotFoundException, IOException {
		
		String[] price = rowData(num);
		weekdaysPrice = Float.parseFloat(price[0]);
		saturdayPrice = Float.parseFloat(price[1]);
		sundayprice = Float.parseFloat(price[2]);

		cal = new MonthDaysExample(2010, 2);
		int totalNumberOfDays = cal.totalNumberOfDays();
		int totalNumberOfSaturdays = cal.numberofSaturdays();
		int totalNumberOfSundays = cal.numberofSundays();
		int totalweekdays = totalNumberOfDays - (totalNumberOfSaturdays + totalNumberOfSundays);
		
		weekdaysTotalPrice = totalweekdays * weekdaysPrice;
		saturdaysPrice = totalNumberOfSaturdays * saturdayPrice;
		sundaysprice = totalNumberOfSundays * sundayprice;
		totalprice = weekdaysTotalPrice + saturdaysPrice + sundaysprice;
		
		System.out.println("Total month cost for " + paperName + " News Papaer is =" + totalprice);

	}

}
