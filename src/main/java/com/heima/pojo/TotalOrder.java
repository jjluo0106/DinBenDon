package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalOrder {

    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer totalOrderID;

    @Schema(description = "管理員當日總花費", example = "1600", required = true)
    Integer price;


    @Schema(description = "是否結清: 未結清=0, 結清=1", example = "1", required = true)
    Integer isClear;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;
}
