package com.zhouhao.service.impl;

import com.zhouhao.dao.ProductDao;
import com.zhouhao.entity.Product;
import com.zhouhao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getlist() {
        return productDao.selectAll();
    }

    @Override
    public void save(Product product) {
        product.setId(String.valueOf(UUID.randomUUID()));
        int maxNum = 1;
        List<Product> products = productDao.selectAll();
        for (Product value : products) {
            int cur = Integer.parseInt(value.getProductNum().substring(7, 10));
            if (cur > maxNum)
                maxNum = cur;
        }
        maxNum += 1;
        product.setProductNum("itcast-" + threeLengthNum(maxNum));
        productDao.save(product);
    }

    private String threeLengthNum(int num){
        if(num < 10)
            return "00" + num;
        else if(num < 100)
            return "0" + num;
        else
            return String.valueOf(num);
    }
}
