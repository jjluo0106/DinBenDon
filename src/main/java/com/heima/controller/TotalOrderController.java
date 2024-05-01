package com.heima.controller;

import com.heima.pojo.TotalOrder;
import com.heima.pojo.Result;
import com.heima.service.TotalOrderService;
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
@RequestMapping("/totalOrder")  //抽取路徑前墜
@Tag(name = "8.TotalOrder管理員帳單")
public class TotalOrderController {

    @Autowired
    TotalOrderService totalOrderService;

    /**
     * 新增
     * @param totalOrder
     * @return
     */
    @Operation(summary = "新增-添加&備註資訊")
    @Schema()
    @PostMapping("/totalOrder")

    public Result totalOrderInsert(@RequestBody TotalOrder totalOrder){
        return totalOrderService.insert(totalOrder);
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-添加&備註資訊")
    @DeleteMapping("/delete/{ids}")
    public Result totalOrderDeleteById(@PathVariable List<Integer> ids){
        return totalOrderService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-添加&備註資訊")
    @PutMapping("/updateByID")
    public Result totalOrderUpdate(@RequestBody TotalOrder totalOrder){
        return totalOrderService.update(totalOrder);
    }

    @Operation(summary = "查詢-所有-添加&備註資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result totalOrderSelectAll(){
        return totalOrderService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-添加&備註資訊")
    @GetMapping("/selectById/{totalOrderID}")
    public Result selectById(@PathVariable Integer totalOrderID){
        return totalOrderService.selectByID(totalOrderID);
    }
}
