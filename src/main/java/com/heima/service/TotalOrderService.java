package com.heima.service;

import com.heima.mapper.TotalOrderMapper;
import com.heima.pojo.Result;
import com.heima.pojo.TotalOrder;
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
        return Result.success("創建成功");

    }

    // 刪

    public int delete(List<Integer> ids) {
        return totalOrderMapper.delete(ids);
    }
    // 修

    public Result update(TotalOrder totalOrder) {


        totalOrderMapper.update(totalOrder);
        return Result.success("修改成功");
    }
    //查

    public TotalOrder selectByID(Integer totalOrderID) {
        return totalOrderMapper.selectByID(totalOrderID);
    }

    public List<TotalOrder> selectAll() {
        return totalOrderMapper.selectAll();
    }


}
