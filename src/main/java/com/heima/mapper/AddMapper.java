package com.heima.mapper;
import com.heima.pojo.Add;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddMapper {

    public void insert(Add add);

    int delete(List<Integer> ids);

    int update(Add add);

    List<Add> selectAll();

    List<Add> selectByAddName(String account);

    Add selectByID(Integer productID);
}
