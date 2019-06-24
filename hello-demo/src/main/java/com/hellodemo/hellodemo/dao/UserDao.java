package com.hellodemo.hellodemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author Niclas
 * @create 2019-03-27-17:22
 */
@Mapper
public interface UserDao {

    @Select("select * from test t where t.id=#{id}")
    Map<String,Object> getUser(@Param("id")String id);
}
