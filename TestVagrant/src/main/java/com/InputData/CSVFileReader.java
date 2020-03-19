package com.InputData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.interfaces.FileReadr;

public class CSVFileReader implements FileReadr {

	public static BufferedReader reader;
	public static Float sum = 0f;
	int totalNumberOfDays, totalNumberOfSaturdays, totalNumberOfSundays, totalweekdays;
	float weekdaysTotalPrice, saturdaysPrice, sundayprice, sundaysprice, totalprice, weekdaysPrice, saturdayPrice;

	String[] row;
	public static int flag;
	String[] newspapers;
	public List<String> categories = new ArrayList<String>();
	public static HashMap<Integer, Object> hm = new HashMap<Integer, Object>();

	public void displayCategories() throws FileNotFoundException, IOException {

		rowDataReader("Categories:");

	}

	public void selectedNewsPaper(int rowumbern) throws FileNotFoundException, IOException {

		Object obj = hm.get(rowumbern);
		rowDataReader(String.valueOf(obj));

	}

	public void rowDataReader(String header) {
		String line = "";
		String DELIMITER = ",";
		flag = 0;
		try {

			reader = Files.newBufferedReader(Paths.get(("CSVfiles\\Inputdata.csv")));

			while ((line = reader.readLine()) != null) {
				String[] columns = line.split(DELIMITER);
				if (columns[0].equalsIgnoreCase(header)) {
					flag++;
					System.out.println(columns[0]);
					for (int row = 1; row < columns.length; row++) {
						hm.put(row, columns[row]);
						System.out.println(row + "." + columns[row]);
					}
				}

			}
			if (flag == 0) {
				System.out.println("Category/Item is not added");
				System. exit(0);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

	}

}
