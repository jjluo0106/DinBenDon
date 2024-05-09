package com.heima.service;

import com.heima.mapper.ConsumerOrderDetailMapper;
import com.heima.pojo.Result;
import com.heima.pojo.ConsumerOrderDetail;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsumerOrderDetailService {

    @Autowired
    ConsumerOrderDetailMapper consumerOrderDetailMapper;

    // 新
    public Result insert(ConsumerOrderDetail consumerOrderDetail) {
        consumerOrderDetailMapper.insert(consumerOrderDetail);
        consumerOrderDetail.setCreateTime(MyUtils.getNow());
        consumerOrderDetail.setUpdateTime(MyUtils.getNow());
        return Result.success("consumerOrderDetail 新增，data: [consumerOrderDetail創建後對象參數]", consumerOrderDetail);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        List<ConsumerOrderDetail> consumerOrderDetails = consumerOrderDetailMapper.selectByIDs(ids); // 刪除前先查詢
        int num = consumerOrderDetailMapper.delete(ids);

        if (num>0){
            return Result.success("consumerOrderDetail 刪除- " + num + "筆，date: [consumerOrderDetail刪除前對象參數]", consumerOrderDetails);
        }else {
            return Result.fail("consumerOrderDetail 刪除- " + num + "筆", "");
        }
    }
    // 修
    public Result update(ConsumerOrderDetail consumerOrderDetail) {
        consumerOrderDetailMapper.update(consumerOrderDetail);
        return Result.success("consumerOrderDetail 依據[id]修改，data: [consumerOrderDetail修改後對象參數]", consumerOrderDetailMapper.selectByID(consumerOrderDetail.getConsumerOrderDetailID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("consumerOrderDetail 依據[id]查詢，data: [consumerOrderDetail查詢對象參數]", consumerOrderDetailMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("consumerOrderDetail 所有查詢，data: [consumerOrderDetail所有查詢對象參數]", consumerOrderDetailMapper.selectAll());
    }
}
