package com.jk.controller;

import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Role;
import com.jk.service.RoleserviceApi;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleserviceApi roleService;

    @Autowired
    private UserServiceApi userService;

    //赋角色
    @RequestMapping("addUserRole")
    @ResponseBody
    public String addUserRole(@RequestParam("roleid") String roleid,@RequestParam("userid") String userid){
        try {
            roleService.addUserRole(roleid,userid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "1";
    }

    //所有角色
    @RequestMapping("roles")
    @ResponseBody
    public List<Role> roles() {
        List<Role> list = roleService.roles();
        return list;
    }

    //查询用户的角色
    @RequestMapping("getRoleResources")
    @ResponseBody
    public Login getRoleResources(@RequestBody Login user) {
        Login aa = userService.getRoleResources(user);
        return aa;
    }


}
