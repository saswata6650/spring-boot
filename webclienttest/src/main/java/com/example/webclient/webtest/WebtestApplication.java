package com.example.webclient.webtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebtestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WebtestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WebClient webClient = WebClient.create("https://saswatajava.com");
		Data data = new Data();
		MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
		bodyValues.add("token", "jyfulyfluygkjbkjbiy500");
		  String block = webClient.post()
		.uri("/test4.php")
		.header("Authorization", "Bearer MY_SECRET_TOKEN")
		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
	    .accept(MediaType.APPLICATION_JSON)
	    .body(BodyInserters.fromFormData(bodyValues))
	    .retrieve()
	    .bodyToMono(String.class)
	    .block();
		 System.out.println("Out Put :"+ block) ;
		
	}

}
