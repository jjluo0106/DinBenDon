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
        List<Add> adds = addMapper.selectByIDs(ids); // 刪除前先查詢
        int num = addMapper.delete(ids);

        if (num>0){
            return Result.success("add 刪除- " + num + "筆，date: [add刪除前對象參數]", adds);
        }else {
            return Result.fail("add 刪除- " + num + "筆", "");
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
