package com.heima.service;

import com.heima.mapper.ConsumerOrderListMapper;
import com.heima.pojo.Result;
import com.heima.pojo.ConsumerOrderList;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsumerOrderListService {

    @Autowired
    ConsumerOrderListMapper consumerOrderListMapper;

    // 新
    public Result insert(ConsumerOrderList consumerOrderList) {
        consumerOrderListMapper.insert(consumerOrderList);
        consumerOrderList.setCreateTime(MyUtils.getNow());
        consumerOrderList.setUpdateTime(MyUtils.getNow());
        return Result.success("consumerOrderList 新增，data: [consumerOrderList創建後對象參數]", consumerOrderList);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        List<ConsumerOrderList> consumerOrderLists = consumerOrderListMapper.selectByIDs(ids); // 刪除前先查詢
        int num = consumerOrderListMapper.delete(ids);

        if (num>0){
            return Result.success("consumerOrderList 刪除- " + num + "筆，date: [consumerOrderList刪除前對象參數]", consumerOrderLists);
        }else {
            return Result.fail("consumerOrderList 刪除- " + num + "筆", "");
        }
    }
    // 修
    public Result update(ConsumerOrderList consumerOrderList) {
        consumerOrderListMapper.update(consumerOrderList);
        return Result.success("consumerOrderList 依據[id]修改，data: [consumerOrderList修改後對象參數]", consumerOrderListMapper.selectByID(consumerOrderList.getConsumerOrderListID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("consumerOrderList 依據[id]查詢，data: [consumerOrderList查詢對象參數]", consumerOrderListMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("consumerOrderList 所有查詢，data: [consumerOrderList所有查詢對象參數]", consumerOrderListMapper.selectAll());
    }
}
