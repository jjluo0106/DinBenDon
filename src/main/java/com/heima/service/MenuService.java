package com.heima.service;

import com.heima.mapper.MenuMapper;
import com.heima.pojo.Menu;
import com.heima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;


    // 新

    public Result insert(Menu menu) {

        menuMapper.insert(menu);
        return Result.success("創建成功");

    }

    // 刪

    public int delete(List<Integer> ids) {
        return menuMapper.delete(ids);
    }
    // 修

    public Result update(Menu menu) {


        menuMapper.update(menu);
        return Result.success("修改成功");
    }
    //查

    public Menu selectByID(Integer menuID) {
        return menuMapper.selectByID(menuID);
    }

    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }


}
