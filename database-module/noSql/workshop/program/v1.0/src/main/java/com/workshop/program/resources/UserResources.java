package com.workshop.program.resources;

import java.util.ArrayList;
import java.util.List;
import com.workshop.program.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/users")
public class UserResources {

  @GetMapping  
  public ResponseEntity<List<User>> findUsers() {
    // test
    User maria = new User("13" ,"Maria", "maria@gmail.com");
    User malou = new User("12" ,"Marlou", "marlou@gmail.com");
    User maia = new User("14" ,"Maia", "maia@gmail.com");
    User lee = new User("15" ,"Lee", "lee@gmail.com");
    List<User> list = new ArrayList<>();
    list.add(lee);
    list.add(maria);
    list.add(malou);
    list.add(maia);

    return ResponseEntity.ok().body(list);
  }
}
