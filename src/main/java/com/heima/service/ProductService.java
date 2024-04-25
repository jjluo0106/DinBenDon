package com.heima.service;

import com.heima.mapper.ProductMapper;
import com.heima.pojo.Result;
import com.heima.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;




    // 新

    public Result insert(Product product) {

            productMapper.insert(product);
            return Result.success("創建成功");

    }

    // 刪

    public int delete(List<Integer> ids) {
        return productMapper.delete(ids);
    }
    // 修

    public Result update(Product product) {


        productMapper.update(product);
        return Result.success("修改成功");
    }
    //查

    public List<Product> selectByProductName(String account) {
        return productMapper.selectByProductName(account);
    }

    public List<Product> selectAll() {
        return productMapper.selectAll();
    }


}
