package xyz.lidaning.myseckill.order.service.impl;

import java.util.List;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.mapper.GoodsMapper;
import xyz.lidaning.myseckill.order.service.IGoodsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements IGoodsService{
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectGoodsById(String id){
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
    public int deleteGoodsByIds(String[] ids){
        return goodsMapper.deleteGoodsByIds(ids);
    }

    @Override
    public int deleteGoodsById(String id){
        return goodsMapper.deleteGoodsById(id);
    }
}