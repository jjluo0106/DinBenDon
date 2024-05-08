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
    AdminMadeOrderMapper adminMadeOrderMapper;

    //------------------------新----------------------------
    /**
     * 新增 Object2to4
     */
    public Result add234(ShopRelated shopRelated) {
        log.info("進入createMenuByOne程序...");
        List<Product> products = shopRelated.getProducts();
        List<Add> adds = shopRelated.getAdds();
        Map<String, String> mapK_addIDandV_des = new HashMap<>();


        Integer lastUpdateBy = shopRelated.getShop().getLastUpdateBy(); //*
        // Shop
        shopMapper.insert(shopRelated.getShop());
        shopRelated.getShop().setCreateTime(MyUtils.getNow());
        shopRelated.getShop().setUpdateTime(MyUtils.getNow());
        log.info("獲取ShopID : {}", shopRelated.getShop().getShopID());
        Integer shopID = shopRelated.getShop().getShopID(); //*

        log.info("adds.size有: {} 個", adds.size());
        // Adds
        for (int i = 0; i < adds.size(); i++) {
            Add add = adds.get(i);
            add.setShopID(shopID);
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

        return Result.success("shop-products-adds 新增，data: [創建對象參數]", shopRelated);
    }


    /**
     * 新增-管理員發起訂單
     */
    public Result addAdminMadeOrder(AdminMadeOrder adminMadeOrder) {
        adminMadeOrderMapper.insert(adminMadeOrder);
        return Result.success("adminMadeOrder 新增，data: [創建對象參數]", adminMadeOrderMapper.selectByID(adminMadeOrder.getAdminMadeOrderID()));
    }


    //------------------------查----------------------------

    /**
     * 查詢 Object2to4
     */
    public Result select234ByShopID(Integer shopID) {

        ShopRelated object2to4 = new ShopRelated();

        // Shop
        Shop shop = shopMapper.selectByID(shopID);
        object2to4.setShop(shop);

        // Product
        List<Product> products = productMapper.selectByShopID(shopID);
        object2to4.setProducts(products);

        // Add
        List<Add> adds = addMapper.selectAllByShopID(shopID);

        object2to4.setAdds(adds);

        return Result.success("shop-products-adds 查詢，data: 查詢對象參數", object2to4);
    }


    public Result selectAdminMadeOrderById() {
        return Result.success("adminMadeOrder 查詢，data: 查詢對象參數", adminMadeOrderMapper.selectAll());
    }
}
