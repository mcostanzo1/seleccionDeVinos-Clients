package com.dp3.domain;


import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "clients")
public class PriceList {

    @Id
    @JsonProperty()
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private String listCode;
    private String listName;
    private String productName;
    private String listPrice;
    private String listPriceFinal;


    public PriceList() {
        super();
    }


    public PriceList(@JsonProperty("listCode") String listCode, @JsonProperty("listName") String listName, @JsonProperty("productName") String productName, @JsonProperty("listPrice") String listPrice, @JsonProperty("listPriceFinal") String listPriceFinal) {
        this.listCode = listCode;
        this.listName = listName;
        this.productName = productName;
        this.listPrice = listPrice;
        this.listPriceFinal = listPriceFinal;
    }

    public String getListCode() {
        return listCode;
    }

    public void setListCode(String listCode) {
        this.listCode = listCode;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getListPriceFinal() {
        return listPriceFinal;
    }

    public void setListPriceFinal(String listPriceFinal) {
        this.listPriceFinal = listPriceFinal;
    }
}