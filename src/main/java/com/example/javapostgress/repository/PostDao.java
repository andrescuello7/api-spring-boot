package com.example.javapostgress.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.javapostgress.models.Post;
import com.example.javapostgress.models.User;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {
  @Query("SELECT p FROM Post p JOIN FETCH p.user")
  ArrayList<Post> findAllWithUsers();

  ArrayList<Post> findAll();
  List<Post> findPostsByUser(User user);
}
