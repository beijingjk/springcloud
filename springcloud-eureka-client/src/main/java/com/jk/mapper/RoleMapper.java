package com.jk.mapper;

import com.jk.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {

    List<Role> roles();

    void deleteUserRole(@Param("userid") String userid);

    void addUserRole(List<Map<String, String>> list);


}
