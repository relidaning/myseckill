package xyz.lidaning.myseckill.order.mapper;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    public Order selectOrderById(String id);

    public List<Order> selectOrderList(Order order);

    public int insertOrder(Order order);

    public int updateOrder(Order order);

    public int deleteOrderById(String id);

    public int deleteOrderByIds(String[] ids);
}
