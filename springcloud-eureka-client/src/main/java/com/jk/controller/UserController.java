package com.jk.controller;

import com.jk.model.*;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;

    @RequestMapping("queryPetTypePage")
    @ResponseBody
    public List<PetType> queryPetTypePage() {
        List<PetType> list = userService.queryPetTypePage();
        return list;
    }
    @RequestMapping("queryTreeMenu")
    @ResponseBody
    public    List<TreeMenu> queryTreeMenu() {
        List<TreeMenu> list = userService.queryTreeMenu();
        return list;
    }

    @RequestMapping("queryPetList")
    @ResponseBody
    public    List<PetType> queryPetList(@RequestBody PetType petType,@RequestParam Integer start,@RequestParam Integer limit) {
        List<PetType> list = userService.queryPetList(petType,start,limit);
        return list;
    }
    @RequestMapping("queryPetCount")
    @ResponseBody
    public  Long queryPetCount(@RequestBody PetType petType) {
        long count = userService.queryPetCount(petType);
        return count;
    }
    @RequestMapping("savePet")
    @ResponseBody
    public String savePet(@RequestBody PetType petType){
        userService.savePet(petType);
        return "{}";
    }
    @RequestMapping("delPet")
    @ResponseBody
    public String delPet(@RequestParam String ptid){
        userService.delPet(ptid);
        return "{}";
    }
    @RequestMapping("queryAllPetById")
    @ResponseBody
    public PetType queryAllPetById(@RequestParam String ptid){

        PetType petType= userService.queryAllPetById(ptid);

        return petType;
    }
    @RequestMapping("editPet")
    @ResponseBody
    public String editPet(@RequestBody PetType petType){
        userService.editPet(petType);
        return "{}";
    }


}