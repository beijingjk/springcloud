package com.jk.mapper;

import com.jk.model.PetType;
import com.jk.model.TreeMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
