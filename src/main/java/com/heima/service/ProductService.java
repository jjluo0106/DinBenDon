package com.heima.service;

import com.heima.mapper.ProductMapper;
import com.heima.pojo.Product;
import com.heima.pojo.Result;
import com.heima.pojo.Product;
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
    // 刪
    public Result delete(List<Integer> ids) {
        List<Product> products = productMapper.selectByIDs(ids); // 刪除前先查詢
        int num = productMapper.delete(ids);

        if (num>0){
            return Result.success("product 刪除- " + num + "筆，date: [product刪除前對象參數]", products);
        }else {
            return Result.fail("product 刪除- " + num + "筆", "");
        }
    }
    // 修
    public Result update(Product product) {
        productMapper.update(product);
        return Result.success("product 依據[id]修改，data: [product修改後對象參數]", productMapper.selectByID(product.getProductID()));
    }

    public Result updateCategory(Integer productID, String oldCategory, String newCategory) {
        return Result.success("product 依據[productID]修改，data: [product修改後對象參數]", productMapper.updateCategory(productID, oldCategory, newCategory));
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
