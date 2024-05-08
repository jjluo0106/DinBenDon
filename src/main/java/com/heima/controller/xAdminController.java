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
public class xAdminController {

    @Autowired
    AdminService adminService;

    //------------------------新----------------------------
    /**
     * 新增-店家對象
     */
    @Operation(summary = "新增-店家相關對象2.3.4", description = "快速組裝所有菜單所需欄位(主鍵未知不用填，統一交由後端給值)")
    @PostMapping("/addShopRelated")
    @Transactional
    public Result shopRelatedInsert(@RequestBody ShopRelated shopRelated){
        Result r = adminService.add234(shopRelated);

        return r;
    }

    /**
     * 新增-管理員發起訂單
     */
    @Operation(summary = "新增-管理員發起訂單", description = "快速組裝所有菜單所需欄位(主鍵未知不用填，統一交由後端給值)")
    @PostMapping("/addAdminMadeOrder")
    @Transactional
    public Result adminMadeOrderInsert(@RequestBody AdminMadeOrder adminMadeOrder){
        Result r = adminService.addAdminMadeOrder(adminMadeOrder);

        return r;
    }

    //------------------------刪----------------------------

    //------------------------修----------------------------

    //------------------------查----------------------------


    /**
     * 查詢Shop的Add
     */
    @Operation(summary = "查詢-店家對象2.3.4-依照shopID")
    @GetMapping("/selectAddByShopID/{ShopID}")
    public Result selectShopRelatedById(@PathVariable Integer ShopID){
        log.info("ShopID: {} 查詢添加&備註", ShopID);
        return adminService.select234ByShopID(ShopID);
    }

    /**
     * 查詢Shop的Add
     */
    @Operation(summary = "查詢-管理員發起訂單")
    @GetMapping("/selectAllAdminMadeOrderByID")
    public Result selectAdminMadeOrderById(){
        log.info("AdminMadeOrderID: {} 查詢 管理員發起訂單");
        return adminService.selectAdminMadeOrderById();
    }


}
