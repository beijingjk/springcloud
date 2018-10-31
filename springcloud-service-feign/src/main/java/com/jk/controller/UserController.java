package com.jk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Role;
import com.jk.model.TreeMenu;
import com.jk.service.UserServiceApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public  List<TreeMenu>  getTreeMenu(HttpSession session){
        Login userInfos = (Login) session.getAttribute("users");
        List<TreeMenu> list = new ArrayList<>();
        try{
          list =  userService.getTreeMenu(userInfos);
        }catch (Exception e){
            System.out.println(e);
        }

        return  list;
    }
 /*   @RequestMapping("queryRoleTreeList")
    @ResponseBody
    public Set<Map<String,Object>> queryRoleTreeList(HttpServletRequest request){

        Login user =(Login) request.getSession().getAttribute("users");

        Set<Map<String, Object>> obj = new HashSet<Map<String,Object>>();
        try {
            obj = userService.queryRoleTreeList(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
    public String saveROle(Role role){
        userService.saveROle(role);
        return "1";
    }


    //角色新增跳页面
    @RequestMapping("toPageAdd")
    public String toPageAdd(){
        return "AddRole";
    }


    //角色查询
    @RequestMapping("/queryRolePage")
    @ResponseBody
    public Map<String,Object> queryRolePage(Role role, Integer start, Integer limit){
        List<Role> list =new ArrayList<Role>();
        Map<String,Object> map =new HashMap<String,Object>();
        if(start==null){
            start=1;
        }
        try {
            list=userService.queryRoleList(role,start,limit);
            long count = userService.queryRoleCount(role);
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

    //角色列表跳页面
    @RequestMapping("pagerole")
    public String pagerole(){
        return "RoleList";
    }

    //用户新增saveUser
    @RequestMapping("saveUser")
    @ResponseBody
    public String saveUser(Login user){
        userService.saveUser(user);
        return "1";
    }

    //用户新增跳页面
    @RequestMapping("AddUser")
    public String AddUser(){
        return "AddUser";
    }

    //用户删除
    @RequestMapping("delUser")
    @ResponseBody
    public String delUser(String userId){
        userService.delUser(userId);
        return "1";
    }

    //用户新增跳页面
    @RequestMapping("toAddUser")
    public String toAddUser(){
        return "toAddUser";
    }

    //用户查询
    @RequestMapping("/queryUserPage")
    @ResponseBody
    public Map<String,Object> queryUserPage(Login user, Integer start, Integer limit){


        List<Login> list =new ArrayList<Login>();

        Map<String,Object> map =new HashMap<String,Object>();


        if(start==null){
            start=1;
        }

        try {
            list=userService.queryUserList(user,start,limit);
            long count = userService.queryUserCount(user);
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


    //用户跳页面
    @RequestMapping("selectpage")
    public String selectpagetoAddTest(){


        return "UserList";
    }



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
