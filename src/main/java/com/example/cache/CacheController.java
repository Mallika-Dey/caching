package com.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people")
@EnableCaching
public class CacheController {
    private final TestTableService testTableService;

    public CacheController(TestTableService testTableService) {
        this.testTableService = testTableService;
    }


    @GetMapping
    @Cacheable(key = "#name", cacheNames = "test_table")
    public ResponseEntity<?> convertKanji(@RequestParam("name") String name) {
        return ResponseEntity.ok(testTableService.getTable(name));
    }
}
