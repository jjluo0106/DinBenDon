package com.heima.mapper;

import com.heima.pojo.AdminMadeOrder;
import com.heima.pojo.ConsumerOrderList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface AdminMadeOrderMapper {


    @Insert("insert into db1.t_adminmadeorder1(adminMadeOrderID, shopID, orderName, coda, startTime, endTime, isGetAllMoney, isPaid, totalPrice, remark, lastUpdateBy, createTime, updateTime) " +
                                             "values (null, #{shopID}, #{orderName}, #{coda}, #{startTime}, #{endTime}, #{isGetAllMoney}, #{isPaid}, #{totalPrice}, #{remark}, #{lastUpdateBy}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "adminMadeOrderID", keyColumn = "adminMadeOrderID")
    int insert(AdminMadeOrder adminMadeOrder);


    int delete(List<Integer> ids);

    int update(AdminMadeOrder adminMadeOrder);

    List<AdminMadeOrder> selectAll();

    AdminMadeOrder selectByAdminMadeOrderName(String account);

    AdminMadeOrder selectByID(Integer adminMadeOrderID);

    List<AdminMadeOrder> selectByIDs(List<Integer> ids);

    List<AdminMadeOrder> selectByAdminMadeOrderID(Integer adminMadeOrderID);
}
