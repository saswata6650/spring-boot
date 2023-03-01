package org.im.quotes.controller;


import org.im.quotes.model.RegistrationModel;

import org.im.quotes.srevice.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

@RestController
public class QuotesController {

    private static final Logger log = LoggerFactory.getLogger(QuotesController.class);

    @Autowired
    private PersonService personService;

   

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/addperson/{experiance}")
    public ResponseEntity<RegistrationModel> addPerson(@Valid @RequestBody  RegistrationModel registrationModel ,@PathVariable(required = false) String experiance) {
    	if (experiance == null) 
    		experiance = "0"; 
    	registrationModel.setExperiance(Integer.parseInt(experiance
    			)); 
        return personService.addRegistration(registrationModel);

    }

   

    @GetMapping("/person/{person}")
    public ResponseEntity<List<RegistrationModel>> getByPerson(@PathVariable String person) {

        return personService.getByPersonByName(person);
    }

   

}
