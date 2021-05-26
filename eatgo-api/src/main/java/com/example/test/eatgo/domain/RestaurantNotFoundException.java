package com.example.test.eatgo.domain;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(long id) {
        super("Could not find restaurant" + id); //이런 아이디를 찾을수 없다.
    }
}
