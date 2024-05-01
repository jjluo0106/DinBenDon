package com.heima.mapper;
import com.heima.pojo.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Insert("        insert into db1.t_menu(menuName,   productIDs,   coda,   startTime,   endTime,lastUpdateBy, createTime, updateTime)\n" +
            "        values (\n" +
            "                             #{menuName},#{productIDs},#{coda},#{startTime},#{endTime},#{lastUpdateBy}, NOW(), NOW()\n" +
            "        )")
    @Options(useGeneratedKeys = true, keyProperty = "menuID", keyColumn = "menuID")
    public void insert(Menu menu);

    int delete(List<Integer> ids);

    int update(Menu menu);

    List<Menu> selectAll();


    Menu selectByID(Integer menuID);
}
