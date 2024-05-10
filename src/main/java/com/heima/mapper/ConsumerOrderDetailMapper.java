package com.heima.mapper;

import com.heima.pojo.ConsumerOrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface ConsumerOrderDetailMapper {


    @Insert("insert into db1.t_consumerorderdetail(consumerOrderDetailID, consumerOrderListID, productID, addIDs, amount, remark, lastUpdateBy, createTime, updateTime)  " +
                                                         "values (null, #{consumerOrderListID}, #{productID}, #{addIDs}, #{amount}, #{remark}, #{lastUpdateBy}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "consumerOrderDetailID", keyColumn = "consumerOrderDetailID")
    int insert(ConsumerOrderDetail consumerOrderDetail);


    int delete(List<Integer> ids);

    int update(ConsumerOrderDetail consumerOrderDetail);

    List<ConsumerOrderDetail> selectAll();

    ConsumerOrderDetail selectByConsumerOrderDetailName(String account);

    ConsumerOrderDetail selectByID(Integer consumerOrderDetailID);

    List<ConsumerOrderDetail> selectByOrderListID(Integer orderListID);
}
