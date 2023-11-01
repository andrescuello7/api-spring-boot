package com.example.javapostgress.services;

import java.util.List;

import com.example.javapostgress.models.Post;

public interface PostServices {
  public List<Post> findAll();
  public Post save(Post post);
}
