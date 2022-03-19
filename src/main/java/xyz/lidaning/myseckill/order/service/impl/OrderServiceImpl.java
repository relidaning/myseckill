package xyz.lidaning.myseckill.order.service.impl;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Order;
import xyz.lidaning.myseckill.order.mapper.OrderMapper;
import xyz.lidaning.myseckill.order.service.IOrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements IOrderService{
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order selectOrderById(String id){
        return orderMapper.selectOrderById(id);
    }

    @Override
    public List<Order> selectOrderList(Order order){
        return orderMapper.selectOrderList(order);
    }

    @Override
    public int insertOrder(Order order){
        return orderMapper.insertOrder(order);
    }

    @Override
    public int updateOrder(Order order){
        return orderMapper.updateOrder(order);
    }

    @Override
    public int deleteOrderByIds(String[] ids){
        return orderMapper.deleteOrderByIds(ids);
    }

    @Override
    public int deleteOrderById(String id){
        return orderMapper.deleteOrderById(id);
    }
}