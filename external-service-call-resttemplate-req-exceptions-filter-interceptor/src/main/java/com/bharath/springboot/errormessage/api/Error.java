
package com.bharath.springboot.errormessage.api;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Error {

    private Integer code;
    private String message;
    private List<Errors> errors = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

}
