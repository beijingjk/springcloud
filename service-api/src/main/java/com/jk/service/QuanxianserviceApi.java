package com.jk.service;

import com.jk.model.TreeMenu;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface QuanxianserviceApi {

    @RequestMapping(value = "qx/queryRoleTree",method = RequestMethod.GET)
    List<TreeMenu> queryRoleTree(@RequestParam("roleId") String roleId);

    @RequestMapping(value = "qx/queryTree",method = RequestMethod.POST)
    List<TreeMenu> queryTree(@RequestBody TreeMenu tree);

    @RequestMapping(value = "qx/addRoleTree",method = RequestMethod.GET)
    void addRoleTree(@RequestParam("ids") String ids,@RequestParam("roleId") String roleId);
}
