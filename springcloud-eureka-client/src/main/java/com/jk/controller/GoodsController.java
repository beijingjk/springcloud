package com.jk.controller;

import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Role;
import com.jk.service.GoodsServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsServiceApi goodsService;

    //驳回原因
    @RequestMapping("auditing")
    @ResponseBody
    public String auditing(@RequestBody FruitsInfo fruitsInfo){
        goodsService.auditing(fruitsInfo);
        return "{}";
    }

    //审核驳回
    @RequestMapping("queryAllPetById")
    @ResponseBody
    public FruitsInfo queryAllPetById(@RequestParam  String id){

        FruitsInfo fruitsInfo= goodsService.queryAllPetById(id);

        return fruitsInfo;
    }

    //审核通过
    @RequestMapping("/approved")
    @ResponseBody
    public String approved(@RequestParam String id){
        goodsService.approved(id);
        return "1";
    }

    //商品驳回查询
    @RequestMapping("queryGoodsRejectedList")
    @ResponseBody
    public List<FruitsInfo> queryGoodsRejectedList(@RequestBody FruitsInfo fruitsInfo, @RequestParam Integer start, @RequestParam Integer limit) {
        List<FruitsInfo> list = goodsService.queryGoodsRejectedList(fruitsInfo,start,limit);
        return list;
    }
    @RequestMapping("queryGoodsRejectedCount")
    @ResponseBody
    public  Long queryGoodsRejectedCount(@RequestBody FruitsInfo fruitsInfo) {
        long count = goodsService.queryGoodsRejectedCount(fruitsInfo);
        return count;
    }

    //商品通过查询
    @RequestMapping("queryGoodsThroughList")
    @ResponseBody
    public List<FruitsInfo> queryGoodsThroughList(@RequestBody FruitsInfo fruitsInfo, @RequestParam Integer start, @RequestParam Integer limit) {
        List<FruitsInfo> list = goodsService.queryGoodsThroughList(fruitsInfo,start,limit);
        return list;
    }
    @RequestMapping("queryGoodsThroughCount")
    @ResponseBody
    public  Long queryGoodsThroughCount(@RequestBody FruitsInfo fruitsInfo) {
        long count = goodsService.queryGoodsThroughCount(fruitsInfo);
        return count;
    }


    //商品未审核查询
    @RequestMapping("queryGoodsList")
    @ResponseBody
    public List<FruitsInfo> queryGoodsList(@RequestBody FruitsInfo fruitsInfo, @RequestParam Integer start, @RequestParam Integer limit) {
        List<FruitsInfo> list = goodsService.queryGoodsList(fruitsInfo,start,limit);
        return list;
    }
    @RequestMapping("queryGoodsCount")
    @ResponseBody
    public  Long queryGoodsCount(@RequestBody FruitsInfo fruitsInfo) {
        long count = goodsService.queryGoodsCount(fruitsInfo);
        return count;
    }


}
