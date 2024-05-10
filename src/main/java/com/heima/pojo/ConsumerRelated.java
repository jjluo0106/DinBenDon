package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ConsumerRelated {

    @Schema(description = "6.ConsumerOrderList消費者訂單", required = true)
    ConsumerOrderList consumerOrderList;

    @Schema(description = "7.ConsumerOrderDetail", required = true)
    List<ConsumerOrderDetail> consumerOrderDetail;


}
