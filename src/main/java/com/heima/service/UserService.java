package com.heima.service;

import com.heima.mapper.UserMapper;
import com.heima.pojo.Result;
import com.heima.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;




    // 新

    public Result UserInsert(User user) {
        Result validate = user.validate();
        if ("1".equals(validate.getData())) {
            userMapper.userInsert(user);
            return Result.success("創建成功");
        } else {
            return validate;
        }

    }

    // 刪

    public int userDelete(List<Integer> ids) {
        return userMapper.userDelete(ids);
    }
    // 修

    public Result userUpdate(User user) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //要先確定account是否存在
        User user1 = userMapper.selectByID(user.getUserID());
        if (user1.getUserID() == null) {
            log.info("user1 : {}", user1);
            return Result.errorWrongFormat("userID為空");
        }
        if (user.getAccount() != null && !user.getAccount().matches(emailRegex)) {
            return Result.errorWrongFormat("account格式不符");
        }
        if (user.getPassWord() != null && !isPassWordLegal(user.getPassWord() ) ) {
            return Result.error("密碼格式錯誤");
        }

        userMapper.userUpdate(user);
        return Result.success("修改成功");
    }
    //查

    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    public List<User> userSelectAll() {
        return userMapper.userSelectAll();
    }


    private boolean isPassWordLegal(String passWord) {
        int passWordMin = 8;
        int passWordMax = 15;
        String passWordIllegalMessage = "密碼格式錯誤！";


        if (passWord.length() < passWordMin || passWord.length() > passWordMax) {
            log.info(passWordIllegalMessage);
            return false;
        }
        return true;
    }
}
