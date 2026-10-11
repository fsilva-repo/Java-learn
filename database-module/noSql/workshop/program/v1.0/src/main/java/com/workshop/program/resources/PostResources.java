package com.workshop.program.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workshop.program.domain.Post;
import com.workshop.program.domain.User;
import com.workshop.program.services.PostService;
import com.workshop.program.services.UserService;

@Controller
@RequestMapping(value = "/users/posts/{id}")
public class PostResources {

  private PostService postService;
  private UserService userService;

  
  public PostResources(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }


  @GetMapping  
  public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
    User user = userService.findById(id);
    return ResponseEntity.ok().body(user.getPosts());
  }
}