package com.eunkk.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreatedAndEditRestaurantRequest {
    private final String name;
    private final String address;
    private final List<CreatedAndEditRestaurantRequestMenu> menus;


}
