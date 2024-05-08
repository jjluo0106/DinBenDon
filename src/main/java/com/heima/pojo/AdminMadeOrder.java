package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminMadeOrder {


    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer adminMadeOrderID;

    @Schema(description = "關聯-店家ID", example = "1", required = true)
    Integer shopID;

    @Schema(description = "訂單名稱", example = "24/4/18鼎泰豐菜單", required = true)
    String orderName;

    @Schema(description = "此菜單扣打(點心補助)", example = "150", required = true)
    String coda;

    @Schema(description = "發起時間 : 訂單開放給用戶下單的(顯示)時間", example = "2024-05-08 18:18:00", required = true)
    String startTime;

    @Schema(description = "截止時間 : 用戶下單的最後時間", example = "2024-05-13 18:18:00")
    String endTime;

    @Schema(description = "管理員收款狀態 : 0=未收款,1=已收款", example = "0", required = true)
    Integer isGetAllMoney;

    @Schema(description = "管理員付款狀態 : 0=未收款,1=已收款", example = "0", required = true)
    Integer isPaid;

    @Schema(description = "訂單總金額 : 0=未收款,1=已收款", example = "16888", required = true)
    Integer totalPrice;

    @Schema(description = "備註", example = "這家點心好吃！！", required = false)
    Integer remark;

    @Schema(description = "最後修改人", example = "1")
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;

}
