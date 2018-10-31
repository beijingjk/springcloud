package com.jk.service;


import com.jk.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserServiceApi {

    @RequestMapping(value = "user/queryPetTypePage",method = RequestMethod.GET)
    List<PetType> queryPetTypePage();

    @RequestMapping(value = "user/queryTreeMenu",method = RequestMethod.GET)
    List<TreeMenu> queryTreeMenu();

    @RequestMapping(value = "user/queryPetList",method = RequestMethod.GET)
    List<PetType> queryPetList(@RequestBody PetType petType, @RequestParam("start") Integer start,@RequestParam("limit") Integer limit);

    @RequestMapping(value = "user/queryPetCount",method = RequestMethod.GET)
    long queryPetCount(@RequestBody PetType petType);

    @RequestMapping(value = "user/savePet",method = RequestMethod.POST)
    void savePet(@RequestBody PetType petType);

    @RequestMapping(value = "user/delPet",method = RequestMethod.GET)
    void delPet(@RequestParam("ptid") String ptid);

    @RequestMapping(value = "user/queryAllPetById",method = RequestMethod.GET)
    PetType queryAllPetById(@RequestParam("ptid") String ptid);

    @RequestMapping(value = "user/editPet",method = RequestMethod.GET)
    void editPet(@RequestBody PetType petType);

    @RequestMapping(value = "user/delUser",method = RequestMethod.GET)
    void delUser( @RequestParam("userId") String userId);

    @RequestMapping(value = "user/queryUserList",method = RequestMethod.GET)
    List<Login> queryUserList( @RequestBody Login user,@RequestParam("start") Integer start,@RequestParam("limit") Integer limit);

    @RequestMapping(value = "user/queryPetCount",method = RequestMethod.GET)
    long queryUserCount( @RequestBody Login user);

    @RequestMapping(value = "user/saveUser",method = RequestMethod.POST)
    void saveUser(@RequestBody Login user);

    @RequestMapping(value = "user/queryRoleList",method = RequestMethod.GET)
    List<Role> queryRoleList(@RequestBody Role role,@RequestParam("start") Integer start,@RequestParam("limit") Integer limit);

    @RequestMapping(value = "user/queryRoleCount",method = RequestMethod.GET)
    long queryRoleCount(@RequestBody Role role);

    @RequestMapping(value = "user/saveROle",method = RequestMethod.POST)
    void saveROle(@RequestBody Role role);

    @RequestMapping(value = "user/delRole",method = RequestMethod.GET)
    void delRole(@RequestParam("id") String id);

    @RequestMapping(value = "role/getRoleResources",method = RequestMethod.GET)
    Login getRoleResources(@RequestBody Login user);

    @RequestMapping(value = "user/queryRoleTreeList",method = RequestMethod.GET)
    Set<Map<String, Object>> queryRoleTreeList(@RequestBody Login user);

    @RequestMapping(value = "login/queryLoginUserName",method = RequestMethod.GET)
    Login queryLoginUserName(@RequestBody Login login);

    @RequestMapping(value = "login/toUserInfo",method = RequestMethod.GET)
    Login toUserInfo(@RequestParam("userName") String userName);

    @RequestMapping(value = "user/getTreeMenu",method = RequestMethod.GET)
    List<TreeMenu> getTreeMenu(@RequestBody  Login userInfos);

    @RequestMapping(value = "fruits/queryFruitsList",method = RequestMethod.GET)
    List<FruitsInfo> queryFruitsList(@RequestBody FruitsInfo fruitsInfo, @RequestParam("start") Integer start, @RequestParam("limit") Integer limit);

    @RequestMapping(value = "fruits/queryFruitsCount",method = RequestMethod.GET)
    long queryFruitsCount(@RequestBody FruitsInfo fruitsInfo);

    @RequestMapping(value = "fruits/saveFruits",method = RequestMethod.POST)
    void saveFruits(FruitsInfo fruitsInfo);

    @RequestMapping(value = "fruits/delFruits",method = RequestMethod.GET)
    void delFruits(@RequestParam("id") Integer id);

    @RequestMapping(value = "fruits/queryFruitsType",method = RequestMethod.GET)
    List<FruitsType> queryFruitsType();

    @RequestMapping(value = "fruits/queryArea",method = RequestMethod.GET)
    List<Area> queryArea();

    @RequestMapping(value = "fruits/queryAllFruitsById",method = RequestMethod.GET)
    FruitsInfo queryAllFruitsById(@RequestParam("fruid") String fruid);

    @RequestMapping(value = "fruits/editFruits",method = RequestMethod.GET)
    void editFruits(@RequestBody FruitsInfo fruitsInfo);
}
