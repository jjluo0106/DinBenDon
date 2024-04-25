package com.heima.mapper;
import com.heima.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public void userInsert(User user);

    int userDelete(List<Integer> ids);

    int userUpdate(User user);

    List<User> userSelectAll();

    User selectByAccount(String account);

    User selectByID(Integer userID);
}
