package com.heima.controller;

import com.heima.pojo.Shop;
import com.heima.pojo.Result;
import com.heima.service.ShopService;
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
@RequestMapping("/shop")  //抽取路徑前墜
@Tag(name = "2.Shop店家資訊")
public class ShopController {

    @Autowired
    ShopService shopService;

    /**
     * 新增
     * @param shop
     * @return
     */
    @Operation(summary = "新增-店家資訊")
    @Schema()
    @PostMapping("/shop")

    public Result shopInsert(@RequestBody Shop shop){
        return shopService.insert(shop);
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-店家資訊")
    @DeleteMapping("/delete/{ids}")
    public Result shopDeleteById(@PathVariable List<Integer> ids){
        return shopService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-店家資訊")
    @PutMapping("/updateByID")
    public Result shopUpdate(@RequestBody Shop shop){
        return shopService.update(shop);
    }

    @Operation(summary = "查詢-所有-店家資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result shopSelectAll(){
        return shopService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-店家資訊")
    @GetMapping("/selectById/{shopID}")
    public Result selectById(@PathVariable Integer shopID){
        return shopService.selectByID(shopID);
    }
}
