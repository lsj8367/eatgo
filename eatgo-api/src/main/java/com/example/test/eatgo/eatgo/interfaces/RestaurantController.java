package com.example.test.eatgo.eatgo.interfaces;

import com.example.test.eatgo.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        restaurants.add(restaurant);

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1004L,"Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));

        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(id)) //Restaurant객체에 arrayList인 restaurant를 차례대로 뽑는데 //받은값의 id와 같으면
                .findFirst() //첫번째 리스트를 가져와서
                .orElse(null); //예외처리까지 한경우
                //.get(); //Restaurant 객체인 restaurant 에게 값을 담아준다.

        return restaurant;
    }

}
