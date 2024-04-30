package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer shopID;

    @Schema(description = "店名", example = "7-11", required = true)
    String shopName;

    @Schema(description = "電話", example = "0912345678", required = true)
    String phone;

    @Schema(description = "地址", example = "0912345678", required = true)
    String address;


    @Schema(description = "店家圖片", example = "http://example.com/avatar.jpg")
    String image;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;


    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;
}
