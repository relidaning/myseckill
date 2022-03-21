package xyz.lidaning.myseckill.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.util.Assert;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.domain.Order;
import xyz.lidaning.myseckill.order.service.IOrderService;

@Slf4j
@Configuration
public class MyRabbitMQConfig {

    @Autowired
    IOrderService orderService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value="orderQueue", durable = "true"),
            exchange = @Exchange(name="orderExchange", type = "topic"),
            ignoreDeclarationExceptions = "true",
            key = "order.#")
    )
    @RabbitHandler
    public void seckillConsume(Message msg, Channel channel){
        Order order = (Order) msg.getPayload();
        log.info("[x] recieve msg:"+order);
        Assert.isTrue(order!=null, "无效的订单信息");
        orderService.insertOrder(order);
    }

}
