package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Add {

    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer addID;

    @Schema(description = "關聯-店家ID: 此ID店家唯一使用表示", example = "1")
    Integer shopID;

    @Schema(description = "添加&備註描述", example = "加珍珠", required = true)
    String description;

    @Schema(description = "添加品價格 : 可為0", example = "10", required = true)
    Integer price;

    @Schema(description = "產品底價", example = "60")
    String image;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;
}
