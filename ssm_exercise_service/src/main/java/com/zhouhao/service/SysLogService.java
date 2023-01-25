package com.zhouhao.service;

import com.zhouhao.entity.SysLog;

import java.util.List;

public interface SysLogService {
    List<SysLog> getList();

    void save(SysLog sysLog);
}
