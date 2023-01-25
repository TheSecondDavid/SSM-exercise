package com.zhouhao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
private String id;
private String permissionName;
private String url;
private List<Role> roles;
}