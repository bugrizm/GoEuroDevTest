package com.goeuro.javadevtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class HttpJsonResponseToStringConverter {
	
	public String read(HttpResponse<JsonNode> json) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(json.getRawBody()));
		
		String line;
		String rawJson = "";
		
		try {
			while((line = reader.readLine()) != null) {
				rawJson += line + "\n";
			}
		} catch (IOException e) {
			throw new RuntimeException("Error reading data.");
		}
		
		return rawJson;
	}
	
}
