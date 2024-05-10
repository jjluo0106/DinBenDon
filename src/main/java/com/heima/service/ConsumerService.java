package com.heima.service;

import com.heima.mapper.*;
import com.heima.pojo.*;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    AddMapper addMapper;
    @Autowired
    AdminMadeOrderMapper adminMadeOrderMapper;
    @Autowired
    ConsumerOrderListMapper consumerOrderListMapper;
    @Autowired
    ConsumerOrderDetailMapper consumerOrderDetailMapper;


    //------------------------新----------------------------
    /**
     * 新增-消費者訂單與明細
     */
    public Result consumerRelatedInsert(ConsumerRelated consumerRelated) {
        log.info("進入consumerRelatedInsert程序...");

        ConsumerOrderList consumerOrderList = consumerRelated.getConsumerOrderList();
        List<ConsumerOrderDetail> consumerOrderDetails = consumerRelated.getConsumerOrderDetail();
        int listPrice = 0;

        // List
        for (ConsumerOrderDetail orderDetail : consumerOrderDetails) {
            // 收集金額
            int detailPrice = 0;
            //  產品
            Integer productID = orderDetail.getProductID();
            Product product = productMapper.selectByID(productID);
            detailPrice += product.getPrice();
            //  添加物
            String addIDs = orderDetail.getAddIDs();

            String[] addIDArr;
            if (addIDs != null) {
                addIDArr = addIDs.split(",");
            }else continue;

            for (String addIDStr : addIDArr) {
                int addID = Integer.parseInt(addIDStr);
                detailPrice += addMapper.selectByID(addID).getPrice();
            }

            detailPrice *= orderDetail.getAmount(); // 成以數量
            log.info("{} 金額為: {}", product.getProductName(), detailPrice);
            listPrice += detailPrice;
        }
        consumerRelated.getConsumerOrderList().setPrice(listPrice);



        consumerOrderListMapper.insert(consumerOrderList);

        Integer consumerOrderListID = consumerOrderList.getConsumerOrderListID();
        Integer lastUpdateBy = consumerOrderList.getLastUpdateBy();

        // Detail
        for (ConsumerOrderDetail orderDetail : consumerOrderDetails) {
            orderDetail.setConsumerOrderListID(consumerOrderListID);
            orderDetail.setLastUpdateBy(lastUpdateBy);
            consumerOrderDetailMapper.insert(orderDetail);



        }
        consumerRelated.getConsumerOrderList().setCreateTime(MyUtils.getNow());
        consumerRelated.getConsumerOrderList().setUpdateTime(MyUtils.getNow());

        // 金額



        return Result.success("consumerRelated 新增，data: [創建對象參數]", consumerRelated);
    }



    //------------------------查----------------------------

    /**
     * 查詢 消費者訂單與明細
     */
    public Result selectConsumerRelatedByOrderListID(Integer orderListID) {

        ConsumerRelated consumerRelated = new ConsumerRelated();

        // ConsumerOrderList
        ConsumerOrderList consumerOrderList = consumerOrderListMapper.selectByID(orderListID);
        consumerRelated.setConsumerOrderList(consumerOrderList);

        // ConsumerOrderDetails
        List<ConsumerOrderDetail> consumerOrderDetails = consumerOrderDetailMapper.selectByOrderListID(orderListID);
        consumerRelated.setConsumerOrderDetail(consumerOrderDetails);


        return Result.success("shop-products-adds 查詢，data: 查詢對象參數", consumerRelated);
    }

}
