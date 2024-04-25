package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Schema(description = "店家ID", example = "1", required = true)
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


    String createTime;


    String updateTime;
}
