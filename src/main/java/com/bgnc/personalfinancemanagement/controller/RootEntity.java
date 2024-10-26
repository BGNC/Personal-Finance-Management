package com.bgnc.personalfinancemanagement.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {

    private T payload;
    private Integer status;
    private String message;

    public static <T> RootEntity<T> ok(T payload){
        RootEntity<T> result = new RootEntity<T>();
        result.setPayload(payload);
        result.setStatus(HttpStatus.ACCEPTED.value());
        result.setMessage(null);
        return result;
    }

    public static <T> RootEntity<T> error(String message){
        RootEntity<T> result = new RootEntity<T>();
        result.setPayload(null);
        result.setStatus(HttpStatus.BAD_REQUEST.value());
        result.setMessage(message);
        return result;
    }
}
