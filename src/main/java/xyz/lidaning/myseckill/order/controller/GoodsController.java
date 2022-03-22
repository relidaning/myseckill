package xyz.lidaning.myseckill.order.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import xyz.lidaning.common.JsonResult;
import xyz.lidaning.myseckill.order.domain.Goods;
import xyz.lidaning.myseckill.order.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order/goods")
public class GoodsController{
    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/list")
    public JsonResult list(Goods goods){
        List<Goods> list = goodsService.selectGoodsList(goods);
        return JsonResult.success(list);
    }

    @GetMapping(value = "/{id}")
    public JsonResult getInfo(@PathVariable("id") int id){
        return JsonResult.success(goodsService.selectGoodsById(id));
    }

    @PostMapping
    public JsonResult add(@RequestBody Goods goods){
        return JsonResult.success(goodsService.insertGoods(goods));
    }

    @PutMapping
    public JsonResult edit(@RequestBody Goods goods){
        return JsonResult.success(goodsService.updateGoods(goods));
    }

    @DeleteMapping
    public JsonResult remove(@PathVariable int[] ids){
        return JsonResult.success(goodsService.deleteGoodsByIds(ids));
    }
}
