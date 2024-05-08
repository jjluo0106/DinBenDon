package com.heima.service;

import com.heima.mapper.UserMapper;
import com.heima.pojo.Result;
import com.heima.pojo.User;
import com.heima.util.MyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
        if (!account.matches(regexForEmail)) {
            return Result.fail("帳號不合法: 非e-mail格式", "");
        }
        if (!passWord.matches(regexForPassword)) {
            return Result.fail("密碼長度需為8~15個字符", "");
        }

        User userCheck = userMapper.selectByAccount(account);
        log.info("較驗是否有重複帳號: {}", userCheck);

        if (userCheck != null) {
            return Result.fail("重複的帳號名稱", "");
        }
        userMapper.insert(user);

        user.setCreateTime(MyUtils.getNow());
        user.setUpdateTime(MyUtils.getNow());

        return Result.success("user 新增，data: [user創建後對象參數]", user);
    }

    // 刪
    public Result delete(List<Integer> ids) {

        List<User> users = userMapper.selectByIDs(ids); // 刪除前先查詢
        int num = userMapper.delete(ids);

        if (num>0){
            return Result.success("user 刪除- " + num + "筆，date: [user刪除前對象參數]", users);
        }else {
            return Result.fail("user 刪除- " + num + "筆", "");
        }
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
        if (user.getPassWord() != null && !isPassWordLegal(user.getPassWord())) {
            return Result.error("密碼格式錯誤");
        }

        userMapper.update(user);
        return Result.success("user 依據[id]修改，data: [user修改後對象參數]", userMapper.selectByID(user.getUserID()));
    }

    //查
    public Result selectByAccount(String account) {
        return Result.success("user 依據[account]查詢，data: [user查詢對象參數]", userMapper.selectByAccount(account));
    }

    public Result userSelectAll() {
        return Result.success("user 所有查詢，data: [user所有查詢對象參數]", userMapper.selectAll());
    }


    private boolean isPassWordLegal(String passWord) {
        int passWordMin = 8;
        int passWordMax = 15;

        if (passWord.length() < passWordMin || passWord.length() > passWordMax) {

            return false;
        }
        return true;
    }
}
