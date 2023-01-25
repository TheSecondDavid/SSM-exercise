package com.zhouhao.service.impl;

import com.zhouhao.dao.SysLogDao;
import com.zhouhao.entity.SysLog;
import com.zhouhao.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogDao sysLogDao;

    @Override
    public List<SysLog> getList() {
        return sysLogDao.getList();
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
