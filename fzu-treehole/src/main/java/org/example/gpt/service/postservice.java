package org.example.gpt.service;

import org.example.gpt.entity.post;
import org.example.gpt.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postservice {

    @Autowired
    private PostMapper postMapper;

    // 发帖
    public void insert(post post) {
        postMapper.insert(post);
    }

    // 查全部
    public List<post> list() {
        return postMapper.selectAll();
    }

    // 按标题查
    public List<post> search(String title) {
        return postMapper.selectByTitle(title);
    }
}
