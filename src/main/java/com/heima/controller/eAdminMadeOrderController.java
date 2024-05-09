package com.heima.controller;

import com.heima.pojo.Result;
import com.heima.pojo.AdminMadeOrder;
import com.heima.service.AdminMadeOrderService;
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
@RequestMapping("/adminMadeOrder")  //抽取路徑前墜
@Tag(name = "5.AdminMadeOrder管理員發起訂單")
public class eAdminMadeOrderController {

    @Autowired
    AdminMadeOrderService adminMadeOrderService;

    /**
     * 新增
     * @param adminMadeOrder
     * @return
     */
    @Operation(summary = "新增-管理員發起訂單")
    @Schema()
    @PostMapping("/adminMadeOrder")

    public Result adminMadeOrderInsert(@RequestBody AdminMadeOrder adminMadeOrder){
        return adminMadeOrderService.insert(adminMadeOrder);
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-管理員發起訂單")
    @DeleteMapping("/delete/{ids}")
    public Result adminMadeOrderDeleteById(@PathVariable List<Integer> ids){
        return adminMadeOrderService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-管理員發起訂單")
    @PutMapping("/updateByID")
    public Result adminMadeOrderUpdate(@RequestBody AdminMadeOrder adminMadeOrder){
        return adminMadeOrderService.update(adminMadeOrder);
    }

    @Operation(summary = "查詢-所有-管理員發起訂單", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result adminMadeOrderSelectAll(){
        return adminMadeOrderService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-管理員發起訂單")
    @GetMapping("/selectById/{adminMadeOrderID}")
    public Result selectById(@PathVariable Integer adminMadeOrderID){
        return adminMadeOrderService.selectByID(adminMadeOrderID);
    }
}
