package com.heima.service;

import com.heima.mapper.ProductMapper;
import com.heima.pojo.Product;
import com.heima.pojo.Result;
import com.heima.util.MyUtils;
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
        product.setCreateTime(MyUtils.getNow());
        product.setUpdateTime(MyUtils.getNow());
        return Result.success("product 新增，data: [product創建後對象參數]", product);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        int i = productMapper.delete(ids);
        if(i>0){
            return Result.success("product 刪除，data: [刪除數量]", i);
        }else {
            return Result.success("無匹配id",i);
        }
    }
    // 修
    public Result update(Product product) {
        productMapper.update(product);
        return Result.success("product 依據[id]修改，data: [product修改後對象參數]", productMapper.selectByID(product.getProductID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("product 依據[id]查詢，data: [product查詢對象參數]", productMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("product 所有查詢，data: [product所有查詢對象參數]", productMapper.selectAll());
    }
}
