package xyz.lidaning.myseckill.order.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import xyz.lidaning.common.JsonResult;
import xyz.lidaning.myseckill.order.domain.Order;
import xyz.lidaning.myseckill.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order/order")
public class OrderController{
    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    public JsonResult list(Order order){
        List<Order> list = orderService.selectOrderList(order);
        return JsonResult.success(list);
    }

    @GetMapping(value = "/{id}")
    public JsonResult getInfo(@PathVariable("id") String id){
        return JsonResult.success(orderService.selectOrderById(id));
    }

    @PostMapping
    public JsonResult add(@RequestBody Order order){
        return JsonResult.success(orderService.insertOrder(order));
    }

    @PutMapping
    public JsonResult edit(@RequestBody Order order){
        return JsonResult.success(orderService.updateOrder(order));
    }

    @DeleteMapping
    public JsonResult remove(@PathVariable String[] ids){
        return JsonResult.success(orderService.deleteOrderByIds(ids));
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/rabbitmqOrder")
    public JsonResult rabbitmqOrder(){
        Order order = orderService.selectOrderById("1");
        rabbitTemplate.convertAndSend("orderExchange", "order.seckill", order);
        return JsonResult.success(order);
    }
}
