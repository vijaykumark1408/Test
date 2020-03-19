package com.classfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.InputData.CSVFileReader;

public class NewPaperCost extends CSVFileReader {
	public static CSVFileReader csvreader;
	public static MonthCalendar cal;
	public static Float rate[] = new Float[8];
	public String date[] = new String[2];

	public NewPaperCost() throws IOException {
		// TODO Auto-generated constructor stub
	}

	public void date() {
		String line = "";
		String DELIMITER = ",";

		try {
			reader = Files.newBufferedReader(Paths.get(("CSVfiles\\Inputdata.csv")));
			while ((line = reader.readLine()) != null) {
				String[] columns = line.split(DELIMITER);
				if (columns[0].equalsIgnoreCase("date")) {
					System.out.println(columns[0]);
					for (int i = 1; i < columns.length; i++) {
						date[i - 1] = columns[i];

					}
				}
			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public static void main(String[] args) throws IOException {
		csvreader = new CSVFileReader();
	}

	public void paperTotalPrice() throws FileNotFoundException, IOException {
		date();
		int year = Integer.valueOf(date[1]);
		int month = Integer.valueOf(date[0]);
		cal = new MonthCalendar(year, month);

		int totalNumberOfDays = cal.totalNumberOfDays();
		int totalNumberOfSaturdays = cal.numberofSaturdays();
		int totalNumberOfSundays = cal.numberofSundays();
		int totalweekdays = totalNumberOfDays - (totalNumberOfSaturdays + totalNumberOfSundays);

		for (int key = 1; key < 8; key++) {
			String indexValue = String.valueOf(hm.get(key));
			rate[key] = Float.valueOf(indexValue);

		}

		Float totalNewsPaperPrice = totalweekdays * rate[1] + totalNumberOfSaturdays * rate[6]
				+ totalNumberOfSundays * rate[7];
		System.out.println("Total cost of the item=" + totalNewsPaperPrice);
	}

}
