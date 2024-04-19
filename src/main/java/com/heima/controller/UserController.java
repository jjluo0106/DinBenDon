package com.heima.controller;
import com.heima.pojo.Result;
import com.heima.pojo.User;
import com.heima.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")  //抽取路徑前墜
@Tag(name = "user使用者相關")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 新增
     * @param user
     * @return
     */
    @Operation(summary = "創建用戶", description = "帳號，密碼規則皆是:英文小寫+數字需大於等於8個字節，不出過15字節")
    @Schema()
    @PostMapping("/add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "創建成功",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Result.class, example = "{\"status\":\"success\",\"code\":200,\"message\":\"Request successful\",\"data\":\"新增成功\"}")
                    )
            ),
            @ApiResponse(responseCode = "400", description = "請求參數錯誤",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Result.class, example = "{\"status\":\"error\",\"code\":400,\"message\":\"Missing parameter: account\",\"data\":\"\"}")
                    )
            ),
            @ApiResponse(responseCode = "500", description = "服務器內部錯誤",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Result.class, example = "{\"status\":\"error\",\"code\":500,\"message\":\"Internal server error\",\"data\":\"\"}")
                    )
            )
    })
    public Result userInsert(@RequestBody User user){
        Result r = userService.UserInsert(user);

        return r;
    }

    @Operation(summary = "刪除用戶")
    @DeleteMapping("/delete/{ids}")
    public Result userDeleteById(@PathVariable List<Integer> ids){
        log.info("刪除用戶");
        int i = userService.userDelete(ids);
        if(i>0){
            log.info("刪除成功，刪除了: {}", i);
        }else {
            log.info("刪除失敗");
        }
        return Result.success("刪除成功");
    }

    @Operation(summary = "修改用戶", description = "給管理員修改帳號or使用者更換大頭貼使用")
    @PutMapping("/update")

    public Result userUpdate(
            @Parameter(description = "用户ID", example = "1", required = true) Integer id,
            @Parameter(description = "帳號", example = "abcd5678" )@RequestParam(required = false) String account,
            @Parameter(description = "密碼", example = "12345678")@RequestParam(required = false) String passWord,
            @Parameter(description = "使用者稱謂", example = "九面")@RequestParam(required = false) String userName,
            @Parameter(description = "圖片", example = "1")@RequestParam(required = false) String image,
            @Parameter(description = "用戶等級", example = "1")@RequestParam(required = false) Integer level)

    {
        log.info("修改用戶");
        User user = new User();
        user.setId(id);
        user.setAccount(account);
        user.setPassWord(passWord);
        user.setUserName(userName);
        user.setImage(image);
        user.setLevel(level);
        Result result = userService.userUpdate(user);

        return result;
    }

    @Operation(summary = "查詢所有用戶", description = "無須請求參數")
    @GetMapping("/selectAll")
    public Result userSelectAll(){
        log.info("查詢所有用戶");
        List<User> user = userService.userSelectAll();
        return Result.success(user);
    }

    @Operation(summary = "依照account參數查詢用戶", parameters = {
            @Parameter(name = "account", description = "使用者帳號", example = "john_doe")
    })
    @GetMapping("/selectByAccount/{account}")
    public Result selectById(@PathVariable String account){
        log.info("依照account: {} 查詢用戶", account);
        User user = userService.selectByAccount(account);
        return Result.success(user);
    }
}
