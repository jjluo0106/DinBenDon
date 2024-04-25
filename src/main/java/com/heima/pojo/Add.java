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

    @Schema(description = "唯一ID", example = "1", required = true)
    Integer addID;

    @Schema(description = "添加&備註描述", example = "加珍珠", required = true)
    String description;


    @Schema(description = "添加品價格", example = "10", required = true)
    Integer price;


    @Schema(description = "產品底價", example = "60")
    String image;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;


    String createTime;


    String updateTime;
}
