package org.im.quotes.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;



@Repository
@Document(collection = "registration_db")
public class RegistrationModel {

    
	@Size(min=2, message="Name should have atleast 2 characters")
	@NotNull(message = "Name cannot be null")
	private String name;
	@Min(value = 18, message = "age should not less than 18")
    private int age;
	@NotNull(message = "Location cannot be null")
    private String location ;
    private int experiance ;
    
    public RegistrationModel() {

    }

    public RegistrationModel(String name,int age, String location, int experiance ) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.experiance = experiance;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
	
	public int getExperiance() {
		return experiance;
	}

	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}

	@Override
	public String toString() {
		return "RegistrationModel [name=" + name + ", age=" + age + ", location=" + location + "]";
	}
   
}
