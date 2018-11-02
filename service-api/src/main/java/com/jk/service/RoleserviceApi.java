package com.jk.service;

import com.jk.model.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RoleserviceApi {

    @RequestMapping(value = "role/roles",method = RequestMethod.GET)
    List<Role> roles();

    @RequestMapping(value = "role/addUserRole",method = RequestMethod.GET)
    void addUserRole(@RequestParam("roleid") String roleid,@RequestParam("userid") String userid);

    ;
}
