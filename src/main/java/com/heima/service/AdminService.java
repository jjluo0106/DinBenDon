package com.heima.service;

import com.heima.mapper.*;
import com.heima.pojo.*;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdminService {

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    AddMapper addMapper;
    @Autowired
    MenuMapper menuMapper;

    /**
     * 新增 Object2to4
     */
    public Result add234(Object2to4 object2To4) {
        log.info("進入createMenuByOne程序...");
        List<Product> products = object2To4.getProducts();
        List<Add> adds = object2To4.getAdds();
        Map<String, String> mapK_addIDandV_des = new HashMap<>();


        Integer lastUpdateBy = object2To4.getShop().getLastUpdateBy(); //*
        // Shop
        shopMapper.insert(object2To4.getShop());
        object2To4.getShop().setCreateTime(MyUtils.getNow());
        object2To4.getShop().setUpdateTime(MyUtils.getNow());
        log.info("獲取ShopID : {}", object2To4.getShop().getShopID());
        Integer shopID = object2To4.getShop().getShopID(); //*

        log.info("adds.size有: {} 個", adds.size());
        // Adds
        for (int i = 0; i < adds.size(); i++) {
            Add add = adds.get(i);
            add.setAddID(shopID);
            add.setLastUpdateBy(lastUpdateBy);
            addMapper.insert(add);
            int addID = add.getAddID();
            log.info("獲取addID: {}", addID);
            // 組裝 addID+description鍵值對
            mapK_addIDandV_des.put(String.valueOf(addID), add.getDescription()); //**
        }
        log.info("adds鍵值對 : {}", mapK_addIDandV_des.toString());


        log.info("products.size有: {} 個", products.size());
        // Products
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            product.setShopID(shopID); // 主鍵未知不用填，統一交由後端給值
            product.setLastUpdateBy(lastUpdateBy);
            // 改造 addIDs內容: 加珍珠,加椰果 -> 1.2
            String tempDesToAddID = product.getAddIDs();
            String[] tempDesSplit = tempDesToAddID.split(",");
            String addIDs = "";
            ArrayList<Integer> list = new ArrayList<>();
            for (Map.Entry<String, String> entry : mapK_addIDandV_des.entrySet()) {
                String id = entry.getKey();
                String description = entry.getValue();
//                tempDesToAddID = tempDesToAddID.replaceAll(description, id);

                for (int i1 = 0; i1 < tempDesSplit.length; i1++) {
                    log.info("{} 跟 {} 比較", tempDesSplit[i1], description);
                    if (tempDesSplit[i1].equals(description)) {
                        log.info("添加id : {}", id);
                        list.add(Integer.parseInt(id));
                    }
                }
            }
            Collections.sort(list);
            log.info("list : {}", list);
            addIDs = list.stream().map(String::valueOf).collect(Collectors.joining(","));
            log.info("addIDs :{}", addIDs);
            product.setAddIDs(addIDs);

            log.info("product : {}",product);

            productMapper.insert(product);
        }


        return Result.success("shop-products-adds 新增，data: 創建對象參數", object2To4);
    }

    /**
     * 查詢 Object2to4
     */
    public Result select234ByShopID(Integer shopID) {

        Object2to4 object2to4 = new Object2to4();

        // Shop
        Shop shop = shopMapper.selectByID(shopID);
        object2to4.setShop(shop);

        // Product
        List<Product> products = productMapper.selectByShopID(shopID);
        object2to4.setProducts(products);

        // Add
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) { // 收集addID
            String addIDs = products.get(i).getAddIDs();
            String[] addIDsSplit = addIDs.split(",");
            for (int j = 0; j < addIDsSplit.length; j++) {
                list.add(Integer.parseInt(addIDsSplit[j]));
            }
        }
        Collections.sort(list);
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());

        ArrayList<Add> addList = new ArrayList<>();

        for (int i = 0; i < collect.size(); i++) {
            Add add = addMapper.selectByID(collect.get(i));
            addList.add(add);
        }
        object2to4.setAdds(addList);

        return Result.success("shop-products-adds 查詢，data: 查詢對象參數", object2to4);
    }
}
