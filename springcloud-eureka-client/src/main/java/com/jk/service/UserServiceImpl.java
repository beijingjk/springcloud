package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserServiceApi {

    @Autowired
    private  UserMapper userMapper;


    @Override
    public List<PetType> queryPetTypePage() {
        return userMapper.queryPetTypePage();
    }

    @Override
    public List<TreeMenu> queryTreeMenu() {
        List<TreeMenu> treeMenus= userMapper.queryTreeMenu(0);
        ChildrenMenu( treeMenus);

      /*  articleSearchRepository.saveAll(treeMenus);
     Optional<TreeMenu> list =articleSearchRepository.findById((long) 1);*/
        return treeMenus;
    }
    private void ChildrenMenu( List<TreeMenu> firstlist) {
        for (TreeMenu menu : firstlist) {
            List<TreeMenu> childrenMenuList = userMapper.queryTreeMenu( menu.getMenuid());

            if (childrenMenuList.size() > 0) {
                menu.setChildren(childrenMenuList);

                ChildrenMenu(childrenMenuList);
            }
        }
    }


    @Override
    public List<PetType> queryPetList(PetType petType, Integer start, Integer pageSize) {
        return userMapper.queryPetList(petType,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryPetCount(PetType petType) {
        return userMapper.queryPetCount(petType);
    }

    @Override
    public void savePet(PetType petType) {
        userMapper.savePet(petType);
    }

    @Override
    public void delPet(String ptid) {
        userMapper.delPet(ptid);
    }

    @Override
    public PetType queryAllPetById(String ptid) {
        return userMapper.queryAllPetById(ptid);
    }

    @Override
    public void editPet(PetType petType) {
        userMapper.editPet(petType);
    }

}
