package com.heima.mapper;
import com.heima.pojo.UserOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOrderMapper {

    public void insert(UserOrder userOrder);

    int delete(List<Integer> ids);

    int update(UserOrder userOrder);

    List<UserOrder> selectAll();


    UserOrder selectByID(Integer userOrderID);
}
