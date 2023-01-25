package com.zhouhao.service;

import com.zhouhao.entity.Permission;
import com.zhouhao.entity.Role;
import com.zhouhao.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> getList();

    UserInfo findById(String id);

    void save(UserInfo userInfo);

    List<Role> roleList();

    void roleSave(Role role);

    List<Permission> permissionList();

    void permissionSave(Permission permission);

    void addRoleToUser(String userId, String[] roleIds);

    Role findRoleById(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
