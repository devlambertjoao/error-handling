package com.lambert.errorhandling.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lambert.errorhandling.exception.JsonConvertionException;

public class JsonUtils {

	public static String toJson(Object obj) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objMapper.registerModules(new JavaTimeModule());

			return objMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new JsonConvertionException();
		}
	}

	public static Object toObject(String json, Object obj) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
	  	return objMapper.readValue(json, obj.getClass());
		} catch (Exception e) {
			throw new JsonConvertionException();
		}
	}
}
