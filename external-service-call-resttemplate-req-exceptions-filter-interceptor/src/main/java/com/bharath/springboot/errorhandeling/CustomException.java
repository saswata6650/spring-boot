package com.bharath.springboot.errorhandeling;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomException extends RuntimeException {
	public CustomException(String message) throws IOException {
		super(message);
		
        
    }
}
