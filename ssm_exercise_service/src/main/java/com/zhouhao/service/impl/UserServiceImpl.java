package com.zhouhao.service.impl;

import com.zhouhao.dao.PermissionDao;
import com.zhouhao.dao.RoleDao;
import com.zhouhao.dao.UserDao;
import com.zhouhao.entity.Permission;
import com.zhouhao.entity.Role;
import com.zhouhao.entity.UserInfo;
import com.zhouhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    PermissionDao permissionDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo byUsername = userDao.getByUsername(s);

        List<GrantedAuthority> authoritys = getAuthority(byUsername.getRoles());
        boolean enabled = byUsername.getStatus() == 1;

        return new User(byUsername.getUsername(), byUsername.getPassword(),
                enabled, true, true, true, authoritys);
    }
    public List<GrantedAuthority> getAuthority(List<Role> roles){
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for(Role role: roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return grantedAuthorities;
    }

    @Override
    public List<UserInfo> getList() {
        return userDao.getList();
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public List<Role> roleList() {
        return roleDao.roleList();
    }

    @Override
    public void roleSave(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Permission> permissionList() {
        return permissionDao.permissionList();
    }

    @Override
    public void permissionSave(Permission permission) {
        permissionDao.permissionSave(permission);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for(String roleId: roleIds){
            userDao.addRoletoUser(userId, roleId);
        }
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for(String permissionId: ids){
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("root"));
        //$2a$10$H1S177nYcFEFkShXsX4Ka.VJEqD2L71QkC1Ij.hpk3BQISRbnF2yK
        //$2a$10$a2eVj5Ms.EmtlTpfbzSN..9yKzCW16QCOM4kejyBWFNUbECDvZKVu
        //$2a$10$RMDua3a1mg0iCHcXdcpPKuw1gqD9KO/m.K7QlLFMbaY3pCxQQmE.2
    }
}
