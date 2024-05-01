package com.heima.service;

import com.heima.mapper.TotalOrderMapper;
import com.heima.pojo.TotalOrder;
import com.heima.pojo.Result;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TotalOrderService {

    @Autowired
    TotalOrderMapper totalOrderMapper;

    // 新
    public Result insert(TotalOrder totalOrder) {
        totalOrderMapper.insert(totalOrder);
        totalOrder.setCreateTime(MyUtils.getNow());
        totalOrder.setUpdateTime(MyUtils.getNow());
        return Result.success("totalOrder 新增，data: [totalOrder創建後對象參數]", totalOrder);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        int i = totalOrderMapper.delete(ids);
        if(i>0){
            return Result.success("totalOrder 刪除，data: [刪除數量]", i);
        }else {
            return Result.success("無匹配id",i);
        }
    }
    // 修
    public Result update(TotalOrder totalOrder) {
        totalOrderMapper.update(totalOrder);
        return Result.success("totalOrder 依據[id]修改，data: [totalOrder修改後對象參數]", totalOrderMapper.selectByID(totalOrder.getTotalOrderID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("totalOrder 依據[id]查詢，data: [totalOrder查詢對象參數]", totalOrderMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("totalOrder 所有查詢，data: [totalOrder所有查詢對象參數]", totalOrderMapper.selectAll());
    }
}
