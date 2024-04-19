package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Schema(description = "訂單唯一ID", example = "1", required = true)
    Integer id;

    @Schema(description = "用戶ID", example = "1", required = true)
    String userId;



    @Schema(description = "餐廳ID-食物ID(備註，加料)x數量,", example = "珍珠奶茶", required = true)
    String message;

    @Schema(description = "數量", example = "2", required = true)
    String count;

    @Schema(description = "預定時間", example = "2024-04-15 13:00:00", required = true)
    String bookingTime;

    String createTime;

    String updateTime;
}
