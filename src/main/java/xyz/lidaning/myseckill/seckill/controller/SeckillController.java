package xyz.lidaning.myseckill.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.lidaning.common.JsonResult;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.domain.Order;
import xyz.lidaning.myseckill.order.service.IGoodsService;
import xyz.lidaning.myseckill.user.domain.User;

import javax.management.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    IGoodsService goodsService;
    @GetMapping("/list")
    public String list(Model model){
        List<Goods> seckills = (List<Goods>) redisTemplate.opsForValue().get("seckills");
        log.info("Got "+seckills.size()+" goods info by redis query...");

        /*Goods queryGoods = new Goods();
        queryGoods.setIsseckill("1");
        List<Goods> seckills = goodsService.selectGoodsList(queryGoods);
        log.info("Got "+seckills.size()+" goods info by sql query...");*/

        model.addAttribute("list", seckills);
        return "seckill/list";
    }

    @PostMapping
    @ResponseBody
    public JsonResult seckill(@RequestBody Goods goods, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        User user=null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("jsessionId")){
                String sessionId = cookie.getValue();
                user = (User) redisTemplate.opsForValue().get("user:" + sessionId);
            }
        }
        Assert.isTrue(user!=null, "用户为空!");
        Goods target = goodsService.selectGoodsById(goods.getId());
        Order order = new Order();
        order.setUserid(user.getId());
        order.setGoodsid(Integer.parseInt(target.getId()));
        order.setNum(1);

        rabbitTemplate.convertAndSend("orderExchange", "order.seckill", order);
        return JsonResult.success(target);
    }
}
