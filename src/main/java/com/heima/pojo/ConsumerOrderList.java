package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerOrderList {


    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer consumerOrderListID;

    @Schema(description = "關聯-使用者ID", example = "1", required = true)
    Integer userID;

    @Schema(description = "關聯-管理員發起訂單ID", example = "1", required = true)
    Integer adminMadeOrderID;

    @Schema(description = "訂單總金額 : 整合UserOrderDetail的總金額", example = "300", required = true)
    String price;

    @Schema(description = "使用者是否已付款", example = "2024-05-08 18:18:00", required = true)
    Integer isPaid;

    @Schema(description = "備註", example = "我的珍奶不要加珍珠")
    String remark;

    @Schema(description = "最後修改人", example = "1")
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;

}
