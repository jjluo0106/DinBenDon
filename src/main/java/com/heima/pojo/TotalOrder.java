package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalOrder {

    @Schema(description = "唯一ID", example = "1", required = true)
    Integer totalOrderID;

    @Schema(description = "管理員當日總花費", example = "1600", required = true)
    Integer price;


    @Schema(description = "是否結清: 未結清=0, 結清=1", example = "1", required = true)
    Integer isClear;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;


    String createTime;


    String updateTime;
}
