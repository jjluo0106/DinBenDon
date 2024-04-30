package com.heima.mapper;
import com.heima.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    public void insert(Menu menu);

    int delete(List<Integer> ids);

    int update(Menu menu);

    List<Menu> selectAll();


    Menu selectByID(Integer menuID);
}
