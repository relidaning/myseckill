package xyz.lidaning.myseckill.order.service.impl;

import org.springframework.stereotype.Service;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.mapper.GoodsMapper;
import xyz.lidaning.myseckill.order.service.IGoodsService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService{
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectGoodsById(int id){
        return goodsMapper.selectGoodsById(id);
    }

    @Override
    public List<Goods> selectGoodsList(Goods goods){
        return goodsMapper.selectGoodsList(goods);
    }

    @Override
    public int insertGoods(Goods goods){
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods){
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoodsByIds(int[] ids){
        return goodsMapper.deleteGoodsByIds(ids);
    }

    @Override
    public int deleteGoodsById(int id){
        return goodsMapper.deleteGoodsById(id);
    }
}
