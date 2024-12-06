package com.eunkk.review.service.dto;

import com.eunkk.review.model.ReviewEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewDtoPage {
        private Integer offset;
        private Integer limit;
    }
}
