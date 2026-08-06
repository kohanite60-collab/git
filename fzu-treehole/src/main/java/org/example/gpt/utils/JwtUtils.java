package org.example.gpt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    private final String secret ="113252535353535353666667777777777489958904049487857849475784829292929292";
    private final long expire = 1000*60*60*24;

    private final SecretKey key= Keys.hmacShaKeyFor(secret.getBytes());




    public String createjwt(Long userid){
        // 创建JWT构建器实例

         String token = Jwts.builder()
                .setSubject(userid.toString())
                // 创建时间
                .setIssuedAt(
                        new Date()
                )

                // 过期时间
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60 * 2
                        )
                )


                // 签名
                .signWith(
                        key,
                        SignatureAlgorithm.HS256
                )

                // 生成字符串
                .compact();

        System.out.println(token);
        return token;

    }

    /**
     * 解析JWT
     */
    public Long parseToken(String token){


        Claims claims =
                Jwts.parserBuilder()

                        // 使用同一个密钥验证
                        .setSigningKey(key)

                        .build()

                        //解析token
                        .parseClaimsJws(token)

                        //获取Payload
                        .getBody();



        return Long.valueOf(
                claims.getSubject()
        );

    }





    }
