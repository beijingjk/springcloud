package com.jk.controller;

import com.jk.model.TreeMenu;
import com.jk.service.QuanxianserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("qx")
public class Quanxiancontroller {
    @Autowired
    private QuanxianserviceApi quanxianservice;


    @RequestMapping("addRoleTree")
    @ResponseBody
    public String addRoleTree(String ids ,String roleId){
        quanxianservice.addRoleTree(ids,roleId);
        return "1";
    }




    @RequestMapping("queryRoleTree")
    @ResponseBody
    public List<TreeMenu> queryRoleTree(String roleId){
        List<TreeMenu> list =new ArrayList<TreeMenu>();

        TreeMenu tree =new TreeMenu();

            List<TreeMenu> listTree = quanxianservice.queryRoleTree(roleId);
            list = quanxianservice.queryTree(tree);
            for (TreeMenu tree1 : list) {
                for (TreeMenu tree2 : listTree) {
                    if(tree1.getId().equals(tree2.getMenuid())){
                        tree1.setChecked(true);
                    }
                }
            }
            System.out.println(list);
        return list;
    }

}
