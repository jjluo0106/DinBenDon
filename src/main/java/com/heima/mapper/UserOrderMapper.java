package com.heima.mapper;
import com.heima.pojo.UserOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserOrderMapper {

    @Insert("        insert into db1.t_userOrder(userID,   menuID,   productID,   addIDs,lastUpdateBy, createTime, updateTime)\n" +
            "        values (\n" +
            "                             #{userID},#{menuID},#{productID},#{addIDs},#{lastUpdateBy}, NOW(), NOW()\n" +
            "        )")
    @Options(useGeneratedKeys = true, keyProperty = "userOrderID", keyColumn = "userOrderID")
    public void insert(UserOrder userOrder);

    int delete(List<Integer> ids);

    int update(UserOrder userOrder);

    List<UserOrder> selectAll();


    UserOrder selectByID(Integer userOrderID);
}
