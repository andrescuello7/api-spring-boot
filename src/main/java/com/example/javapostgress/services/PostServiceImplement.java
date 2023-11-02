package com.example.javapostgress.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javapostgress.models.Post;
import com.example.javapostgress.repository.PostDao;

import jakarta.transaction.Transactional;

@Service
public class PostServiceImplement implements PostServices {
  @Autowired
  private PostDao postDao;

  @Override
  @Transactional
  public ArrayList<Post> findAll() {
    ArrayList<Post> find = postDao.findAll();
    for (Post post : find) {
      System.out.println(post.getUser().getId());
    }
    return find;
  }

  @Override
  @Transactional
  public Post save(Post post) {
    return postDao.save(post);
  }
}
