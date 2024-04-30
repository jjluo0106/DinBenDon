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

        String account = user.getAccount();
        String passWord = user.getPassWord();

        String regexForEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String regexForPassword = "^.{8,15}$";

        log.info("account :" + account);
        log.info("passWord :" + passWord);
        if(!account.matches(regexForEmail)){
            return Result.fail("帳號不合法: 非e-mail格式","");
        }
        if(!passWord.matches(regexForPassword)){
            return Result.fail("密碼長度需為8~15個字符","");
        }


        User user1 = userMapper.selectByAccount(account);
        log.info("較驗是否有重複帳號: {}",user1);

        if(user1 != null){
            return Result.fail("重複的帳號名稱","");
        }
        userMapper.userInsert(user);
        return Result.success("使用者創建成功");
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
