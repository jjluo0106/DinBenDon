package com.heima.mapper;
import com.heima.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {

    public void shopInsert(Shop shop);

    int shopDelete(List<Integer> ids);

    int shopUpdate(Shop shop);

    List<Shop> shopSelectAll();

    Shop selectByShopName(String account);

    Shop selectByID(Integer shopID);
}
