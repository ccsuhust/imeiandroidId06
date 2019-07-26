package com.gtja.ydpt.imei.androidId.dao;


import com.gtja.ydpt.imei.androidId.model.Collect;
import com.gtja.ydpt.imei.androidId.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/*
* private int id;
    private String imei;
    private String androidID;
    private String deviceInfo;
    private String androidSystemVersion;
    private String jhVersion;
    private String createTime;
    private String updateTime;
* */
@Component
@Mapper
public interface CollectDao {
    String TABLE_NAME = " collect ";
    String INSERT_FIELD = " imei,androidID,deviceInfo,androidSystemVersion,jhVersion,createTime,updateTime ";
    String SELECT_FIELD = " id,name,password,salt,head_url ";
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELD,")"," values "," (#{imei},#{androidID},#{deviceInfo},#{androidSystemVersion},#{jhVersion},#{createTime},#{updateTime})"})
    int addCollect(Collect collect);

//    @Update({"update user set password = #{password} where id = #{id}"})
//    int updateUser(User user);
//
//    @Select({"select ",SELECT_FIELD," from ",TABLE_NAME," where id = #{id}"})
//    User selectUserById(int id);
//
//    @Select({"select ",SELECT_FIELD," from ",TABLE_NAME," where name = #{name}"})
//    User selectUserByName(String name);
//
//    @Delete({"delete from ",TABLE_NAME," where id = #{id}"})
//    int delectUser(int id);



}
