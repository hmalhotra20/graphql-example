package com.example.poc.model;

import lombok.Data;

@Data
public class CreatePostInput {
    String title;
    String content;
    Long authorId;
}
