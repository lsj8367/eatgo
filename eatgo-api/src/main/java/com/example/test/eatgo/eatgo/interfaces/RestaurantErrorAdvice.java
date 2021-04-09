package com.example.test.eatgo.eatgo.interfaces;

import com.example.test.eatgo.eatgo.domain.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestaurantErrorAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) //404에러
    @ExceptionHandler(RestaurantNotFoundException.class)
    public String handleNotFound(){
        // 에러가 처리되는곳
        return "{}";
    }
}
