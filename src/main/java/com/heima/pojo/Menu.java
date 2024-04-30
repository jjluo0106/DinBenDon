package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer menuID;

    @Schema(description = "菜單名稱", example = "五十嵐", required = true)
    String menuName;


    @Schema(description = "添加品價格", example = "1,2,3", required = true)
    String productIDs;


    @Schema(description = "此菜單扣打(點心補助)", example = "150")
    String coda;

    @Schema(description = "發起時間: 訂單開放給用戶下單的(顯示)時間", example = "2024-04-19 20:00:00", required = true)
    String startTime;

    @Schema(description = "截止時間: 用戶下單的最後時間", example = "2024-04-21 15:00:00", required = true)
    String endTime;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;
}
