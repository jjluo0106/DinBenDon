package com.heima.service;

import com.heima.mapper.ShopMapper;
import com.heima.pojo.Shop;
import com.heima.pojo.Result;
import com.heima.pojo.User;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    // 新
    public Result insert(Shop shop) {
        shopMapper.insert(shop);
        shop.setCreateTime(MyUtils.getNow());
        shop.setUpdateTime(MyUtils.getNow());
        return Result.success("shop 新增，data: [shop創建後對象參數]", shop);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        List<Shop> shops = shopMapper.selectByIDs(ids); // 刪除前先查詢
        int num = shopMapper.delete(ids);

        if (num>0){
            return Result.success("shop 刪除- " + num + "筆，date: [shop刪除前對象參數]", shops);
        }else {
            return Result.fail("shop 刪除- " + num + "筆", "");
        }
    }
    // 修
    public Result update(Shop shop) {
        shopMapper.update(shop);
        return Result.success("shop 依據[id]修改，data: [shop修改後對象參數]", shopMapper.selectByID(shop.getShopID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("shop 依據[id]查詢，data: [shop查詢對象參數]", shopMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("shop 所有查詢，data: [shop所有查詢對象參數]", shopMapper.selectAll());
    }
}
