package com.example.javapostgress.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javapostgress.models.Post;
import com.example.javapostgress.models.User;
import com.example.javapostgress.repository.PostDao;
import com.example.javapostgress.repository.UserDao;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImplement implements UserServices {
  @Autowired
  private UserDao userDao;
  @Autowired
  private PostDao postDao;

  @Override
  @Transactional
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Override
  @Transactional
  public User save(User user) {
    return userDao.save(user);
  }

  @Override
  @Transactional
  public User findById(Long id) {
    return userDao.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public void delete(User user) {
    userDao.delete(user);
  }
}
