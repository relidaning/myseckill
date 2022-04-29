package xyz.lidaning.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.util.Assert;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.domain.Order;
import xyz.lidaning.myseckill.order.service.IGoodsService;
import xyz.lidaning.myseckill.order.service.IOrderService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Slf4j
@Configuration
public class MyRabbitMQConfig {

    @Autowired
    IOrderService orderService;
    @Autowired
    IGoodsService goodsService;
    @Autowired
    RedisTemplate redisTemplate;

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

        List<Goods> seckills = (List<Goods>) redisTemplate.opsForValue().get("seckills");
        for (Goods goods : seckills) {
            if(goods.getId()==order.getGoodsid()){
                int result = goods.getStore()-1;
                log.info("[x] 商品编号: "+goods.getId()+", 当前库存剩余为:"+result);
                goods.setStore(result);
                goodsService.updateGoods(goods);
            }
        }
        redisTemplate.opsForValue().set("seckills", seckills);
    }

    static void send() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("guest");
        factory.setPassword("guest");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("demo", true, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", "demo", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

    static void receive() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("demo", true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume("demo", true, deliverCallback, consumerTag -> { });
    }

    public static void main(String[] args) throws IOException, TimeoutException {
//        receive();
//        send();
    }



}
