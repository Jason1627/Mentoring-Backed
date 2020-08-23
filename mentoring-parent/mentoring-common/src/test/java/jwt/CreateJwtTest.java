package jwt;/*
 * @program: tensquare_parent
 * @Date: 2020-04-28 16:21
 * @Author: Jason
 * @Description:
 */

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJwtTest {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();  // 当前时间
        long exp=now+1000*60; // 过期时间为一分钟
        JwtBuilder builder = Jwts.builder()
                .setId("666")
                .setSubject("佳兴")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itcast")
                .setExpiration(new Date(exp))
                .claim("roles","admin");
        System.out.println(builder.compact());
    }
}
