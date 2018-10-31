package com.jk.mapper;

import com.jk.model.TreeMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuanxianMapper {

    List<TreeMenu> queryRoleTree(@Param("roleId")String roleId);

    List<TreeMenu> queryTree(TreeMenu tree);

    void deleteRoleTree(@Param("roleId")String roleId);

    void addRoleTree(@Param("list") List<Map<String, String>> list);
}
