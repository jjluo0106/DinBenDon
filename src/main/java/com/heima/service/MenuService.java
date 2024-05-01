package com.heima.service;

import com.heima.mapper.MenuMapper;
import com.heima.pojo.Menu;
import com.heima.pojo.Result;
import com.heima.util.MyUtils;
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
        menu.setCreateTime(MyUtils.getNow());
        menu.setUpdateTime(MyUtils.getNow());
        return Result.success("menu 新增，data: [menu創建後對象參數]", menu);
    }
    // 刪
    public Result delete(List<Integer> ids) {
        int i = menuMapper.delete(ids);
        if(i>0){
            return Result.success("menu 刪除，data: [刪除數量]", i);
        }else {
            return Result.success("無匹配id",i);
        }
    }
    // 修
    public Result update(Menu menu) {
        menuMapper.update(menu);
        return Result.success("menu 依據[id]修改，data: [menu修改後對象參數]", menuMapper.selectByID(menu.getMenuID()));
    }
    //查
    public Result selectByID(Integer id) {
        return Result.success("menu 依據[id]查詢，data: [menu查詢對象參數]", menuMapper.selectByID(id));
    }
    //查所有
    public Result selectAll() {
        return Result.success("menu 所有查詢，data: [menu所有查詢對象參數]", menuMapper.selectAll());
    }
}
