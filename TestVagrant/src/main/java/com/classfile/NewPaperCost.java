package com.classfile;

import java.io.IOException;
import java.util.HashMap;

import com.InputData.CSVFileReader;

public class NewPaperCost {
	
	public static CSVFileReader csvreader;
	HashMap<String,Integer> allnewspapers;
	
public static void main(String[] args) {
csvreader=new CSVFileReader();
}
public void paperCost() throws IOException {
	allnewspapers=new HashMap<String, Integer>();
	String []newspapers=csvreader.availableNewspapers(0);
	

}
}
