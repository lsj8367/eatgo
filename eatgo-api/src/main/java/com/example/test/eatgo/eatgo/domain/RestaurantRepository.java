package com.example.test.eatgo.eatgo.domain;


import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository(){
        restaurants.add(new Restaurant(1004L,"Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id)) //Restaurant객체에 arrayList인 restaurant를 차례대로 뽑는데 //받은값의 id와 같으면
                .findFirst() //첫번째 리스트를 가져와서
                .orElse(null); //예외처리까지 한경우
                //.get(); //Restaurant 객체인 restaurant 에게 값을 담아준다.
    }
}
