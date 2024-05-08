package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ShopRelated {

    @Schema(description = "2.Shop店家資訊", required = true)
    Shop shop;

    @Schema(description = "3.Product產品資訊", required = true)
    List<Product> products;


    @Schema(description = "4.Add添加&備註", required = true)
    List<Add> adds;

}
