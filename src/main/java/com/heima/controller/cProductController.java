package com.heima.controller;

import com.heima.pojo.Product;
import com.heima.pojo.Result;
import com.heima.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")  //抽取路徑前墜
@Tag(name = "3.Product產品資訊")
public class cProductController {

    @Autowired
    ProductService productService;

    /**
     * 新增
     * @param product
     * @return
     */
    @Operation(summary = "新增-產品資訊")
    @Schema()
    @PostMapping("/product")
//新
    public Result productInsert(@RequestBody Product product){
        return productService.insert(product);
    }
//刪
    @Operation(summary = "刪除-依照主鍵ID[s]-產品資訊")
    @DeleteMapping("/delete/{ids}")
    public Result productDeleteById(@PathVariable List<Integer> ids){
        return productService.delete(ids);
    }
//修
    @Transactional
    @Operation(summary = "修改-依照主鍵ID-產品資訊")
    @PutMapping("/updateByID")
    public Result productUpdate(@RequestBody Product product){
        return productService.update(product);
    }

    @Operation(summary = "修改-依照ShopID-產品資訊-category", description = "統一將[oldCategory]參數修改成[newCategory]參數")
    @PutMapping("/updateByCategory")
    public Result productUpdate(@RequestParam Integer shopID, @RequestParam String oldCategory, @RequestParam String newCategory){
        return productService.updateCategory(shopID, oldCategory, newCategory);
    }
//查
    @Operation(summary = "查詢-所有-產品資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result productSelectAll(){
        return productService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-產品資訊")
    @GetMapping("/selectById/{productID}")
    public Result selectById(@PathVariable Integer productID){
        return productService.selectByID(productID);
    }
}
