package xyz.lidaning.myseckill.order.service;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Goods;

public interface IGoodsService{

    public Goods selectGoodsById(int id);

    public List<Goods> selectGoodsList(Goods goods);

    public int insertGoods(Goods goods);

    public int updateGoods(Goods goods);

    public int deleteGoodsByIds(int[] ids);

    public int deleteGoodsById(int id);
}