package com.heima.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDetail {


    @Schema(description = "＜唯一ID＞: 新增-皆不填，系統將自動產生/ 修改-必填", example = "1")
    Integer userOrderDetailID;

    @Schema(description = "關聯-用戶下定訂單ID", example = "1", required = true)
    Integer userOrderListID;

    @Schema(description = "關聯-產品資訊ID", example = "1", required = true)
    Integer productID;

    @Schema(description = "關聯-添加&備註ID", example = "1", required = true)
    String addIDs;

    @Schema(description = "數量", example = "2", required = true)
    Integer amount;

    @Schema(description = "備註", example = "我的珍奶不要加珍珠")
    String remark;

    @Schema(description = "最後修改人", example = "1")
    Integer lastUpdateBy;

    @Schema(description = "創建時間: 自動產生皆不用填", example = "", required = false)
    String createTime;

    @Schema(description = "更新時間: 自動產生皆不用填", example = "", required = false)
    String updateTime;

}
