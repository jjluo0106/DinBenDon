package com.heima.mapper;
import com.heima.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    public void insert(Product product);

    int delete(List<Integer> ids);

    int update(Product product);

    List<Product> selectAll();

    List<Product> selectByProductName(String account);

    Product selectByID(Integer productID);

    List<Product> selectByShopID(Integer shopID);
}
