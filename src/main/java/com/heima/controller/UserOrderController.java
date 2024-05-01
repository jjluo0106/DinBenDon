package com.heima.controller;

import com.heima.pojo.UserOrder;
import com.heima.pojo.Result;
import com.heima.service.UserOrderService;
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
@RequestMapping("/userOrder")  //抽取路徑前墜
@Tag(name = "6.UserOrder用戶下定訂單")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderService;

    /**
     * 新增
     * @param userOrder
     * @return
     */
    @Operation(summary = "新增-用戶下定訂單", description = "限時發起給用戶下訂使用的用戶下定訂單")
    @Schema()
    @PostMapping("/userOrder")

    public Result userOrderInsert(@RequestBody UserOrder userOrder){
        Result r = userOrderService.insert(userOrder);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-用戶下定訂單")
    @DeleteMapping("/delete/{ids}")
    public Result userOrderDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除添加&備註");
        int i = userOrderService.delete(ids);
        if(i>0){
            log.info("刪除[用戶下定訂單]成功，刪除了: {}", i);
        }else {
            log.info("刪除[用戶下定訂單]失敗");
            return Result.fail("刪除[用戶下定訂單]失敗","");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-用戶下定訂單")
    @PutMapping("/updateByID")

    public Result userOrderUpdate(@RequestBody UserOrder userOrder)

    {
        log.info("修改用戶下定訂單");

        Result result = userOrderService.update(userOrder);

        return result;
    }

    @Operation(summary = "查詢-所有-用戶下定訂單")
    @GetMapping("/selectAll")
    public Result userOrderSelectAll(){
        log.info("查詢所有[用戶下定訂單]");
        List<UserOrder> userOrder = userOrderService.selectAll();
        return Result.success(userOrder);
    }

    @Operation(summary = "查詢-依照主鍵ID-用戶下定訂單")
    @GetMapping("/selectByUserOrderID/{userOrderID}")
    public Result selectById(@PathVariable Integer userOrderID){
        log.info("依照UserOrderID: {} [用戶下定訂單]", userOrderID);
        UserOrder userOrder = userOrderService.selectByID(userOrderID);
        return Result.success(userOrder);
    }
}
