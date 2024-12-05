package com.eunkk.review.repository;

import com.eunkk.review.model.QTestEntity;
import com.eunkk.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// Impl 구현 클래스 접미사를 뜻함
@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl implements TestRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity).fetch();
    }
}
