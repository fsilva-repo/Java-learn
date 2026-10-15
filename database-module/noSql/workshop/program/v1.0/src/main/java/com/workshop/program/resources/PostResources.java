package com.workshop.program.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.program.domain.Post;
import com.workshop.program.domain.User;
import com.workshop.program.services.PostService;
import com.workshop.program.services.UserService;

@RestController
@RequestMapping(value = "/posts/{userid}")
public class PostResources {

  private PostService postService;
  private UserService userService;

  public PostResources(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }


  @GetMapping
  public ResponseEntity<List<Post>> findPosts(@PathVariable String userid) {
    User user = userService.findById(userid);
    return ResponseEntity.ok().body(user.getPosts());
  }

  @GetMapping("/{postId}")
  public ResponseEntity<Post> findById(@PathVariable String postId) {
    Post post = postService.findById(postId);
    return ResponseEntity.ok().body(post);
  }
}