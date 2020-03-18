package com.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReadr {
	public String[] rowData(int i) throws FileNotFoundException, IOException;

	public void paperTotalPrice(String paperName, int num) throws FileNotFoundException, IOException;
}
