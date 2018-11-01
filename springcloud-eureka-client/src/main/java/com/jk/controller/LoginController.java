package com.jk.controller;

import com.jk.model.Login;
import com.jk.service.UserServiceApi;
import com.jk.util.MD5Utils;
import com.jk.util.RandomValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserServiceApi userService;


    //登陆
    @RequestMapping("toUserInfo")
    @ResponseBody
    public Login toUserInfo(@RequestParam String userName){
        Login userInfo = userService.toUserInfo(userName);
        return userInfo;
    }

    @RequestMapping("queryLoginUserName")
    public Login queryLoginUserName(@RequestBody Login login ){
        return userService.queryLoginUserName(login);
    }

}
