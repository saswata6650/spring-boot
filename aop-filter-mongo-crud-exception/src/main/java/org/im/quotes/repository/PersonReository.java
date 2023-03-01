package org.im.quotes.repository;

import java.util.List;

import org.im.quotes.model.RegistrationModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonReository extends MongoRepository<RegistrationModel,String> {
    
   

	List<RegistrationModel> findByName(String person);

}
