package com.jk.controller;

import com.jk.model.Login;
import com.jk.service.UserServiceApi;
import com.jk.util.MD5Utils;
import com.jk.util.RandomValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserServiceApi userService;


    @RequestMapping("loginMethods")
    @ResponseBody
    public Map<String, Object> loginMethods(HttpServletRequest request,Login users){
        Map<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();

        Login userInfo = userService.toUserInfo(users.getUserName());
        if(userInfo == null) {
            result.put("code", 2);
            result.put("msg", "账号或密码错误");
            return result;
        }
        String password = users.getUserPassword();
        /*String md516 = Md5Util.getMd516(password);*/
        if(!userInfo.getUserPassword().equals(password)) {
            result.put("code", 3);
            result.put("msg", "账号或密码错误");
            return result;
        }
        session.setAttribute("users", userInfo);
        result.put("code", 0);
        return result;
    }








    @RequestMapping("toLoginUser")
    public String toLoginUser(){
        return "login";
    }

/*    @RequestMapping("getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            //*logger.error("获取验证码失败>>>>   ", e);
        }
    }*/

    @RequestMapping("userLogin")
    @ResponseBody
    public HashMap<String, Object> userLogin(Login login, String imgCode, HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        String sessionCode = session.getAttribute("RANDOMVALIDATECODEKEY").toString();
        if (!sessionCode.equals(imgCode)) {
            result.put("code", 1);
            result.put("msg", "验证码错误");
            return result;
        }
        String loginNumber = login.getUserName();
        Login userLogin = userService.queryLoginUserName(login);
        if (userLogin == null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;
        }
        String password = login.getUserPassword();
        String md516 = MD5Utils.encrypt(password);
        System.out.println(md516);
        if (!userLogin.getUserPassword().equals(md516)) {
            result.put("code", 3);
            result.put("msg", "密码错误");
            return result;
        }
        session.setAttribute(session.getId(), userLogin);
        result.put("code", 0);
        result.put("msg", "登录成功");
        return result;
    }

}
