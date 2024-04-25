package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord {

    @Schema(description = "唯一ID", example = "1", required = true)
    Integer userRecordID;

    @Schema(description = "關聯-用戶ID", example = "1", required = true)
    Integer userID;


    @Schema(description = "點心花費", example = "140", required = true)
    Integer snackPrice;

    @Schema(description = "正餐花費", example = "110", required = true)
    Integer dinnerPrice;

    @Schema(description = "用戶當日實際花費", example = "1", required = true)
    Integer userActualPrice;


    @Schema(description = "最後修改人", example = "喜洋洋", required = true)
    Integer lastUpdateBy;

    String createTime;


    String updateTime;
}
