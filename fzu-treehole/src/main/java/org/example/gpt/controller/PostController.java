package org.example.gpt.controller;

import org.example.gpt.common.Result;
import org.example.gpt.entity.post;
import org.example.gpt.service.postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class PostController {

    @Autowired
    private postservice postService;

    // 1️⃣ 发帖接口
    @PostMapping("/post")
    public Result<String> add(@RequestBody post post) {

        postService.insert(post);

        return Result.success("发帖成功");
    }

    // 2️⃣ 查询所有帖子
    @GetMapping("/posts")
    public Result<List<post>> list() {

        return Result.success(postService.list());
    }

    // 3️⃣ 按标题查询
    @GetMapping("/posts/search")
    public Result<List<post>> search(@RequestParam String title) {

        return Result.success(postService.search(title));
    }
}