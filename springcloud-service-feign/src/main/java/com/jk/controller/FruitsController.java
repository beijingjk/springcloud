package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.model.Area;
import com.jk.model.FruitsInfo;
import com.jk.model.FruitsType;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("fruits")
public class FruitsController {

    @Autowired
    private UserServiceApi userService;

    @RequestMapping("toFruits")
    public String toFruits(){
        return "showFruitsInfo";
    }
    @RequestMapping("queryFruitsById")
    public String queryFruitsById(){
        return "editFruits";
    }

    @RequestMapping("toAddFruits")
    public String toAddFruits(Model mo){
        return "addFruits";
    }

    @RequestMapping("queryFruitsType")
    @ResponseBody
    public List<FruitsType> queryFruitsType(){
        List<FruitsType> typelist = userService.queryFruitsType();
        return typelist;
    }

    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea(){
        List<Area> arealist = userService.queryArea();
        return arealist;
    }

    @RequestMapping("queryFruitsPage")
    @ResponseBody
    public Map<String,Object> queryFruitsPage(FruitsInfo fruitsInfo, Integer start, Integer limit){
        List<FruitsInfo> list =new ArrayList<FruitsInfo>();
        Map<String,Object> map =new HashMap<String,Object>();
        if(start==null){
            start=1;
        }
        try {
            list = userService.queryFruitsList(fruitsInfo,start,limit);
            long count = userService.queryFruitsCount(fruitsInfo);
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

    @RequestMapping("saveFruits")
    @ResponseBody
    public String saveFruits(FruitsInfo fruitsInfo){
        userService.saveFruits(fruitsInfo);
        return "{}";
    }

    @RequestMapping("queryAllFruitsById")
    public String queryAllFruitsById(String fruid, HttpServletRequest request){
        FruitsInfo fruitsInfo = userService.queryAllFruitsById(fruid);
        request.setAttribute("fruitsInfo",fruitsInfo);
        return "editFruits";
    }

    @RequestMapping("editFruits")
    @ResponseBody
    public String editFruits(FruitsInfo fruitsInfo){
        userService.editFruits(fruitsInfo);
        return "1";
    }

    @RequestMapping("delFruits")
    @ResponseBody
    public Boolean delFruits(Integer id){
        try {
            userService.delFruits(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
