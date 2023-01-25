package com.zhouhao.dao;

import com.zhouhao.entity.Order;
import java.util.List;

public interface OrderDao {
    public List<Order> getList();

    Order getDetail(String id);
}
