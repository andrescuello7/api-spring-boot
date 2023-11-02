package com.example.javapostgress.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javapostgress.models.Post;
import com.example.javapostgress.repository.PostDao;
import com.example.javapostgress.repository.UserDao;

import jakarta.transaction.Transactional;

@Service
public class PostServiceImplement implements PostServices {
  @Autowired
  private PostDao postDao;
  @Autowired
  private UserDao userDao;

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
