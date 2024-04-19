package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Schema(description = "菜單唯一ID", example = "1", required = true)
    Integer id;

    @Schema(description = "關聯店家Id", example = "1", required = true)
    String diningRoomId;

    @Schema(description = "食物Id", example = "珍珠奶茶", required = true)
    String foodId;

    @Schema(description = "底價", example = "60", required = true)
    String BasePrice;

    @Schema(description = "展示圖片", example = "http://example.com/avatar.jpg")
    String image;

    @Schema(description = "備註-if食物:1,小辣,中辣,大辣/" +
                               "if飲料:2,去冰,微冰;無糖,微糖" +
                               ",是同個選單;需增加不同選單展示", example = "2,去冰,微冰;無糖,微糖")
    String remark;


    @Schema(description = "加料-珍珠:10,豆花:5" +
                          ":價錢,視同個選單", example = "珍珠:10,豆花:5")
    String material;


    String createTime;


    String updateTime;
}
