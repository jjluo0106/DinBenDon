package com.heima.service;

import com.heima.mapper.AdminMadeOrderMapper;
import com.heima.pojo.Result;
import com.heima.pojo.AdminMadeOrder;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminMadeOrderService {

    @Autowired
    AdminMadeOrderMapper adminMadeOrderMapper;

    // 新
    public Result insert(AdminMadeOrder adminMadeOrder) {
        adminMadeOrderMapper.insert(adminMadeOrder);
        adminMadeOrder.setCreateTime(MyUtils.getNow());
        adminMadeOrder.setUpdateTime(MyUtils.getNow());
        return Result.success("adminMadeOrder 新增，data: [adminMadeOrder創建後對象參數]", adminMadeOrder);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        List<AdminMadeOrder> adminMadeOrders = adminMadeOrderMapper.selectByIDs(ids); // 刪除前先查詢
        int num = adminMadeOrderMapper.delete(ids);

        if (num>0){
            return Result.success("adminMadeOrder 刪除- " + num + "筆，date: [adminMadeOrder刪除前對象參數]", adminMadeOrders);
        }else {
            return Result.fail("adminMadeOrder 刪除- " + num + "筆", "");
        }
    }
    // 修
    public Result update(AdminMadeOrder adminMadeOrder) {
        adminMadeOrderMapper.update(adminMadeOrder);
        return Result.success("adminMadeOrder 依據[id]修改，data: [adminMadeOrder修改後對象參數]", adminMadeOrderMapper.selectByID(adminMadeOrder.getAdminMadeOrderID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("adminMadeOrder 依據[id]查詢，data: [adminMadeOrder查詢對象參數]", adminMadeOrderMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("adminMadeOrder 所有查詢，data: [adminMadeOrder所有查詢對象參數]", adminMadeOrderMapper.selectAll());
    }
}
