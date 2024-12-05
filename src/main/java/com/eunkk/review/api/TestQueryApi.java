package com.eunkk.review.api;

import com.eunkk.review.model.TestEntity;
import com.eunkk.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa() {
        return testService.findAllByNameByJPA("eunkk");
    }

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> queryQueryDsl() {
        return testService.findAllByNameByQuerydsl("eunkk");
    }
}
