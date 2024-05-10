package com.heima.mapper;

import com.heima.pojo.ConsumerOrderList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface ConsumerOrderListMapper {


    @Insert("insert into db1.t_consumerorderlist(consumerOrderListID, userID, adminMadeOrderID, price, isPaid, remark, lastUpdateBy, createTime, updateTime) " +
                                                     "values (null, #{userID}, #{adminMadeOrderID}, #{price}, #{isPaid}, #{remark}, #{lastUpdateBy}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "consumerOrderListID", keyColumn = "consumerOrderListID")
    int insert(ConsumerOrderList consumerOrderList);


    int delete(List<Integer> ids);

    int update(ConsumerOrderList consumerOrderList);

    List<ConsumerOrderList> selectAll();

    ConsumerOrderList selectByConsumerOrderListName(String account);

    ConsumerOrderList selectByID(Integer consumerOrderListID);

    List<ConsumerOrderList> selectByIDs(List<Integer> ids);

    List<ConsumerOrderList> selectByAdminMadeOrderID(Integer adminMadeOrderID);
}
