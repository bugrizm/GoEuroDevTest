package com.goeuro.javadevtest;

import org.json.JSONArray;

public class Application {
	
	public static void main(String[] args) {
		if(args.length == 0) {
			throw new RuntimeException("City name should be passed for first argument");
		}
		
		String cityName = args[0];

		CityController cityController = new CityController();
		JSONArray cityDetailsArray = cityController.searchCityDetails(cityName);
		new CSVGenerator().jsonArrayToCSVGenerator(cityDetailsArray, cityName);
	}
}
