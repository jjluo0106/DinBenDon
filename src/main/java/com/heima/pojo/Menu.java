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

    @Schema(description = "唯一ID", example = "1", required = true)
    Integer menuID;

    @Schema(description = "菜單名稱", example = "五十嵐", required = true)
    String menuName;


    @Schema(description = "添加品價格", example = "1,2,3", required = true)
    String productIDs;


    @Schema(description = "此菜單扣打(點心補助)", example = "150")
    String coda;

    @Schema(description = "發起時間", required = true)
    String startTime;

    @Schema(description = "截止時間", required = true)
    String endTime;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;

    String createTime;


    String updateTime;
}
