
package com.bharath.springboot.reponse;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Example {

    private String kind;
    private Integer totalItems;
    private List<Item> items = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
