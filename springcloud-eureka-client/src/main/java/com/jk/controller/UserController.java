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
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;

    //登陆展示不同的权限
    @RequestMapping("getTreeMenu")
    @ResponseBody
    public  List<TreeMenu>  getTreeMenu(@RequestBody Login userInfos){

        List<TreeMenu> list =  userService.getTreeMenu(userInfos);
        return  list;
    }
    /*public Set<Map<String,Object>> queryRoleTreeList(HttpServletRequest request){
        Login user =(Login) request.getSession().getAttribute("user");
        Set<Map<String, Object>> obj = new HashSet<Map<String,Object>>();
        return obj;
    }*/

    //角色删除
    @RequestMapping("delRole")
    @ResponseBody
    public String delRole(String id){
        userService.delRole(id);
        return "1";
    }

    //角色新增
    @RequestMapping("saveROle")
    @ResponseBody
    public String saveROle(@RequestBody Role role){
        userService.saveROle(role);
        return "1";
    }

    //角色查询
    @RequestMapping("queryRoleList")
    @ResponseBody
    public List<Role> queryRoleList(@RequestBody Role role,@RequestParam Integer start,@RequestParam Integer limit) {
        List<Role> list = userService.queryRoleList(role,start,limit);
        return list;
    }

    @RequestMapping("queryRoleCount")
    @ResponseBody
    public  Long queryRoleCount(@RequestBody Role role) {
        long count = userService.queryRoleCount(role);
        return count;
    }

    //用户新增
    @RequestMapping("saveUser")
    @ResponseBody
    public String saveUser(@RequestBody Login user){
        userService.saveUser(user);
        return "1";
    }

    //用户删除
    @RequestMapping("delUser")
    @ResponseBody
    public String delUser(String userId){
        userService.delUser(userId);
        return "1";
    }

    //用户查询
    @RequestMapping("queryUserList")
    @ResponseBody
    public List<Login> queryUserList(@RequestBody Login user,@RequestParam Integer start,@RequestParam Integer limit) {
        List<Login> list = userService.queryUserList(user,start,limit);
        return list;
    }

    @RequestMapping("queryUserCount")
    @ResponseBody
    public  Long queryUserCount(@RequestBody Login user) {
        long count = userService.queryUserCount(user);
        return count;
    }


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