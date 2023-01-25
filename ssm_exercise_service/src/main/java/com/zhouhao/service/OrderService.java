package com.zhouhao.service;

import com.zhouhao.entity.Order;
import java.util.List;

public interface OrderService {
    public List<Order> getList();

    Order getdetail(String id);
}
