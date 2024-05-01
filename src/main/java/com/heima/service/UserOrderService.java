package com.heima.service;

import com.heima.mapper.UserOrderMapper;
import com.heima.pojo.UserOrder;
import com.heima.pojo.Result;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserOrderService {

    @Autowired
    UserOrderMapper userOrderMapper;


    // 新

    public Result insert(UserOrder userOrder) {

        userOrderMapper.insert(userOrder);
        userOrder.setCreateTime(MyUtils.getNow());
        userOrder.setUpdateTime(MyUtils.getNow());
        return Result.success("userOrder 創建成功", userOrder);

    }

    // 刪

    public int delete(List<Integer> ids) {
        return userOrderMapper.delete(ids);
    }
    // 修

    public Result update(UserOrder userOrder) {


        userOrderMapper.update(userOrder);
        return Result.success("修改成功");
    }
    //查

    public UserOrder selectByID(Integer userOrderID) {
        return userOrderMapper.selectByID(userOrderID);
    }

    public List<UserOrder> selectAll() {
        return userOrderMapper.selectAll();
    }


}
