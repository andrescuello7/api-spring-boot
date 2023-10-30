package com.example.javapostgress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javapostgress.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
  Optional<User> findOneByUsername(String username);
  Optional<User> findOneByEmail(String email);
  List<User> findAll();
  User save(User user);
  void delete(User user);
}
