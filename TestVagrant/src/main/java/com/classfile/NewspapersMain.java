package com.classfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.InputData.CSVFileReader;

public class NewspapersMain {
	public static CSVFileReader csvfile;
	public static NewspapersMain newspapersmain;

	public void categories() throws IOException {

		csvfile.displayCategories();

	}

	public void selection() throws NumberFormatException, FileNotFoundException, IOException {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Select an Item from the List:");
		String num = myObj.nextLine();
		csvfile.selectedNewsPaper(Integer.parseInt(num));
	}

	public void display_subaCategories() throws NumberFormatException, FileNotFoundException, IOException {
		for (int i = 0; i < 3; i++) {
			newspapersmain.selection();
		}
	}

	public static void main(String[] args) throws IOException {
		newspapersmain = new NewspapersMain();
		NewPaperCost totalnewspapercost = new NewPaperCost();
		csvfile = new CSVFileReader();
		System.out.println("Select from the Category:");
		newspapersmain.categories();
		newspapersmain.display_subaCategories();
		totalnewspapercost.paperTotalPrice();

	}

}
