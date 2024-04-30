package com.heima.controller;

import com.heima.pojo.Result;
import com.heima.pojo.TotalOrder;
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
public class TotalOrderContoller {

    @Autowired
    TotalOrderService totalOrderService;

    /**
     * 新增
     * @param totalOrder
     * @return
     */
    @Operation(summary = "新增-管理員帳單", description = "管理員最後結帳之帳單")
    @Schema()
    @PostMapping("/totalOrder")

    public Result totalOrderInsert(@RequestBody TotalOrder totalOrder){
        Result r = totalOrderService.insert(totalOrder);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-管理員帳單")
    @DeleteMapping("/delete/{ids}")
    public Result totalOrderDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除添加&備註");
        int i = totalOrderService.delete(ids);
        if(i>0){
            log.info("刪除[管理員帳單]成功，刪除了: {}", i);
        }else {
            log.info("刪除[管理員帳單]失敗");
            return Result.fail("刪除[管理員帳單]失敗","");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-管理員帳單", description = "泛用修改接口 : 需要修改的參數給值就好; 但主鍵，創建日期，修改日期皆不能改")
    @PutMapping("/updateByID")

    public Result totalOrderUpdate(@RequestBody TotalOrder totalOrder)

    {
        log.info("修改管理員帳單");

        Result result = totalOrderService.update(totalOrder);

        return result;
    }

    @Operation(summary = "查詢-所有-管理員帳單", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result totalOrderSelectAll(){
        log.info("查詢所有[管理員帳單]");
        List<TotalOrder> totalOrder = totalOrderService.selectAll();
        return Result.success(totalOrder);
    }

    @Operation(summary = "查詢-依照主鍵ID-管理員帳單")
    @GetMapping("/selectByTotalOrderID/{totalOrderID}")
    public Result selectById(@PathVariable Integer totalOrderID){
        log.info("依照TotalOrderID: {} [管理員帳單]", totalOrderID);
        TotalOrder totalOrder = totalOrderService.selectByID(totalOrderID);
        return Result.success(totalOrder);
    }
}
