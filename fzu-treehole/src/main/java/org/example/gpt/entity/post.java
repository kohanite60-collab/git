package org.example.gpt.entity;

import lombok.Data;

@Data
public class post {

    private Integer id;
    private String title;
    private String content;
    private Integer userId;
}