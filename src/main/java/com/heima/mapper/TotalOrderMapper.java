package com.heima.mapper;
import com.heima.pojo.TotalOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface TotalOrderMapper {

    @Insert("        insert into db1.t_totalOrder(price, isClear, lastUpdateBy, createTime, updateTime)\n" +
            "        values (\n" +
            "                             #{price}, #{isClear}, #{lastUpdateBy}, NOW(), NOW()\n" +
            "        )")
    @Options(useGeneratedKeys = true, keyProperty = "totalOrderID", keyColumn = "totalOrderID")
    public void insert(TotalOrder totalOrder);

    int delete(List<Integer> ids);

    int update(TotalOrder totalOrder);

    List<TotalOrder> selectAll();


    TotalOrder selectByID(Integer totalOrderID);
}
