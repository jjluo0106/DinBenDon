package com.heima.mapper;
import com.heima.pojo.TotalOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TotalOrderMapper {

    public void insert(TotalOrder totalOrder);

    int delete(List<Integer> ids);

    int update(TotalOrder totalOrder);

    List<TotalOrder> selectAll();


    TotalOrder selectByID(Integer totalOrderID);
}
