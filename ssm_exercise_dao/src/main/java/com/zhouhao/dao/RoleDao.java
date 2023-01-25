package com.zhouhao.dao;

import com.zhouhao.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> roleList();

    void save(Role role);

    Role findRoleById(String id);

    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
