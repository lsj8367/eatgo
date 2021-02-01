package com.example.test.eatgo.eatgo.application;

import com.example.test.eatgo.eatgo.domain.Restaurant;
import com.example.test.eatgo.eatgo.domain.RestaurantRepository;
import com.example.test.eatgo.eatgo.domain.RestaurantRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @BeforeEach // 모든 테스트 실행전에 실행해줌
    public void setUp(){
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId()).isEqualTo(1004L);
    }
}