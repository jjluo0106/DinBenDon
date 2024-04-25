package com.heima.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

//    @Schema(description = "唯一ID", example = "1", required = true)
    Integer productID;

    @Schema(description = "關聯-店家ID", example = "1", required = true)
    Integer shopID;

    @Schema(description = "關聯-添加&備註", example = "1,2,3", required = true)
    String addIDs;

    @Schema(description = "產品名稱", example = "珍珠奶茶", required = true)
    String productName;


    @Schema(description = "產品底價", example = "60")
    Integer price;

    @Schema(description = "正餐還是點心:1=正餐,2=點心", example = "2")
    Integer productType;

    @Schema(description = "產品底價", example = "60")
    String image;

    @Schema(description = "最後修改人ID", example = "1", required = true)
    Integer lastUpdateBy;

    String createTime;

    String updateTime;
}
