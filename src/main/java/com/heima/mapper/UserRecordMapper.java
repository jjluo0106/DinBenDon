package com.heima.mapper;
import com.heima.pojo.UserRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRecordMapper {

    public void insert(UserRecord userRecord);

    int delete(List<Integer> ids);

    int update(UserRecord userRecord);

    List<UserRecord> selectAll();


    UserRecord selectByID(Integer userRecordID);
}
