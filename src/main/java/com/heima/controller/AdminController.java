package com.heima.controller;
import com.heima.pojo.*;
import com.heima.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")  //抽取路徑前墜
@Tag(name = "9.Admin管理員專用接口")
public class AdminController {

    @Autowired
    AdminService adminService;


    /**
     * 新增
     */
    @Operation(summary = "新增-對象2.3.4", description = "快速組裝所有菜單所需欄位(主鍵未知不用填，統一交由後端給值)")
    @PostMapping("/add234")
    @Transactional
    public Result adminInsert(@RequestBody Object2to4 object2To4){
        Result r = adminService.add234(object2To4);

        return r;
    }
    /**
     * 查詢
     */
    @Operation(summary = "查詢-依照主鍵ID-對象2.3.4")
    @GetMapping("/select234ByShopID/{ShopID}")
    public Result selectById(@PathVariable Integer ShopID){
        log.info("依照addName: {} 查詢添加&備註", ShopID);
        return adminService.select234ByShopID(ShopID);
    }


}
