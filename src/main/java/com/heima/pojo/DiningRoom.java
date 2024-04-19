package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiningRoom {


    @Schema(description = "餐廳唯一ID", example = "1", required = true)
    Integer id;

    @Schema(description = "店家ID", example = "五十嵐", required = true)
    String diningRoomId;

    @Schema(description = "地址", example = "匯豐大樓")
    String address;

    @Schema(description = "電話", example = "0911166119")
    String phoneNum;

    @Schema(description = "店家圖片展示", example = "http://example.com/avatar.jpg")
    String image;


    String createTime;


    String updateTime;
}
