package com.example.test.eatgo.eatgo.interfaces;

import com.example.test.eatgo.eatgo.domain.MenuItem;
import com.example.test.eatgo.eatgo.domain.MenuItemRepository;
import com.example.test.eatgo.eatgo.domain.Restaurant;
import com.example.test.eatgo.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        //Restaurant restaurant = restaurantService.getRestaurantById(id);
        // 기본정보 + 메뉴 정보

        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);

        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

}
