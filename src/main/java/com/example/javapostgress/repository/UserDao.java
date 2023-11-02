package com.example.javapostgress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javapostgress.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
  List<User> findAll();
  void delete(User user);
}
