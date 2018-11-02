package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    List<PetType> queryPetTypePage();

    List<TreeMenu> queryTreeMenu(@Param("pid") Integer menuid);

    List<PetType> queryPetList(PetType petType, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    long queryPetCount(PetType petType);

    void savePet(PetType petType);

    void delPet(String ptid);

    PetType queryAllPetById(String ptid);

    void editPet(PetType petType);
    List<FruitsInfo> queryFruitsList(FruitsInfo fruitsInfo, @Param("start")Integer start, @Param("pageSize") Integer pageSize);

    long queryFruitsCount(FruitsInfo fruitsInfo);

    void saveFruits(FruitsInfo fruitsInfo);

    void delFruits(Integer id);

    List<FruitsType> queryFruitsType();

    List<Area> queryArea();

    FruitsInfo queryAllFruitsById(@Param("id") String fruid);

    void editFruits(FruitsInfo fruitsInfo);

    List<Login> queryUserList(Login user, @Param("start") int i, @Param("pageSize") Integer pageSize);

    long queryUserCount(Login user);

    void delUser(String userId);

    void saveUser(Login user);

    List<Role> queryRoleList(Role role,@Param("start") int i,@Param("pageSize") Integer pageSize);

    long queryRoleCount(Role role);

    void saveROle(Role role);


    void delRole(String id);

    List<Map<String, Object>> getRoleResources( @Param("user") Login user);

    List<Map<String, Object>> queryRoleTreeList(@Param("user") Login user);

    Login queryLoginUserName(String userName);

    Login toUserInfo(@Param("userName") String userName);

    List<TreeMenu> getTreeMenu(@Param("userid") String id, @Param("pid") String pid);

    void saveImgs(FruitsInfo fruitsInfo);
}
