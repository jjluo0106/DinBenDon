package com.heima.controller;

import com.heima.pojo.Add;
import com.heima.pojo.Result;
import com.heima.service.AddService;
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
@RequestMapping("/add")  //抽取路徑前墜
@Tag(name = "4.Add添加&備註")
public class AddController {

    @Autowired
    AddService addService;

    /**
     * 新增
     * @param add
     * @return
     */
    @Operation(summary = "新增-添加&備註資訊", description = "帳號: e-mail账号/ 密碼 : 8 <= 密馬字節長度 <= 15，帳號不得重複")
    @Schema()
    @PostMapping("/add")

    public Result addInsert(@RequestBody Add add){
        Result r = addService.insert(add);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-添加&備註資訊")
    @DeleteMapping("/delete/{ids}")
    public Result addDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除添加&備註");
        int i = addService.delete(ids);
        if(i>0){
            log.info("刪除成功，刪除了: {}", i);
        }else {
            log.info("刪除失敗");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-添加&備註資訊", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/updateByID")

    public Result addUpdate(@RequestBody Add add)

    {
        log.info("修改添加&備註資訊");

        Result result = addService.update(add);

        return result;
    }

    @Operation(summary = "查詢-所有-添加&備註資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result addSelectAll(){
        log.info("查詢所有添加&備註");
        List<Add> add = addService.selectAll();
        return Result.success(add);
    }

    @Operation(summary = "查詢-依照主鍵ID-添加&備註資訊")
    @GetMapping("/selectByAddName/{addName}")
    public Result selectById(@PathVariable String addName){
        log.info("依照addName: {} 查詢添加&備註", addName);
        List<Add> list = addService.selectByAddName(addName);
        return Result.success(list);
    }
}
