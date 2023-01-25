package com.zhouhao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
private String id;
private String roleName;
private String roleDesc;
private List<Permission> permissions;
private List<User> users;
}