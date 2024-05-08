package com.heima.controller;
import com.heima.pojo.Result;
import com.heima.pojo.User;
import com.heima.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")  //抽取路徑前墜
@Tag(name = "1.User使用者")
public class aUserController {

    @Autowired
    UserService userService;


    /**
     * 新增
     * @param user
     * @return
     */
    @Operation(summary = "新增-用戶", description = "帳號: e-mail账号/ 密碼 : 長度需為8~15個字符")
    @Schema()
    @PostMapping("/add")

    public Result userInsert(@RequestBody User user){
        Result r = userService.UserInsert(user);

        return r;
    }

    @Operation(summary = "刪除-依照主鍵ID[s]-用戶")
    @DeleteMapping("/delete/{ids}")
    public Result userDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除用戶");
        return userService.delete(ids);
    }

    @Transactional
    @Operation(summary = "修改-依照主鍵ID-用戶", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/update")

    public Result userUpdate(
            @Parameter(description = "用户ID", example = "1", required = true) Integer id,
            @Parameter(description = "帳號", example = "abcd5678" )@RequestParam(required = false) String account,
            @Parameter(description = "密碼", example = "12345678")@RequestParam(required = false) String passWord,
            @Parameter(description = "使用者稱謂", example = "九面")@RequestParam(required = false) String userName,
            @Parameter(description = "手機號碼", example = "0912345678")@RequestParam(required = false) String phone,
            @Parameter(description = "圖片", example = "1")@RequestParam(required = false) String image,
            @Parameter(description = "用戶等級", example = "1")@RequestParam(required = false) Integer level)

    {
        log.info("修改用戶");
        User user = new User();
        user.setUserID(id);
        user.setAccount(account);
        user.setPassWord(passWord);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setImage(image);
        user.setLevel(level);
        log.info("修改數據 : {}",user);
        return userService.userUpdate(user);


    }

    @Operation(summary = "查詢-所有-用戶", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result userSelectAll(){
        log.info("查詢所有用戶");
        return userService.userSelectAll();
    }

    @Operation(summary = "查詢-依照account-用戶", parameters = {
            @Parameter(name = "account", description = "使用者帳號", example = "john_doe")
    })
    @GetMapping("/selectByAccount/{account}")
    public Result selectById(@PathVariable String account){
        log.info("依照account: {} 查詢用戶", account);
        return userService.selectByAccount(account);
    }
}
