package com.dp3.domain;


import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "clients")
public class Client{

    @Id
    @JsonProperty()
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private String clientCode;
    private String clientName;
    private String clientPhone;
    private String clientLocation;
    private String clientEmail;


    public Client() {
        super();
    }




    public Client(@JsonProperty("clientCode")String clientCode, @JsonProperty("clientEmail")String clientEmail, @JsonProperty("clientName") String clientName, @JsonProperty("clientPhone")String clientPhone, @JsonProperty("clientLocation") String clientLocation) {
        this.clientCode = clientCode;
        this.clientName = clientName;
        this.clientPhone = clientLocation;
        this.clientPhone = clientPhone;

        this.clientEmail = clientEmail;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
