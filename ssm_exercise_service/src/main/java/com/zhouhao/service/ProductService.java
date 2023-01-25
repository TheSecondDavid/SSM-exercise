package com.zhouhao.service;

import com.zhouhao.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getlist();

    void save(Product product);
}
