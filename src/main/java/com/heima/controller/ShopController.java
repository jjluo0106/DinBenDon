package com.heima.controller;
import com.heima.pojo.Result;
import com.heima.pojo.Shop;
import com.heima.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shop")  //抽取路徑前墜
@Tag(name = "2.Shop店家資訊")
public class ShopController {

    @Autowired
    ShopService shopService;

    /**
     * 新增
     * @param shop
     * @return
     */
    @Operation(summary = "新增店家資訊", description = "帳號:e-mail/密碼規則皆是:英文小寫+數字需大於等於8個字節，不出過15字節")
    @Schema()
    @PostMapping("/add")

    public Result shopInsert(@RequestBody Shop shop){
        Result r = shopService.shopInsert(shop);

        return r;
    }

    @Operation(summary = "刪除店家")
    @DeleteMapping("/delete/{ids}")
    public Result shopDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除店家");
        int i = shopService.shopDelete(ids);
        if(i>0){
            log.info("刪除成功，刪除了: {}", i);
        }else {
            log.info("刪除失敗");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "依照ID修改店家", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/updateByID")

    public Result shopUpdate(@RequestBody Shop shop)

    {
        log.info("修改店家");

        Result result = shopService.shopUpdate(shop);

        return result;
    }

    @Operation(summary = "查詢所有店家", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result shopSelectAll(){
        log.info("查詢所有店家");
        List<Shop> shop = shopService.shopSelectAll();
        return Result.success(shop);
    }

    @Operation(summary = "依照名稱參數查詢店家", parameters = {
            @Parameter(name = "account", description = "使用者帳號", example = "jay0609@gmail.com")
    })
    @GetMapping("/selectByShopName/{shopName}")
    public Result selectById(@PathVariable String shopName){
        log.info("依照shopName: {} 查詢店家", shopName);
        Shop shop = shopService.selectByShopName(shopName);
        return Result.success(shop);
    }
}
