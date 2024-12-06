package com.eunkk.review.repository;

import com.eunkk.review.model.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReviewRepositoryCustom {

    Double getAvgScoreByRestaurantId(Long restaurantId);
    Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page);
}
