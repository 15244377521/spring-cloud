package com.hellodemopeer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author Niclas
 * @create 2019-03-30-13:49
 */
@Mapper
public interface GetUserDao {

    @Select("select * from test where id=#{id}")
    Map<String,Object> getUser(@Param("id")String id);
}
