package com.example.javapostgress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javapostgress.models.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {
  List<Post> findAll();
}
