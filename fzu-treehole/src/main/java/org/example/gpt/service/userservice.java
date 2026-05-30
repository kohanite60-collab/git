package org.example.gpt.service;

import org.example.gpt.entity.user;
import org.example.gpt.mapper.usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userservice {

    @Autowired
    private usermapper usermapper;

    public List<user> list() {
        return usermapper.list();
    }
    public user get(String name) {
        return usermapper.get(name);
    }
    public int add(user user) {
        return usermapper.add(user);
    }
}
