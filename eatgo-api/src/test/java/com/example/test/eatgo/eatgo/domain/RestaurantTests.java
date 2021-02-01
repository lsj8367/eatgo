package com.example.test.eatgo.eatgo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

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