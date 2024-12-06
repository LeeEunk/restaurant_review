package com.eunkk.review.api;

import com.eunkk.review.api.request.CreatedAndEditRestaurantRequest;
import com.eunkk.review.api.response.RestaurantDetailView;
import com.eunkk.review.api.response.RestaurantView;
import com.eunkk.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    
    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.getRestaurantDetail(restaurantId);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(
            @RequestBody CreatedAndEditRestaurantRequest request
            ) {
        restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreatedAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);

        return restaurantId + " 번의 레스토랑이 삭제되었습니다.";
    }
}
