package xyz.lidaning.myseckill.order.mapper;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {

    public Goods selectGoodsById(int id);

    public List<Goods> selectGoodsList(Goods goods);

    public int insertGoods(Goods goods);

    public int updateGoods(Goods goods);

    public int deleteGoodsById(int id);

    public int deleteGoodsByIds(int[] ids);
}