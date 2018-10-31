package com.jk.controller;

import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.service.GoodsServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsServiceApi goodsService;

    //驳回原因
    @RequestMapping("/auditing")
    @ResponseBody
    public String auditing(FruitsInfo fruitsInfo){
        goodsService.auditing(fruitsInfo);
        return "{}";
    }


    //商品驳回跳页面
    @RequestMapping("auditingPage")
    public String queryAllPetById(String id, HttpServletRequest request){

        FruitsInfo fruitsInfo=goodsService.queryAllPetById(id);

        request.setAttribute("id",id);

        return "DismissTheReasonPage";
    }


    //审核通过
    @RequestMapping("/approved")
    @ResponseBody
    public String approved(String id){
        goodsService.approved(id);
        return "1";
    }


    //商品驳回查询
    @RequestMapping("/queryGoodsRejectedList")
    @ResponseBody
    public Map<String,Object> queryGoodsRejectedList(FruitsInfo fruitsInfo, Integer start, Integer limit){
        List<FruitsInfo> list =new ArrayList<FruitsInfo>();
        Map<String,Object> map =new HashMap<String,Object>();
        if(start==null){
            start=1;
        }
        try {
            list=goodsService.queryGoodsRejectedList(fruitsInfo,start,limit);
            long count = goodsService.queryGoodsRejectedCount(fruitsInfo);
            map.put("count", count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    //商品通过查询
    @RequestMapping("/queryGoodsThroughList")
    @ResponseBody
    public Map<String,Object> queryGoodsThroughList(FruitsInfo fruitsInfo, Integer start, Integer limit){
        List<FruitsInfo> list =new ArrayList<FruitsInfo>();
        Map<String,Object> map =new HashMap<String,Object>();
        if(start==null){
            start=1;
        }
        try {
            list=goodsService.queryGoodsThroughList(fruitsInfo,start,limit);
            long count = goodsService.queryGoodsThroughCount(fruitsInfo);
            map.put("count", count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    //商品通过跳页面
    @RequestMapping("throughPage")
    public String throughPage(){
        return "GoodsThroughList";
    }


    //商品驳回跳页面
    @RequestMapping("rejectedPage")
    public String rejectedPage(){
        return "GoodsRejectedList";
    }

    //商品未审核查询queryGoodsPage
    @RequestMapping("/queryGoodsPage")
    @ResponseBody
    public Map<String,Object> queryUserPage(FruitsInfo fruitsInfo, Integer start, Integer limit){
        List<FruitsInfo> list =new ArrayList<FruitsInfo>();
        Map<String,Object> map =new HashMap<String,Object>();
        if(start==null){
            start=1;
        }
        try {
            list=goodsService.queryGoodsList(fruitsInfo,start,limit);
            long count = goodsService.queryGoodsCount(fruitsInfo);
            map.put("count", count);
            map.put("data",list);
            map.put("code",0);
            map.put("msg","");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }


    //商品审核跳页面
    @RequestMapping("goodsPage")
    public String goodsPage(){
        return "GoodsList";
    }

}
