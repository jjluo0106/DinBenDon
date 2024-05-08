package com.heima.controller;
import com.heima.pojo.*;
import com.heima.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")  //抽取路徑前墜
@Tag(name = "8.Admin-店家相關")
public class xAdminShopRelatedController {

    @Autowired
    AdminShopRelatedService adminShopRelatedService;


    /**
     * 新增
     */
    @Operation(summary = "新增-對象2.3.4", description = "快速組裝所有菜單所需欄位(主鍵未知不用填，統一交由後端給值)")
    @PostMapping("/addShopRelated")
    @Transactional
    public Result adminInsert(@RequestBody Object2to4 object2To4){
        Result r = adminShopRelatedService.add234(object2To4);

        return r;
    }
    /**
     * 查詢Shop的Add
     */
    @Operation(summary = "查詢-Add-依照ShopId-對象2.3.4")
    @GetMapping("/selectAddByShopID/{ShopID}")
    public Result selectById(@PathVariable Integer ShopID){
        log.info("ShopID: {} 查詢添加&備註", ShopID);
        return adminShopRelatedService.select234ByShopID(ShopID);
    }


}
