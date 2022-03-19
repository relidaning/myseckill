package xyz.lidaning.myseckill;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/demo")
    public String demo(){
//        redisTemplate.opsForValue().set("myseckill-redis", "ready!");
//        jdbcTemplate.execute(" insert into s_user(`id`) values (1)");
//        rabbitTemplate.convertAndSend("demo", "Hello from rabbitmq!");
//        rabbitTemplate.convertAndSend("orderExchange", "order.seckill", "I got a seckill!");
        return "demo";
    }

}
