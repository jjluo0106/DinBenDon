package com.heima.controller;

import com.heima.pojo.Result;
import com.heima.pojo.ConsumerOrderDetail;
import com.heima.service.ConsumerOrderDetailService;
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
@RequestMapping("/consumerOrderDetail")  //抽取路徑前墜
@Tag(name = "7.ConsumerOrderDetail消費者產品個體明細")
public class gConsumerOrderDetailController {

    @Autowired
    ConsumerOrderDetailService consumerOrderDetailService;

    /**
     * 新增
     * @param consumerOrderDetail
     * @return
     */
    @Operation(summary = "新增-消費者產品個體明細")
    @Schema()
    @PostMapping("/consumerOrderDetail")

    public Result consumerOrderDetailInsert(@RequestBody ConsumerOrderDetail consumerOrderDetail){
        return consumerOrderDetailService.insert(consumerOrderDetail);
    }

//    @Operation(summary = "刪除-依照主鍵ID[s]-消費者產品個體明細")
//    @DeleteMapping("/delete/{ids}")
//    public Result consumerOrderDetailDeleteById(@PathVariable List<Integer> ids){
//        return consumerOrderDetailService.delete(ids);
//    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-消費者產品個體明細")
    @PutMapping("/updateByID")
    public Result consumerOrderDetailUpdate(@RequestBody ConsumerOrderDetail consumerOrderDetail){
        return consumerOrderDetailService.update(consumerOrderDetail);
    }

    @Operation(summary = "查詢-所有-消費者產品個體明細", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result consumerOrderDetailSelectAll(){
        return consumerOrderDetailService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-消費者產品個體明細")
    @GetMapping("/selectById/{consumerOrderDetailID}")
    public Result selectById(@PathVariable Integer consumerOrderDetailID){
        return consumerOrderDetailService.selectByID(consumerOrderDetailID);
    }
}
