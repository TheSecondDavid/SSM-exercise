package com.zhouhao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;

    public String getCredentialsTypeStr() {
        if(credentialsType == 0)
            return "身份证";
        else if(credentialsType == 1)
            return "护照";
        else if(credentialsType == 2)
            return "军官证";
        else
            return "大象证";
    }
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;
}
