package com.zhouhao.dao;

import com.zhouhao.entity.Permission;
import java.util.List;

public interface PermissionDao {
    List<Permission> permissionList();
    void permissionSave(Permission permission);
}
