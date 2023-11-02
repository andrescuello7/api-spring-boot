package com.example.javapostgress.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.javapostgress.models.User;
import com.example.javapostgress.services.UserServiceImplement;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserServiceImplement userService;

  @GetMapping(value = "/users")
  public ResponseEntity<Object> get() {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      List<User> users = userService.findAll();
      return new ResponseEntity<Object>(users, HttpStatus.OK);
    } catch (Exception e) {
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value = "/users/{id}")
  public ResponseEntity<Object> getById(@PathVariable Long id) {
    try {
      User user = userService.findById(id);      
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
      return ResponseEntity.created(uri).body(user);
    } catch (Exception e) {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(value = "/users")
  public ResponseEntity<Object> create(@RequestBody User user) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {
      User response = userService.save(user);
      return new ResponseEntity<Object>(response, HttpStatus.OK);
    } catch (Exception e) {
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(value = "/users/{id}")
  public ResponseEntity<Object> update(@RequestBody User user, @PathVariable Long id) {
  Map<String, Object> map = new HashMap<String, Object>();
    try {
      User currentUser = userService.findById(id);

      currentUser.setUsername(user.getUsername());
      currentUser.setPhone(user.getPhone());
      currentUser.setEmail(user.getEmail());
      currentUser.setPassword(user.getPassword());

      User response = userService.save(user);
      return new ResponseEntity<Object>(response, HttpStatus.OK);
    } catch (Exception e) {
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(value = "/users/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
  Map<String, Object> map = new HashMap<String, Object>();
    try {
      User currentUser = userService.findById(id);
      userService.delete(currentUser);
      map.put("deleted", true);
      return new ResponseEntity<Object>(map, HttpStatus.OK);
    } catch (Exception e) {
      map.put("message", e.getMessage());
      return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
