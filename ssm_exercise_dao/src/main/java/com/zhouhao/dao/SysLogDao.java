package com.zhouhao.dao;

import com.zhouhao.entity.SysLog;
import java.util.List;

public interface SysLogDao {
    List<SysLog> getList();
    void save(SysLog sysLog);
}
