package com.eunkk.review.repository;

import com.eunkk.review.model.QReviewEntity;
import com.eunkk.review.model.ReviewEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public Double getAvgScoreByRestaurantId(Long restaurantId) { //맛집에 등록된 평균 별점 가져오기
        return queryFactory.select(QReviewEntity.reviewEntity.score.avg())
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .fetchFirst();
    }

    @Override
    public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page) {
        List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .offset((long)page.getPageNumber() * page.getPageSize()) //0번부터 가져와 10번부터 가져와 페이지네이션
                .limit(page.getPageSize() + 1) // 5개단위이냐 10개 단위이냐
                .fetch();

        return new SliceImpl<>(
                reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize()
                );
    }
}
