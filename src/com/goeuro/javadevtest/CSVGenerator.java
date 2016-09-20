package com.goeuro.javadevtest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;

public class CSVGenerator {
	
	public void jsonArrayToCSVGenerator(JSONArray jsonArray, String fileName) {
		File file = new File(fileName + ".csv");
		String csv = CDL.toString(jsonArray);
		
		try {
			FileUtils.writeStringToFile(file, csv);
			System.out.println("Output file saved to : " + file.getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException("Error while saving json array to csv file:\n" + e.getMessage());
		}
	}
	
}
