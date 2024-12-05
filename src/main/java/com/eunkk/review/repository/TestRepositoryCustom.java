package com.eunkk.review.repository;

import com.eunkk.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public interface TestRepositoryCustom {

    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
