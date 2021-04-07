package com.example.test.eatgo.eatgo.interfaces;

import com.example.test.eatgo.eatgo.application.RestaurantService;
import com.example.test.eatgo.eatgo.domain.MenuItem;
import com.example.test.eatgo.eatgo.domain.MenuItemRepository;
import com.example.test.eatgo.eatgo.domain.Restaurant;
import com.example.test.eatgo.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin //CORS문제 해결
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        // 기본정보 + 메뉴 정보
//        Restaurant restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant resource) //유효성 검사를 하기 위해서 Valid 어노테이션 추가 gradle에서도 javax.validation 추가해줌
            throws URISyntaxException {
        Restaurant restaurant = restaurantService.addRestaurant(Restaurant.builder()
                                                .name(resource.getName())
                                                .address(resource.getAddress())
                                                .build());

        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id, @Valid @RequestBody Restaurant resource){ //유효성 검사 Valid 어노테이션 추가
        String name = resource.getName();
        String address = resource.getAddress();

        restaurantService.updateRestaurant(id, name, address);

        return "{}";
    }
}
