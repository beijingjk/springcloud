package com.jk.service;

import com.jk.model.FruitsInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GoodsServiceApi {

    @RequestMapping(value = "goods/queryGoodsList",method = RequestMethod.GET)
    List<FruitsInfo> queryGoodsList(@RequestBody FruitsInfo fruitsInfo, @RequestParam("start") Integer start, @RequestParam("limit") Integer limit);


    @RequestMapping(value = "goods/queryGoodsCount",method = RequestMethod.GET)
    long queryGoodsCount(@RequestBody FruitsInfo fruitsInfo);

    @RequestMapping(value = "goods/queryGoodsThroughList",method = RequestMethod.GET)
    List<FruitsInfo> queryGoodsThroughList(@RequestBody FruitsInfo fruitsInfo, @RequestParam("start") Integer start, @RequestParam("limit") Integer limit);

    @RequestMapping(value = "goods/queryGoodsThroughCount",method = RequestMethod.GET)
    long queryGoodsThroughCount(FruitsInfo fruitsInfo);

    @RequestMapping(value = "goods/queryGoodsRejectedList",method = RequestMethod.GET)
    List<FruitsInfo> queryGoodsRejectedList(@RequestBody FruitsInfo fruitsInfo, @RequestParam("start") Integer start, @RequestParam("limit") Integer limit);

    @RequestMapping(value = "goods/queryGoodsRejectedCount",method = RequestMethod.GET)
    long queryGoodsRejectedCount(FruitsInfo fruitsInfo);

    @RequestMapping(value = "goods/approved",method = RequestMethod.GET)
    void approved(@RequestParam("id") String id);

  
    @RequestMapping(value = "goods/queryAllPetById",method = RequestMethod.GET)
    FruitsInfo queryAllPetById(@RequestParam("id") String id);

    @RequestMapping(value = "goods/auditing",method = RequestMethod.GET)
    void auditing(FruitsInfo fruitsInfo);
}
