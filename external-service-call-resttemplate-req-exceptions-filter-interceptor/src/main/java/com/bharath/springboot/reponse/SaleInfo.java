
package com.bharath.springboot.reponse;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SaleInfo {

    private String country;
    private String saleability;
    private Boolean isEbook;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public Boolean getIsEbook() {
        return isEbook;
    }

    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

}
