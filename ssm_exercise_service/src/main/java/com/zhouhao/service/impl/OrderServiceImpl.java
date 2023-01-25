package com.zhouhao.service.impl;

import com.zhouhao.dao.OrderDao;
import com.zhouhao.entity.Order;
import com.zhouhao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getList() {
        return orderDao.getList();
    }

    @Override
    public Order getdetail(String id) {
        return orderDao.getDetail(id);
    }
}
