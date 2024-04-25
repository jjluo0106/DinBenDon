package com.heima.service;

import com.heima.mapper.ShopMapper;
import com.heima.mapper.ShopMapper;
import com.heima.pojo.Result;
import com.heima.pojo.Shop;
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

    public Result shopInsert(Shop shop) {

            shopMapper.shopInsert(shop);
            return Result.success("創建成功");

    }

    // 刪

    public int shopDelete(List<Integer> ids) {
        return shopMapper.shopDelete(ids);
    }
    // 修

    public Result shopUpdate(Shop shop) {


        shopMapper.shopUpdate(shop);
        return Result.success("修改成功");
    }
    //查

    public Shop selectByShopName(String account) {
        return shopMapper.selectByShopName(account);
    }

    public List<Shop> shopSelectAll() {
        return shopMapper.shopSelectAll();
    }


    private boolean isPassWordLegal(String passWord) {
        int passWordMin = 8;
        int passWordMax = 15;
        String passWordIllegalMessage = "密碼格式錯誤！";


        if (passWord.length() < passWordMin || passWord.length() > passWordMax) {
            log.info(passWordIllegalMessage);
            return false;
        }
        return true;
    }
}
