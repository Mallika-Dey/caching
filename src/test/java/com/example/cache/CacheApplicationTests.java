package com.example.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class CacheApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testRedisConnection() {
        redisTemplate.opsForValue().set("1", "redis connected");
        System.out.println(redisTemplate.opsForValue().get("1")) ;
    }

}
