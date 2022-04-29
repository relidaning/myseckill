package xyz.lidaning.myseckill.order.service;

import xyz.lidaning.myseckill.order.domain.Order;

import java.util.List;

public interface IOrderService{

    public Order selectOrderById(String id);

    public List<Order> selectOrderList(Order order);

    public int insertOrder(Order order);

    public int updateOrder(Order order);

    public int deleteOrderByIds(String[] ids);

    public int deleteOrderById(String id);
}
