package com.jk.controller;

import com.jk.model.Area;
import com.jk.model.FruitsInfo;
import com.jk.model.FruitsType;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("fruits")
public class FruitsController {

    @Autowired
    private UserServiceApi userService;

    @RequestMapping("queryFruitsType")
    @ResponseBody
    public List<FruitsType> queryFruitsType() {
        List<FruitsType> typelist = userService.queryFruitsType();
        return typelist;
    }

    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea() {
        List<Area> arealist = userService.queryArea();
        return arealist;
    }

    @RequestMapping("queryFruitsList")
    @ResponseBody
    public List<FruitsInfo> queryFruitsList(@RequestBody FruitsInfo fruitsInfo, @RequestParam Integer start, @RequestParam Integer limit) {
        List<FruitsInfo> list = userService.queryFruitsList(fruitsInfo,start,limit);
        return list;
    }
    @RequestMapping("queryFruitsCount")
    @ResponseBody
    public  Long queryFruitsCount(@RequestBody FruitsInfo fruitsInfo) {
        long count = userService.queryFruitsCount(fruitsInfo);
        return count;
    }

    @RequestMapping("saveFruits")
    @ResponseBody
    public String saveFruits(@RequestBody FruitsInfo fruitsInfo){
        userService.saveFruits(fruitsInfo);
        return "{}";
    }

    @RequestMapping("queryAllFruitsById")
    @ResponseBody
    public FruitsInfo queryAllFruitsById(@RequestParam String fruid){
        FruitsInfo fruitsInfo = userService.queryAllFruitsById(fruid);
        return fruitsInfo;
    }

    @RequestMapping("editFruits")
    @ResponseBody
    public String editFruits(@RequestBody FruitsInfo fruitsInfo){
        userService.editFruits(fruitsInfo);
        return "1";
    }

    @RequestMapping("delFruits")
    @ResponseBody
    public Boolean delFruits(@RequestParam Integer id){
        try {
            userService.delFruits(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
