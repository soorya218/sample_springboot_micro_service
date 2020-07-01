package com.microservice.sample.helpers.responsemodels;

import java.util.Date;

public class GenericResponse {

    private Date timestamp;
    private String message;
    private Object responseObject;

    public GenericResponse() {
        this.timestamp = new Date();
    }

    public GenericResponse(Object responseObject, String message) {
        this.timestamp = new Date();
        this.message = message;
        this.responseObject = responseObject;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
