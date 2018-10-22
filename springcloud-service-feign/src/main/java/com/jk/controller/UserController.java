package com.jk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jk.model.PetType;
import com.jk.model.TreeMenu;
import com.jk.service.UserServiceApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;


    @RequestMapping("toShowPetPage")
    public String toShowPet(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){

        PageHelper.startPage(pn, 4);

        List<PetType> list=userService.queryPetTypePage();

        PageInfo<PetType> page = new PageInfo<>(list,3);

        model.addAttribute("pageInfo", page);

        return "showPetPage";
    }

    @RequestMapping("toAddPet")
    public String addResource(){


        return "addPet";
    }
    @RequestMapping("toTest")
    public String toTest(){


        return "test";
    }
    @RequestMapping("queryTreeMenu")
    @ResponseBody
    public  List<TreeMenu>  queryTreeMenu() {

        List<TreeMenu> list =  userService.queryTreeMenu();
        return  list;
    }

    @RequestMapping("toShowTest")
    public String toShowTest(){


        return "showTest";
    }

    @RequestMapping("/queryPetPage")
    @ResponseBody
    public Map<String,Object> queryPetPage(PetType petType, Integer start, Integer limit){


        List<PetType> list =new ArrayList<PetType>();

        Map<String,Object> map =new HashMap<String,Object>();


        if(start==null){
            start=1;
        }

        try {
            list=userService.queryPetList(petType,start,limit);
            long count = userService.queryPetCount(petType);
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

    @RequestMapping("toShowTest2")
    public String toShowTest2(){


        return "showTest2";
    }
    @RequestMapping("toShowTest3")
    public String toShowTest3(){


        return "showTest3";
    }


    @RequestMapping("toAddTest")
    public String toAddTest(){


        return "addTest3";
    }
    @RequestMapping("savePet")
    @ResponseBody
    public String savePet(PetType petType){
        petType.setPtid( UUID.randomUUID().toString().replaceAll("-", ""));
        userService.savePet(petType);
        return "{}";
    }
    @RequestMapping("delPet")
    @ResponseBody
    public String delPet(String ptid){
        userService.delPet(ptid);
        return "{}";
    }
    @RequestMapping("queryAllPetById")
    public String queryAllPetById(String ptid, HttpServletRequest request){

        PetType petType=userService.queryAllPetById(ptid);

        request.setAttribute("petType",petType);

        return "editTest3";
    }
    @RequestMapping("editPet")
    @ResponseBody
    public String editPet(PetType petType){
        userService.editPet(petType);
        return "{}";
    }



}
