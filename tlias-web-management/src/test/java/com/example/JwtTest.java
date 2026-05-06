package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    /*
     * 生成JWT令牌 - Jwts.builder()
     */
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "dGxpYXM=") // 指定加密算法和密钥
                .addClaims(dataMap) // 添加自定义信息
                .setSubject("tlias") // 添加主题
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 设置令牌过期时间一个小时
                .compact();  // 生成令牌
        System.out.println(jwt);
    }

    /*
     * 解析JWT令牌 - Jwts.parser()
     */
    @Test
    public void testParseJwt() {
        /*
         JWT的组成： （JWT令牌由三个部分组成，三个部分之间使用英文的点来分割）
            - 第一部分：Header(头）， 记录令牌类型、签名算法等。 例如：{"alg":"HS256","type":"JWT"}
            - 第二部分：Payload(有效载荷），携带一些自定义信息、默认信息等。 例如：{"id":"1","username":"Tom"}
            - 第三部分：Signature(签名），防止Token被篡改、确保安全性。将header、payload，并加入指定秘钥，通过指定签名算法计算而来。
         */
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsInN1YiI6InRsaWFzIiwiZXhwIjoxNzc4MTA2NzU4fQ.z-CCyOO7rhdjr1skQoZCwBrpL6qa-o0kJotqpOnTR14";
        Claims claims = Jwts.parser().setSigningKey("dGxpYXM=")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
