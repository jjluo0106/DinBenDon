package com.heima.controller;

import com.heima.pojo.Result;
import com.heima.pojo.UserRecord;
import com.heima.service.UserRecordService;
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
@RequestMapping("/userRecord")  //抽取路徑前墜
@Tag(name = "7.UserRecord用戶已完成訂單")
public class UserRecordContoller {

    @Autowired
    UserRecordService userRecordService;

    /**
     * 新增
     * @param userRecord
     * @return
     */
    @Operation(summary = "新增-用戶已完成訂單", description = "限時發起給用戶下訂使用的用戶已完成訂單")
    @Schema()
    @PostMapping("/userRecord")

    public Result userRecordInsert(@RequestBody UserRecord userRecord){
        Result r = userRecordService.insert(userRecord);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-用戶已完成訂單")
    @DeleteMapping("/delete/{ids}")
    public Result userRecordDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除添加&備註");
        int i = userRecordService.delete(ids);
        if(i>0){
            log.info("刪除[用戶已完成訂單]成功，刪除了: {}", i);
        }else {
            log.info("刪除[用戶已完成訂單]失敗");
            return Result.fail("刪除[用戶已完成訂單]失敗","");
        }
        return Result.success("刪除成功");
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-用戶已完成訂單", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/updateByID")

    public Result userRecordUpdate(@RequestBody UserRecord userRecord)

    {
        log.info("修改用戶已完成訂單");

        Result result = userRecordService.update(userRecord);

        return result;
    }

    @Operation(summary = "查詢-所有-用戶已完成訂單", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result userRecordSelectAll(){
        log.info("查詢所有[用戶已完成訂單]");
        List<UserRecord> userRecord = userRecordService.selectAll();
        return Result.success(userRecord);
    }

    @Operation(summary = "查詢-依照主鍵ID-用戶已完成訂單")
    @GetMapping("/selectByUserRecordID/{userRecordID}")
    public Result selectById(@PathVariable Integer userRecordID){
        log.info("依照UserRecordID: {} [用戶已完成訂單]", userRecordID);
        UserRecord userRecord = userRecordService.selectByID(userRecordID);
        return Result.success(userRecord);
    }
}
