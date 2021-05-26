package com.example.test.eatgo.eatgo.application;

import com.example.test.eatgo.eatgo.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);

        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional //별도의 save없이 트랜잭션 처리를 하여 변경내용을 저장해줌
    public Restaurant updateRestaurant(Long id, String name, String address) {
        // TODO : 정보 수정하기
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        if(restaurant != null)
            restaurant.updateInformation(name, address);

        return restaurant;
    }
}
