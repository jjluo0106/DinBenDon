package com.heima.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Schema(description = "用戶ID", example = "1", required = true)
    Integer userID;

    @Schema(description = "e-mail=帳號", example = "abc666666@gmail.com", required = true)
    String account;

    @Schema(description = "密碼", example = "papa12123", required = true)
    String passWord;

    @Schema(description = "手機", example = "0912345678", required = true)
    String phone;

    @Schema(description = "使用者名稱", example = "周楚", required = false)
    String userName;

    @Schema(description = "大頭貼", example = "http://example.com/avatar.jpg")
    String image;

    @Schema(description = "等級", example = "1", required = true)
    Integer level;


    String createTime;


    String updateTime;

    public Result validate() {
        //account
        if (account == null) {
            return Result.errorMissingParameter("account");
        } else if (account.length() < 8) {
            return Result.errorParameterTooShort("account", 8);
        } else if (account.length() > 15) {
            return Result.errorParameterTooLong("account", 15);
        }
        //passWord
        else if (passWord == null) {
            return Result.errorMissingParameter("passWord");
        } else if (passWord.length() < 8) {
            return Result.errorParameterTooShort("passWord", 8);
        } else if (passWord.length() > 15) {
            return Result.errorParameterTooLong("passWord", 15);
        }
        //level
        else if (level == null) {
            return Result.errorMissingParameter("level");
        } else if (level != 1 && level != 2) {
            return Result.errorWrongFormat("level");
        }
        return Result.success("1");
    }

}
