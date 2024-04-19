package com.heima.service;

import com.heima.mapper.UserMapper;
import com.heima.pojo.Result;
import com.heima.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Result UserInsert(User user) {
        Result validate = user.validate();
        if("1".equals(validate.getData() ) ){
            userMapper.userInsert(user);
            return Result.success("創建成功");
        }else {
            return validate;
        }

    }

    public List<User> userSelectAll() {
        return userMapper.userSelectAll();
    }

    public int userDelete(List<Integer> ids) {
        return userMapper.userDelete(ids);
    }

    public Result userUpdate(User user) {
        //要先確定account是否存在
        if(user.getAccount().length() < 8 && user.getAccount().length() > 15){
            return Result.errorWrongFormat("account長度不正確");
        }
        userMapper.userUpdate(user);
        return Result.success("修改成功");
    }

    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
