package com.classfile;

import java.io.IOException;
import java.util.Scanner;

import com.InputData.CSVFileReader;

public class NewspapersMain {
	public static CSVFileReader csvfile;
	public static NewspapersMain newspapersmain;

	public void categories() throws IOException {
		System.out.println("Select Category:\n");
		csvfile.displayCategories();

	}

	public static void main(String[] args) throws IOException {
		newspapersmain = new NewspapersMain();
		csvfile = new CSVFileReader();
	
		// display categories
		newspapersmain.categories();

		// select category
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		
		String num = myObj.nextLine();
		System.out.println("Select the sub category:\n");
		csvfile.selectedNewsPaper(Integer.parseInt(num));

		// select news paper
		@SuppressWarnings("resource")

		Scanner myObj1 = new Scanner(System.in);
		String num1 = myObj1.nextLine();

		csvfile.selectedNewsPaper(Integer.parseInt(num1));

		@SuppressWarnings("resource")
		Scanner myObj2 = new Scanner(System.in);
		System.out.println("Select Item\n");
		String num2 = myObj2.nextLine();
		csvfile.selectedNewsPaper(Integer.parseInt(num2));

		NewPaperCost totalnewspapercost = new NewPaperCost();
		totalnewspapercost.paperTotalPrice();

	}

}
