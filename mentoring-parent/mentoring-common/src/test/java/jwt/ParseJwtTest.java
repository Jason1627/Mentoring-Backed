package jwt;/*
 * @program: tensquare_parent
 * @Date: 2020-04-28 16:27
 * @Author: Jason
 * @Description:
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest {
    public static void main(String[] args) {
      String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLkvbPlhbQiLCJpYXQiOjE1ODgwNjM4NDMsImV4cCI6MTU4ODA2MzkwMywicm9sZXMiOiJhZG1pbiJ9.4x2dbvBdVMjR-rhmQIE8rccpJ7NtK-c0egc0cExwi6k";
        Claims claims= Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println("id："+claims.getId());
        System.out.println("用户名："+claims.getSubject());
        System.out.println("登陆时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色："+claims.get("roles"));

    }
}
