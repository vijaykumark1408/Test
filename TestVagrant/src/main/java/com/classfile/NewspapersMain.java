package com.classfile;

import java.io.IOException;
import java.util.Scanner;

import com.InputData.CSVFileReader;

public class NewspapersMain {
	public static CSVFileReader csvfile;
	public static NewspapersMain newspapersmain;

	public void categories() throws IOException {
		System.out.println("Categories:");
		System.out.println("Availability of NewsPapers:");
		csvfile.availableNewspapers();

		// Output user input

	}

	public static void main(String[] args) throws IOException {
		newspapersmain = new NewspapersMain();
		csvfile = new CSVFileReader();
		
		
		newspapersmain.categories();

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); 
		System.out.println("Select the NewsPaper:");
		String num = myObj.nextLine(); 

		csvfile.selectedNewsPaper(Integer.parseInt(num));

	}

}
