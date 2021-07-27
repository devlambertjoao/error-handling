package com.lambert.errorhandling.exception;

public class JsonConvertionException extends RuntimeException {

	public JsonConvertionException() {
		super("Error on read/parse JSON");
	}
}
