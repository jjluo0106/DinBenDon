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
    @Operation(summary = "新增-菜單", description = "限時發起給用戶下訂使用的菜單")
    @Schema()
    @PostMapping("/menu")

    public Result menuInsert(@RequestBody Menu menu){
        Result r = menuService.insert(menu);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-菜單")
    @DeleteMapping("/delete/{ids}")
    public Result menuDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除添加&備註");
        int i = menuService.delete(ids);
        if(i>0){
            log.info("刪除成功，刪除了: {}", i);
        }else {
            log.info("刪除失敗");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-菜單", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/updateByID")

    public Result menuUpdate(@RequestBody Menu menu)

    {
        log.info("修改菜單");

        Result result = menuService.update(menu);

        return result;
    }

    @Operation(summary = "查詢-所有-菜單", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result menuSelectAll(){
        log.info("查詢所有添加&備註");
        List<Menu> menu = menuService.selectAll();
        return Result.success(menu);
    }

    @Operation(summary = "查詢-依照主鍵ID-菜單")
    @GetMapping("/selectByMenuID/{menuID}")
    public Result selectById(@PathVariable Integer menuID){
        log.info("依照menuName: {} 查詢添加&備註", menuID);
        Menu menu = menuService.selectByID(menuID);
        return Result.success(menu);
    }
}
