package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public void delUser(String userId) {
        userMapper.delUser(userId);
    }

    @Override
    public List<Login> queryUserList(Login user, Integer start, Integer pageSize) {
        return userMapper.queryUserList(user,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryUserCount(Login user) {
        return userMapper.queryUserCount(user);
    }

    @Override
    public void saveUser(Login user) {
        userMapper.saveUser(user);
    }

    @Override
    public List<Role> queryRoleList(Role role, Integer start, Integer pageSize) {
        return userMapper.queryRoleList(role,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryRoleCount(Role role) {
        return userMapper.queryRoleCount(role);
    }

    @Override
    public void saveROle(Role role) {
        userMapper.saveROle(role);
    }

    @Override
    public void delRole(String id) {
        userMapper.delRole(id);
    }

    @Override
    public Login getRoleResources(Login user) {
        //接受数据库查询的角色
        Set<Role> roles =new HashSet<Role>();

        //接受查询到的角色和权限
        List<Map<String,Object>> listMap =userMapper.getRoleResources(user);

        for (Map<String ,Object> map :listMap) {

            Role r =new Role();
            r.setId(map.get("roleid").toString());
            r.setName(map.get("name").toString());
            roles.add(r);
        }
        user.setRoles(roles);
        return user;
    }

    @Override
    public Set<Map<String, Object>> queryRoleTreeList(Login user) {
        List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
        Set<Map<String, Object>> set =new HashSet<Map<String, Object>>();

        list = userMapper.queryRoleTreeList(user);

        for (Map<String, Object> map : list) {
            set.add(map);
        }
        return set;
    }


    @Override
    public Login queryLoginUserName(Login login) {
        return userMapper.queryLoginUserName(login.getUserName());
    }

    @Override
    public Login toUserInfo(String userName) {
        return userMapper.toUserInfo(userName);
    }

    @Override
    public List<TreeMenu> getTreeMenu(Login userInfos) {

            List<TreeMenu> treeMenus= userMapper.getTreeMenu(String.valueOf(userInfos.getUserId()),"0");
            ChildrenMenu( treeMenus);


      /*  articleSearchRepository.saveAll(treeMenus);
     Optional<TreeMenu> list =articleSearchRepository.findById((long) 1);*/
        return treeMenus;
    }

    @Override
    public List<FruitsInfo> queryFruitsList(FruitsInfo fruitsInfo, Integer start, Integer pageSize) {
        return userMapper.queryFruitsList(fruitsInfo, (start - 1) * pageSize, pageSize);
    }

    @Override
    public long queryFruitsCount(FruitsInfo fruitsInfo) {
        return userMapper.queryFruitsCount(fruitsInfo);
    }

    @Override
    public void saveFruits(FruitsInfo fruitsInfo) {
        userMapper.saveFruits(fruitsInfo);
    }

    @Override
    public void delFruits(Integer id) {
        userMapper.delFruits(id);
    }

    @Override
    public List<FruitsType> queryFruitsType() {
        return userMapper.queryFruitsType();
    }

    @Override
    public List<Area> queryArea() {
        return userMapper.queryArea();
    }

    @Override
    public FruitsInfo queryAllFruitsById(String fruid) {
        return userMapper.queryAllFruitsById(fruid);
    }

    @Override
    public void editFruits(FruitsInfo fruitsInfo) {
        userMapper.editFruits(fruitsInfo);
    }



}
