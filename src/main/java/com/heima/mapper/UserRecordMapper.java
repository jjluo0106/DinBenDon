package com.heima.mapper;
import com.heima.pojo.UserRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserRecordMapper {

    @Insert("        insert into db1.t_userRecord(userID, snackPrice, dinnerPrice, userActualPrice, isPaid, lastUpdateBy, createTime, updateTime)\n" +
            "        values (\n" +
            "                             #{userID}, #{snackPrice}, #{dinnerPrice}, #{userActualPrice}, #{isPaid}, #{lastUpdateBy}, NOW(), NOW()\n" +
            "        )")
    @Options(useGeneratedKeys = true, keyProperty = "userRecordID", keyColumn = "userRecordID")
    public void insert(UserRecord userRecord);

    int delete(List<Integer> ids);

    int update(UserRecord userRecord);

    List<UserRecord> selectAll();


    UserRecord selectByID(Integer userRecordID);
}
