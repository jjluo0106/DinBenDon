package com.heima.controller;

import com.heima.pojo.Result;
import com.heima.pojo.ConsumerOrderList;
import com.heima.service.ConsumerOrderListService;
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
@RequestMapping("/consumerOrderList")  //抽取路徑前墜
@Tag(name = "6.ConsumerOrderList用戶訂單")
public class fConsumerOrderListController {

    @Autowired
    ConsumerOrderListService consumerOrderListService;

    /**
     * 新增
     * @param consumerOrderList
     * @return
     */
    @Operation(summary = "新增-用戶訂單")
    @Schema()
    @PostMapping("/consumerOrderList")

    public Result consumerOrderListInsert(@RequestBody ConsumerOrderList consumerOrderList){
        return consumerOrderListService.insert(consumerOrderList);
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-consumerOrderList")
    @DeleteMapping("/delete/{ids}")
    public Result consumerOrderListDeleteById(@PathVariable List<Integer> ids){
        return consumerOrderListService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-consumerOrderList")
    @PutMapping("/updateByID")
    public Result consumerOrderListUpdate(@RequestBody ConsumerOrderList consumerOrderList){
        return consumerOrderListService.update(consumerOrderList);
    }

    @Operation(summary = "查詢-所有-consumerOrderList", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result consumerOrderListSelectAll(){
        return consumerOrderListService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-consumerOrderList")
    @GetMapping("/selectById/{consumerOrderListID}")
    public Result selectById(@PathVariable Integer consumerOrderListID){
        return consumerOrderListService.selectByID(consumerOrderListID);
    }
}
