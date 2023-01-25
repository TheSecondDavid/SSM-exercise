package com.zhouhao.entity;

import com.zhouhao.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    public String getVisitTimeStr() {
        return DateUtil.DateToStr(visitTime, "yyyy-mm-dd");
    }
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}