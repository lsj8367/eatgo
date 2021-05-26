package com.example.test.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantTests {

    @Test
    public void creation(){
        //Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(restaurant.getName()).isEqualTo("Bob zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
    }
}