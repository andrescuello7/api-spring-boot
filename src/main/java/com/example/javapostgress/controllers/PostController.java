package com.example.javapostgress.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javapostgress.models.Post;
import com.example.javapostgress.services.PostServiceImplement;

@RestController
@RequestMapping("/api")
public class PostController {

  @Autowired
  private PostServiceImplement postService;

  @GetMapping(value = "/posts")
  public ResponseEntity<Object> get() {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      List<Post> users = postService.findAll();
      return new ResponseEntity<Object>(users, HttpStatus.OK);
    } catch (Exception e) {
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(value = "/posts")
  public ResponseEntity<Object> create(@RequestBody Post post) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      Post response = postService.save(post);
      return new ResponseEntity<Object>(response, HttpStatus.OK);
    } catch (Exception e) {
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
