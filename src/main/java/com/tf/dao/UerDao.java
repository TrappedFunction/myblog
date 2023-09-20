package com.tf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tf.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UerDao extends BaseMapper<User> {
    @Insert("insert into user (username, account, password, salt) values (#{username},#{account},#{password},#{salt})")
    void insertAll(User user);

    @Select("select password from myblog.user where account = #{account}")
    String selectByAccount(String account);
    @Select("select salt from myblog.user where account = #{account}")
    String selectSaltByAccount(String account);


}
