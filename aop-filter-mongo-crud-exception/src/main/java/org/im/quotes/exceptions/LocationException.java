package org.im.quotes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LocationException extends RuntimeException{
   
	public LocationException(String message) {
		super(message);
	}
}
