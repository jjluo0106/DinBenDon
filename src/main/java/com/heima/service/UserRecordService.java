package com.heima.service;

import com.heima.mapper.UserRecordMapper;
import com.heima.pojo.Result;
import com.heima.pojo.UserRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserRecordService {

    @Autowired
    UserRecordMapper userRecordMapper;


    // 新

    public Result insert(UserRecord userRecord) {

        userRecordMapper.insert(userRecord);
        return Result.success("創建成功");

    }

    // 刪

    public int delete(List<Integer> ids) {
        return userRecordMapper.delete(ids);
    }
    // 修

    public Result update(UserRecord userRecord) {


        userRecordMapper.update(userRecord);
        return Result.success("修改成功");
    }
    //查

    public UserRecord selectByID(Integer userRecordID) {
        return userRecordMapper.selectByID(userRecordID);
    }

    public List<UserRecord> selectAll() {
        return userRecordMapper.selectAll();
    }


}
