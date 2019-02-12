package com.qa.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JackSonUtil {
	
	private ObjectMapper objMapper;

	public JackSonUtil() {
		this.objMapper = new ObjectMapper();
	}
	
	public String getJSONFromObject(Object obj) {
		try {
			return objMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "cannot read object";
		}
	}
	public <T> T getObjectFromJSON(String jsonString, Class<T> clazz) {
		
		try {
			return objMapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			System.out.println("Parse Error");
			return null;
		} catch (JsonMappingException e) {
			System.out.println("Mapping Error");
			return null;
		} catch (IOException e) {
			System.out.println("I/O Error");
			return null;
		}
	}

}
