package org.example.gpt;

import org.example.gpt.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GptApplicationTests {
    @Autowired
    private JwtUtils jwt;
    @Test
    void contextLoads() {

        System.out.println(jwt.createjwt(1L));

        System.out.println(jwt.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzg2MDI1ODgxLCJleHAiOjE3ODYwMzMwODF9.0ZeEtLhAjdn3pALvZjDdVUkUJ6KMT7encfPnVouqUSE"));

    }

}
