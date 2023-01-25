package com.zhouhao.controller;

import com.zhouhao.entity.SysLog;
import com.zhouhao.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysLog")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;

    @RequestMapping("/getList")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView("sysLog-list");
        List<SysLog> sysLogs = sysLogService.getList();
        mv.addObject("sysLogs", sysLogs);
        return mv;
    }
}
