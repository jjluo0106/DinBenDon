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


    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
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

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;

}
