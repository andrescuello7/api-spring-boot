package com.example.javapostgress.services;

import java.util.List;

import com.example.javapostgress.models.User;

public interface UserServices {
  public List<User> findAll();
  public User save(User user);
  public User findById(Long id);
  public void delete(User user);
}
