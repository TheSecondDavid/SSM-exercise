package com.zhouhao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouhao.entity.Order;
import com.zhouhao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    public ModelAndView getList(@RequestParam(defaultValue = "1") Integer pageNow,@RequestParam(defaultValue = "4") Integer pageSize){
        // 这块好屌啊，怎么做到的？ orders在底层应该是被强转成了page对象
        PageHelper.startPage(pageNow, pageSize);
        List<Order> orders = orderService.getList();
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView getdetail(String id){
        Order order = orderService.getdetail(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", order);
        mv.setViewName("order-show");
        return mv;
    }
}
