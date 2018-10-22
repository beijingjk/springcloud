package com.jk.service;


import com.jk.model.PetType;
import com.jk.model.TreeMenu;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
}
