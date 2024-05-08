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
public class dAddController {

    @Autowired
    AddService addService;

    /**
     * 新增
     * @param add
     * @return
     */
    @Operation(summary = "新增-添加&備註資訊")
    @Schema()
    @PostMapping("/add")

    public Result addInsert(@RequestBody Add add){
        return addService.insert(add);
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-添加&備註資訊")
    @DeleteMapping("/delete/{ids}")
    public Result addDeleteById(@PathVariable List<Integer> ids){
        return addService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-添加&備註資訊")
    @PutMapping("/updateByID")
    public Result addUpdate(@RequestBody Add add){
        return addService.update(add);
    }

    @Operation(summary = "查詢-所有-添加&備註資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result addSelectAll(){
        return addService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-添加&備註資訊")
    @GetMapping("/selectById/{addID}")
    public Result selectById(@PathVariable Integer addID){
        return addService.selectByID(addID);
    }
}
