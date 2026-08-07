package org.example.gpt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class redistest {
    @Autowired
    RedisTemplate redisTemplate;


    @Test
    void redistest(){




            redisTemplate.opsForValue()
                    .set("name","Tom");

            System.out.println(
                    redisTemplate.opsForValue()
                            .get("name")
            );



    }
}
