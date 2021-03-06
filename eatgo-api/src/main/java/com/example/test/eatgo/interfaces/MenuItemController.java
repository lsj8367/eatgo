package com.example.test.eatgo.interfaces;

import com.example.test.eatgo.application.MenuItemService;
import com.example.test.eatgo.domain.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuItems")
    public String bulkUpdate(@RequestBody List<MenuItem> menuItems, @PathVariable("restaurantId") Long restaurantId){
        menuItemService.bulkUpdate(restaurantId, menuItems);
        return "";
    }
}
