package com.heima.mapper;
import com.heima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into db1.t_user(userID, account, passWord, phone, userName, image, level, createTime, updateTime)\n" +
            "        values (\n" +
            "        null, #{account}, #{passWord}, #{phone}, #{userName}, #{image}, #{level}, NOW(), NOW()\n" +
            "        )")
    @Options(useGeneratedKeys = true, keyProperty = "userID", keyColumn = "userID")
    public void insert(User user);

    int delete(List<Integer> ids);

    int update(User user);

    List<User> selectAll();

    User selectByAccount(String account);

    User selectByID(Integer userID);

    List<User> selectByIDs(List<Integer> ids);
}
