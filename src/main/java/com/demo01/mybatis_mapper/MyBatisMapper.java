package com.demo01.mybatis_mapper;

import com.demo01.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyBatisMapper {

    @Select("select * from user " +
            "where username like CONCAT ('%',#{username},'%')" +
            "or id = #{id}")
    public List<User> findByLike(String username, Long id);
}
