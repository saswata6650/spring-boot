package com.bharath.springboot;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
//import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.bharath.springboot.errorhandeling.UserNotFoundException;
import com.bharath.springboot.reponse.Example;
import com.bharath.springboot.reponse.Item;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HelloController {

	static public long startMillis = System.currentTimeMillis();
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${google.isbn.url}")
	private String valueFromFile;
	
	@RequestMapping(value = "/isbn/{id}", method = RequestMethod.GET )
	public Example contextLoads(@PathVariable(name="id" , required= true) String isbn ) throws JsonParseException, JsonMappingException, IOException {
        
		 long startMillis = System.currentTimeMillis();
		 
		String resourceUrl = valueFromFile + isbn;
		
		System.out.println("the response is " + resourceUrl ) ;
		
		
			ResponseEntity<String> entity = restTemplate.getForEntity(resourceUrl , String.class);
			ObjectMapper objectMapper = new ObjectMapper();
	        Example node = objectMapper.readValue(entity.getBody(), Example.class);
	        List<Item> item = node.getItems();
	        if (item == null ) {
	        	throw new UserNotFoundException("book not found");
	        }
	        		
	        //JsonNode items = node.get("items");
			//return  items.get(0).get("volumeInfo").get("title");
	        return node;
		
	}
	
	

}
