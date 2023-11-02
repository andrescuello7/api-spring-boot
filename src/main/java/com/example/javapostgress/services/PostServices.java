package com.example.javapostgress.services;

import java.util.ArrayList;

import com.example.javapostgress.models.Post;

public interface PostServices {
  public ArrayList<Post> findAll();
  public Post save(Post post);
}
