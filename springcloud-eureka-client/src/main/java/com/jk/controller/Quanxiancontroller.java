package com.jk.controller;

import com.jk.model.Login;
import com.jk.model.Role;
import com.jk.model.TreeMenu;
import com.jk.service.QuanxianserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("qx")
public class Quanxiancontroller {
    @Autowired
    private QuanxianserviceApi Quanxian;

    @RequestMapping("addRoleTree")
    @ResponseBody
    public String addRoleTree(String ids ,String roleId){
        Quanxian.addRoleTree(ids,roleId);
        return "1";
    }


    @RequestMapping("queryTree")
    @ResponseBody
    public List<TreeMenu> queryTree(@RequestBody TreeMenu tree) {
        List<TreeMenu> list = Quanxian.queryTree(tree);
        return list;
    }

    @RequestMapping("queryRoleTree")
    @ResponseBody
    public List<TreeMenu> queryRoleTree(String roleId) {
        List<TreeMenu> listTree = Quanxian.queryRoleTree(roleId);
        return listTree;
    }
}
