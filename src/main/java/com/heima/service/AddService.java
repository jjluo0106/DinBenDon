package com.heima.service;

import com.heima.mapper.AddMapper;
import com.heima.mapper.AddMapper;
import com.heima.pojo.Add;
import com.heima.pojo.Result;
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
        return Result.success("創建成功");

    }

    // 刪

    public int delete(List<Integer> ids) {
        return addMapper.delete(ids);
    }
    // 修

    public Result update(Add add) {


        addMapper.update(add);
        return Result.success("修改成功");
    }
    //查

    public List<Add> selectByAddName(String account) {
        return addMapper.selectByAddName(account);
    }

    public List<Add> selectAll() {
        return addMapper.selectAll();
    }


}
