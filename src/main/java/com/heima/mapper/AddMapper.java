package com.heima.mapper;

import com.heima.pojo.Add;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface AddMapper {

    //    @Options(useGeneratedKeys = true, keyProperty = "addID")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "addID", before = false, resultType = int.class)
//    @Insert("insert into db1.t_add(description, price, image, lastUpdateBy, createTime, updateTime) " +
//            "values (#{description}, #{price}, #{image}, #{lastUpdateBy}, NOW(), NOW())")
    @Insert("insert into db1.t_add(shopID, description, price, image, lastUpdateBy, createTime, updateTime) " +
            "values (#{shopID}, #{description}, #{price}, #{image}, #{lastUpdateBy}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "addID", keyColumn = "addID")
    int insert(Add add);


//    int insert(Add add);

    int delete(List<Integer> ids);

    int update(Add add);

    List<Add> selectAll();

    List<Add> selectByAddName(String account);

    Add selectByID(Integer addID);

    List<Add> selectAllByShopID(Integer shopID);
}
