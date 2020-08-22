package com.oocl.eParking.controller;

import com.oocl.eParking.entity.User;
import com.oocl.eParking.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{userId}")
  public User getUserInfo(@PathVariable int userId) {
    return userService.getUserInfo(userId);
  }
}
