package xyz.lidaning.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.lidaning.myseckill.user.domain.User;
import xyz.lidaning.myseckill.user.service.IUserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String index(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User queryUser = new User();
        queryUser.setUsername(username);
        queryUser.setPassword(password);
        List<User> users = userService.selectUserList(queryUser);
        if(users==null||users.size()<1){
            throw new Exception("error username or password!");
        }
        String uuid = UUID.randomUUID().toString();
        User user = users.get(0);
        redisTemplate.opsForValue().set("user:"+uuid, user, 2, TimeUnit.HOURS);
        Cookie cookie=new Cookie("jsessionId", uuid);
        cookie.setMaxAge(7200);
        response.addCookie(cookie);
        return "redirect:seckill/list";
    }

}
