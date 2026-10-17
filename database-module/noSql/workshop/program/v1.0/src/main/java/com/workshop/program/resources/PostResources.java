package com.workshop.program.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.program.domain.Post;
import com.workshop.program.domain.User;
import com.workshop.program.services.PostService;
import com.workshop.program.services.UserService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

  private PostService postService;
  private UserService userService;

  public PostResources(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }


  @GetMapping("/{userId}")
  public ResponseEntity<List<Post>> findPosts(@PathVariable String userId) {
    User user = userService.findById(userId);
    return ResponseEntity.ok().body(user.getPosts());
  }

  @GetMapping("/user/{postId}")
  public ResponseEntity<Post> findById(@PathVariable String postId) {
    Post post = postService.findById(postId);
    return ResponseEntity.ok().body(post);
  }

  @GetMapping("/title")
  public ResponseEntity<List<Post>> findByIdTitle(@RequestParam(value = "text", defaultValue = "") String text) {
    List<Post> list = postService.fyndByTitle(text);
    return ResponseEntity.ok().body(list);
  }
}