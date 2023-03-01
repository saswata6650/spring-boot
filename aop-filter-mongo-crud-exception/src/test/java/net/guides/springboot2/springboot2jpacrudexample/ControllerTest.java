package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.im.quotes.QuotesApiApplication;
import org.im.quotes.model.RegistrationModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuotesApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/person/Sam",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	

	@Test
	public void testCreateEmployee() {
		RegistrationModel person = new RegistrationModel();
		person.setAge(29);
		person.setName("Peter");
		person.setLocation("France");

		ResponseEntity<RegistrationModel> postResponse = restTemplate.postForEntity(getRootUrl() + "/addpersons", person, RegistrationModel.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		
	}

	
}
