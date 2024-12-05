package com.eunkk.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatedAndEditRestaurantRequestMenu {
    private final String name;
    private final Integer price;


}
