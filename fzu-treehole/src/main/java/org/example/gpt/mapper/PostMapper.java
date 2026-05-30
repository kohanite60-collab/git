package org.example.gpt.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.gpt.entity.post;
import org.example.gpt.entity.post;

import java.util.List;

@Mapper
public interface PostMapper {

    // 1️⃣ 插入帖子
    @Insert("INSERT INTO post (title, content, user_id) VALUES (#{title}, #{content}, #{userId})")
    void insert(post post);

    // 2️⃣ 查询全部帖子
    @Select("SELECT * FROM post")
    List<post> selectAll();

    // 3️⃣ 按标题模糊查询
    @Select("SELECT * FROM post WHERE title LIKE CONCAT('%', #{title}, '%')")
    List<post> selectByTitle(String title);
}