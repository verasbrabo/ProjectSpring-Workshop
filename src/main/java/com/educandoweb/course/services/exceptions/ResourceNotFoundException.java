package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersiontUID =1L;

    public ResourceNotFoundException (Object obj){
        super ("Resource not found. Id" + obj);

    }
}
