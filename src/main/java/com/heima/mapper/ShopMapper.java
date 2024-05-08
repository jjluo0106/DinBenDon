package com.heima.mapper;

import com.heima.pojo.Shop;
import com.heima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface ShopMapper {


    @Insert("insert into db1.t_shop(shopID, shopName, phone, address, image, lastUpdateBy, createTime, updateTime) values (null, #{shopName}, #{phone}, #{address}, #{image}, #{lastUpdateBy}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "shopID", keyColumn = "shopID")
    int insert(Shop shop);


    int delete(List<Integer> ids);

    int update(Shop shop);

    List<Shop> selectAll();

    Shop selectByShopName(String account);

    Shop selectByID(Integer shopID);

    List<Shop> selectByIDs(List<Integer> ids);
}
