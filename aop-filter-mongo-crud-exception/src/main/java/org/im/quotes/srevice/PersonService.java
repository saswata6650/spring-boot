package org.im.quotes.srevice;

import java.util.List;
import java.util.stream.Collectors;

import org.im.quotes.controller.QuotesController;
import org.im.quotes.exceptions.LocationException;
import org.im.quotes.exceptions.UserNotFoundException;
import org.im.quotes.model.RegistrationModel;
import org.im.quotes.repository.PersonReository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class PersonService  {
	
	 private static final Logger log = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	PersonReository personReository ;
	
	public ResponseEntity<List<RegistrationModel>> getByPersonByName(String person) {

		
		List<RegistrationModel> personList = personReository.findAll();
		List<RegistrationModel> astList = personList.stream().filter(persons -> person.equals(persons.getName())).collect(Collectors.toList());
        if (astList.size() == 0)
        	throw new UserNotFoundException("Person not found in Data Base Registration ");

        return ResponseEntity.status(HttpStatus.OK).body(astList);
        
    }
	
	
    public ResponseEntity<RegistrationModel> addRegistration(RegistrationModel registrationModel) {

    	if (registrationModel == null)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            
    	if (!"France".equals(registrationModel.getLocation()))
			throw new LocationException("Country Not France" + registrationModel.getLocation());
    	
        personReository.save(registrationModel);
        
        //log.info("Saved Registration Info="+registrationModel.toString());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationModel);

    }
	
	

}
