package xyz.lidaning.myseckill.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import xyz.lidaning.myseckill.order.domain.Order;

@Slf4j
@Configuration
public class MyRabbitMQConfig {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value="orderQueue", durable = "true"),
            exchange = @Exchange(name="orderExchange", type = "topic"),
            ignoreDeclarationExceptions = "true",
            key = "order.*")
    )
    @RabbitHandler
    public void onMessage(Message msg, Channel channel){
        Order order = (Order) msg.getPayload();
        log.info("[x] recieve msg:"+order);
    }

}
