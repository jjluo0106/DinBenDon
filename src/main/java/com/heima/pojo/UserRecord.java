package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord {

    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer userRecordID;

    @Schema(description = "關聯-用戶ID", example = "1", required = true)
    Integer userID;

    @Schema(description = "點心花費", example = "140", required = true)
    Integer snackPrice;

    @Schema(description = "正餐花費", example = "110", required = true)
    Integer dinnerPrice;

    @Schema(description = "用戶當日實際花費", example = "1", required = true)
    Integer userActualPrice;

    @Schema(description = "是否已繳費 :0=未繳,1=已繳(不用繳費也為1)", example = "1", required = true)
    Integer isPaid;

    @Schema(description = "最後修改人", example = "喜洋洋", required = true)
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;
}
