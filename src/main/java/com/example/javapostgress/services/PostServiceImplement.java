package com.example.javapostgress.services;

import java.util.List;

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
  public List<Post> findAll() {
    return postDao.findAll();
  }

  @Override
  @Transactional
  public Post save(Post post) {
    return postDao.save(post);
  }
}
