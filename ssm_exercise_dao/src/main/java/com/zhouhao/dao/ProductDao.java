package com.zhouhao.dao;

import com.zhouhao.entity.Product;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ProductDao {
    @Select("select * from product")
    public List<Product> selectAll();

    void save(Product product);
}
