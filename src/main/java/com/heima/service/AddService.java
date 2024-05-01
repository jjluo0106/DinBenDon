package com.heima.service;

import com.heima.mapper.AddMapper;
import com.heima.pojo.Add;
import com.heima.pojo.Result;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddService {

    @Autowired
    AddMapper addMapper;

    // 新
    public Result insert(Add add) {
        addMapper.insert(add);
        add.setCreateTime(MyUtils.getNow());
        add.setUpdateTime(MyUtils.getNow());
        return Result.success("add 新增，data: [add創建後對象參數]", add);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        int i = addMapper.delete(ids);
        if(i>0){
            return Result.success("add 刪除，data: [刪除數量]", i);
        }else {
            return Result.success("無匹配id",i);
        }
    }
    // 修
    public Result update(Add add) {
        addMapper.update(add);
        return Result.success("add 依據[id]修改，data: [add修改後對象參數]", addMapper.selectByID(add.getAddID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("add 依據[id]查詢，data: [add查詢對象參數]", addMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("add 所有查詢，data: [add所有查詢對象參數]", addMapper.selectAll());
    }
}
