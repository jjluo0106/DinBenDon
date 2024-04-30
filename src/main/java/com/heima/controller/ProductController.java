package com.heima.controller;
import com.heima.pojo.Result;
import com.heima.pojo.Product;
import com.heima.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 新增
     * @param product
     * @return
     */
    @Operation(summary = "新增-產品資訊", description = "帳號，密碼規則皆是:英文小寫+數字需大於等於8個字節，不出過15字節")
    @Schema()
    @PostMapping("/add")

    public Result productInsert(@RequestBody Product product){
        Result r = productService.insert(product);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-產品資訊")
    @DeleteMapping("/delete/{ids}")
    public Result productDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除店家");
        int i = productService.delete(ids);
        if(i>0){
            log.info("刪除成功，刪除了: {}", i);
        }else {
            log.info("刪除失敗");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-產品資訊", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/updateByID")

    public Result productUpdate(@RequestBody Product product)

    {
        log.info("修改產品資訊");

        Result result = productService.update(product);

        return result;
    }

    @Operation(summary = "查詢-所有-產品資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result productSelectAll(){
        log.info("查詢所有店家");
        List<Product> product = productService.selectAll();
        return Result.success(product);
    }

    @Operation(summary = "查詢-依照主鍵ID-產品資訊")
    @GetMapping("/selectByProductName/{productName}")
    public Result selectById(@PathVariable String productName){
        log.info("依照productName: {} 查詢店家", productName);
        List<Product> list = productService.selectByProductName(productName);
        return Result.success(list);
    }
}
