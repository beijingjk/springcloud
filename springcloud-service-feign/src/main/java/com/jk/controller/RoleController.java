package com.jk.controller;

import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Role;
import com.jk.model.RoleList;
import com.jk.service.Roleservice;
import com.jk.service.RoleserviceApi;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleserviceApi roleservice;

    @Autowired
    private UserServiceApi userService;


    //传递id
    @RequestMapping("toShowTree")
    public String toShowTree(String roleId,HttpServletRequest request){
        request.setAttribute("roleId", roleId);
        return "showTree";
    }


    //赋角色
    @RequestMapping("addUserRole")
    @ResponseBody
    public String addUserRole(String roleid,String userid){
        try {
            roleservice.addUserRole(roleid,userid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "1";
    }

    @RequestMapping("roles")
    @ResponseBody
    public RoleList roles(String userid){

        Login user =new Login();
        /*user.setUserid(userid);*/
        user.setUserId(userid);
        RoleList roleList=new RoleList();
        List<Role> list =new ArrayList<Role>();
        try {
            //当前要服角色用户的角色
            user = userService.getRoleResources(user);
            //这是所有的角色
            list=roleservice.roles();
            roleList.setList(list);
            roleList.setRoles(user.getRoles());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return roleList;
    }



    //传递id
    @RequestMapping("toShowRole")
    public String toShowRole(String userid,HttpServletRequest request){
        request.setAttribute("userid", userid);
        return "showRole";
    }

}
