package com.zhouhao.controller;

import com.zhouhao.entity.Permission;
import com.zhouhao.entity.Role;
import com.zhouhao.entity.UserInfo;
import com.zhouhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getList")
    public ModelAndView getList(){
        List<UserInfo> users = userService.getList();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-list");
        mv.addObject("userList", users);
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("/save")
    public ModelAndView save(UserInfo userInfo){
        userService.save(userInfo);
        List<UserInfo> users = userService.getList();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-list");
        mv.addObject("userList", users);
        return mv;
    }
    @RequestMapping("/roleList")
    public ModelAndView roleFindAll(){
        ModelAndView mv = new ModelAndView("role-list");
        List<Role> roles = userService.roleList();
        mv.addObject("roleList", roles);
        return mv;
    }
    @RequestMapping("/roleSave")
    public String RoleSave(Role role){
        userService.roleSave(role);
        return "redirect:roleList";
    }
    @RequestMapping("/permissionList")
    public ModelAndView permissionFindAll(){
        List<Permission> permissions = userService.permissionList();
        ModelAndView mv = new ModelAndView("permission-list");
        mv.addObject("permissionList", permissions);
        return mv;
    }
    @RequestMapping("/permissionSave")
    public String permissionSave(Permission permission){
        userService.permissionSave(permission);
        return "redirect:permissionList";
    }
    @RequestMapping("/getRoleByUserId")
    public ModelAndView getRoleByUserId(String id){
        List<Role> roles = userService.roleList();
        UserInfo userInfo = userService.findById(id);
        List<Role> roleList = userInfo.getRoles();
        for(Role role: roleList) {
            roles.remove(role);
        }
        ModelAndView mv = new ModelAndView("user-role-add");
        mv.addObject("roleList", roles);
        mv.addObject("user", userInfo);
        return mv;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids){
        userService.addRoleToUser(userId, ids);
        return "redirect:getList";
    }
    @RequestMapping("/getPermissionByRoleId")
    public ModelAndView getPermissionByRoleId(String id){
        List<Permission> permissions = userService.permissionList();
        Role role = userService.findRoleById(id);
        List<Permission> permissionList = role.getPermissions();
        for(Permission permission: permissionList) {
            permissions.remove(permission);
        }
        ModelAndView mv = new ModelAndView("role-permission-add");
        mv.addObject("permissionList", permissions);
        mv.addObject("role", role);
        return mv;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId, String[] ids){
        userService.addPermissionToRole(roleId, ids);
        return "redirect:roleList";
    }
}
