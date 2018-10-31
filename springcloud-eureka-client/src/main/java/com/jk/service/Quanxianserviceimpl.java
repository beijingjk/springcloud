package com.jk.service;

import com.jk.mapper.QuanxianMapper;
import com.jk.model.TreeMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Quanxianserviceimpl implements QuanxianserviceApi{
    @Autowired
    private QuanxianMapper QxMapper;

    @Override
    public List<TreeMenu> queryRoleTree(String roleId) {
        return QxMapper.queryRoleTree(roleId);
    }

    @Override
    public List<TreeMenu> queryTree(TreeMenu tree) {
        return QxMapper.queryTree(tree);
    }

    @Override
    public void addRoleTree(String ids, String roleId) {
        if(ids==null || "".equals(ids)){
            QxMapper.deleteRoleTree(roleId);
        }else{
            QxMapper.deleteRoleTree(roleId);
            List<Map<String,String>> list =new ArrayList<Map<String,String>>();
            String[] idss =ids.split(",");
            for (int i = 0; i < idss.length; i++) {
                Map<String,String> map =new HashMap<String,String>();
                map.put("roleId", roleId);
                map.put("treeId", idss[i].trim());
                list.add(map);
            }

            QxMapper.addRoleTree(list);
        }
    }
}
