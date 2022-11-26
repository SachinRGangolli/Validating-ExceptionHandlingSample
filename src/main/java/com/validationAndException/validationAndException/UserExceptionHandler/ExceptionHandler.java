package com.validationAndException.validationAndException.UserExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException ex){
        Map<String,String> errMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error-> {
            errMap.put(error.getField(), error.getDefaultMessage());
        });
        return errMap;
    }
}
