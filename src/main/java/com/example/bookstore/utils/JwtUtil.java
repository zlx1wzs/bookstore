package com.example.bookstore.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 *
 * @author wzs
 */
@Configuration
public class JwtUtil {

    private static final String USER_ID = "id";
    private static long EXPIRATION_TIME = 3600000 * 24; // 24 hour
    private static String SECRET = "3f01dd07-7dc2-4508-b56f-bd80e36c72d6";// 秘钥

    /**
     * 生成jwtToken
     *
     * @param id
     * @return
     */
    public static String generateToken(String id) {
        HashMap<String, Object> map = new HashMap<>();
        // you can put any data in the map
        map.put(USER_ID, id);
        String token = Jwts.builder().setClaims(map).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return token;
    }

    /**
     * 校验jwtToken
     *
     * @param token
     * @return
     */
    public static String validateToken(String token) throws AgainLoginException {
        //AssertUtils.assertNotNull(token, ResultType.AGAIN_LOGIN, "Missing token");
        try {
            Map<String, Object> body = Jwts.parser().setSigningKey(SECRET).
                    parseClaimsJws(token).getBody();
            String id = (String) (body.get(USER_ID));
            return id;
        } catch (Exception e) {
            throw new AgainLoginException("未登录，或登录过期，请登录");
        }
    }
}