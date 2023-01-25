package com.zhouhao.dao;

import com.zhouhao.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserDao {
    UserInfo getByUsername(String username);
    List<UserInfo> getList();

    UserInfo findById(String id);

    void save(UserInfo userInfo);
    void addRoletoUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
