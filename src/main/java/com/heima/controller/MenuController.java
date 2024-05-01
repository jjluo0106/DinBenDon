package com.heima.controller;

import com.heima.pojo.Menu;
import com.heima.pojo.Result;
import com.heima.service.MenuService;
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
@RequestMapping("/menu")  //抽取路徑前墜
@Tag(name = "5.Menu發起菜單")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 新增
     * @param menu
     * @return
     */
    @Operation(summary = "新增-添加&備註資訊")
    @Schema()
    @PostMapping("/menu")

    public Result menuInsert(@RequestBody Menu menu){
        return menuService.insert(menu);
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-添加&備註資訊")
    @DeleteMapping("/delete/{ids}")
    public Result menuDeleteById(@PathVariable List<Integer> ids){
        return menuService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-添加&備註資訊")
    @PutMapping("/updateByID")
    public Result menuUpdate(@RequestBody Menu menu){
        return menuService.update(menu);
    }

    @Operation(summary = "查詢-所有-添加&備註資訊", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result menuSelectAll(){
        return menuService.selectAll();
    }

    @Operation(summary = "查詢-依照主鍵ID-添加&備註資訊")
    @GetMapping("/selectById/{menuID}")
    public Result selectById(@PathVariable Integer menuID){
        return menuService.selectByID(menuID);
    }
}
