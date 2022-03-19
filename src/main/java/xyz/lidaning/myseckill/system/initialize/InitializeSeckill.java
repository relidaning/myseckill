package xyz.lidaning.myseckill.system.initialize;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.service.IGoodsService;

import java.util.List;
@Slf4j
@Component
public class InitializeSeckill implements ApplicationRunner {
    @Autowired
    IGoodsService goodsService;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Goods queryGoods = new Goods();
        queryGoods.setIsseckill("1");
        List<Goods> goods = goodsService.selectGoodsList(queryGoods);
        redisTemplate.opsForValue().set("seckills", goods);
        log.info("[x] hot data has been cache... ");
    }
}
