package xyz.lidaning.myseckill.seckill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.lidaning.common.JsonResult;
import xyz.lidaning.myseckill.order.domain.Goods;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("/list")
    public String list(Model model){
        List<Goods> seckills = (List<Goods>) redisTemplate.opsForValue().get("seckills");
        model.addAttribute("list", seckills);
        return "/seckill/list";
    }
}
