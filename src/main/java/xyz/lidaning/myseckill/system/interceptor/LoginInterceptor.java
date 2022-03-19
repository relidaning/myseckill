package xyz.lidaning.myseckill.system.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("jsessionId") && redisTemplate.hasKey("user:"+cookie.getValue())){
                return true;
            }
        }
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }
}
