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
@Tag(name = "8.Admin-管理員相關")
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
     * 查詢ShopRelated-依照shopID
     */
    @Operation(summary = "查詢-店家對象2.3.4-依照shopID")
    @GetMapping("/selectAddByShopID/{ShopID}")
    public Result selectShopRelatedById(@PathVariable Integer ShopID){
        return adminService.select234ByShopID(ShopID);
    }

    /**
     * 查詢[所有]-管理員發起訂單
     */
    @Operation(summary = "查詢[所有]-管理員發起訂單")
    @GetMapping("/selectAllAdminMadeOrder")
    public Result selectAdminMadeOrder(){
        return adminService.selectAllAdminMadeOrder();
    }


    /**
     * 查詢[所有]-管理員發起訂單
     */
    @Operation(summary = "查詢[單一]-管理員發起訂單-AdminMadeOrderID")
    @GetMapping("/selectAllAdminMadeOrderByID/{adminMadeOrderID}")
    @Transactional
    public Result selectAdminMadeOrderById(@PathVariable Integer adminMadeOrderID){
        log.info("查詢 管理員發起訂單----------{}", adminMadeOrderID);
        return adminService.selectAdminMadeOrderByID(adminMadeOrderID);
    }


}
