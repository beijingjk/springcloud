package com.jk.service;

import com.jk.mapper.RoleMapper;
import com.jk.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Roleserviceimpl implements RoleserviceApi {
    @Autowired
    private RoleMapper roleService;


    @Override
    public List<Role> roles() {
        return roleService.roles();
    }

    @Override
    public void addUserRole(String roleid, String userid) {
        roleService.deleteUserRole(userid);
        String[] roleIds = roleid.split(",");
        List<Map<String,String>> list  =new ArrayList<Map<String,String>>();
        for (int i = 0; i < roleIds.length; i++) {
            Map<String,String> map=new HashMap<String,String>();
            map.put("userId", userid);
            map.put("roleid", roleIds[i].trim());
            list.add(map);
        }
        roleService.addUserRole(list);
    }
}
