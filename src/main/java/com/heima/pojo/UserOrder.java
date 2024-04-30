package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder {

    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer userOrderID;

    @Schema(description = "關聯-使用者ID", example = "1", required = true)
    Integer userID;

    @Schema(description = "關聯-發起菜單ID", example = "1", required = true)
    Integer menuID;

    @Schema(description = "關聯-產品ID", example = "1,2,3", required = true)
    Integer productID;

    @Schema(description = "關聯-添加&備註IDs", example = "1,2,3", required = true)
    String addIDs;


    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;
}
