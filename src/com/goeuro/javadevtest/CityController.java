package com.goeuro.javadevtest;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CityController {
	
	private static final String CITY_DETAILS_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	public JSONArray searchCityDetails(String cityName) {
		String url = CITY_DETAILS_URL + cityName;
		
		HttpResponse<JsonNode> jsonResponse;
		try {
			jsonResponse = Unirest.get(url).asJson();
		} catch (UnirestException e) {
			throw new RuntimeException("Error while reading data.");
		}
		
		String rawJson = new HttpJsonResponseToStringConverter().read(jsonResponse);			
		JSONArray jsonArray = new JSONArray(rawJson);
		
		return jsonArray;
	}
	
}
