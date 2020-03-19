package com.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReadr {
	public void displayCategories() throws FileNotFoundException, IOException;

	public void rowDataReader(String header);

}
