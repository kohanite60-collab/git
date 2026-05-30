package org.example.gpt.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.gpt.entity.user;

import java.util.List;

@Mapper
public interface usermapper {
    @Select("select * from man")
    List<user> list();
    @Select("select * from man where name = #{name} LIMIT 1")
    user get(String name);
    @Insert("insert into man (name, password) values (#{name}, #{password})")
    int add(user user);
}
