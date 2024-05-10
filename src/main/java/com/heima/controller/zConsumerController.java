package com.heima.controller;

import com.heima.pojo.AdminMadeOrder;
import com.heima.pojo.ConsumerRelated;
import com.heima.pojo.Result;
import com.heima.service.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/consumer")  //抽取路徑前墜
@Tag(name = "8.Consumer-消費者相關")
public class zConsumerController {

    @Autowired
    ConsumerService consumerService;

    //------------------------新----------------------------
    /**
     * 新增-消費者訂單與明細
     */
    @Operation(summary = "新增-消費者訂單與明細", description = "")
    @PostMapping("/addConsumerOrderRelated")
    @Transactional
    public Result shopRelatedInsert(@RequestBody ConsumerRelated consumerRelated){
        Result r = consumerService.consumerRelatedInsert(consumerRelated);

        return r;
    }

//    /**
//     * 新增-管理員發起訂單
//     */
////    @Operation(summary = "新增-管理員發起訂單", description = "快速組裝所有菜單所需欄位(主鍵未知不用填，統一交由後端給值)")
////    @PostMapping("/addAdminMadeOrder")
////    @Transactional
//    public Result adminMadeOrderInsert(@RequestBody AdminMadeOrder adminMadeOrder){
//        Result r = consumerService.addAdminMadeOrder(adminMadeOrder);
//
//        return r;
//    }

    //------------------------刪----------------------------

    //------------------------修----------------------------

    //------------------------查----------------------------


    /**
     * 查詢-消費者訂單與明細
     */
    @Operation(summary = "查詢-消費者訂單與明細-依照consumerOrderListID")
    @GetMapping("/selectAddByShopID/{consumerOrderListID}1")
    public Result selectShopRelatedById(@PathVariable Integer consumerOrderListID){
        log.info("ShopID: {} 查詢添加&備註", consumerOrderListID);
        return consumerService.selectConsumerRelatedByOrderListID(consumerOrderListID);
    }


}
